package com.qbao.recommend.stream.kafka.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.qbao.recommend.stream.cmp.enums.PlatformType;
import com.qbao.recommend.stream.cmp.enums.SourceType;
import com.qbao.recommend.stream.cmp.enums.TopicType;
import com.qbao.recommend.stream.cmp.handler.IHandler;
import com.qbao.recommend.stream.cmp.parser.KafkaParser;
import com.qbao.recommend.stream.cmp.parser.KafkaParserFacotry;
import com.qbao.recommend.stream.cmp.util.KafkaConstantUtil;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;

@Path("kafka")
@Component
@Service
public class KafkaConsumerService  implements IKafkaConsumerService {
    public Logger kafkaInfoLogger = LoggerManagerUtil.getLogger(LogNameEnum.kafka, Level.INFO);
    public Logger kafkaWarnLogger = LoggerManagerUtil.getLogger(LogNameEnum.kafka, Level.WARN);
    public Logger kafkaErrorLogger = LoggerManagerUtil.getLogger(LogNameEnum.kafka, Level.ERROR);
    
    @Value("${zookeeper_connect}")
    private String zookeeper = "";
    @Value("${zookeeper_timeout}")
    private String zookeeper_timeout = "";
    @Value("${zookeeper_syns}")
    private String zookeeper_sync_timeout = "";
    @Value("${kafka_group}")
    private String kafka_group = "";
    @Value("${kafka_interval}")
    private String kafka_interval = "";
    @Value("${kafka_max_retries}")
    private String kafka_max_retries;
    @Value("${kafka_back_time}")
    private String kafka_bakc_timeout;

    private Map<String, ConsumerConnector> consumerPools = Maps.newConcurrentMap();

    @Autowired
    @Qualifier("monitorHandlerImpl")
    private IHandler monitorHandlerImpl;

    @Autowired
    @Qualifier("recommendHandleImpl")
    private IHandler recommendHandleImpl;

    @GET
    @Path("start")
    @Override
    public void start(@QueryParam(value = "topic") String topic, @QueryParam(value = "source") String source, @QueryParam(value = "platform") String platform) {
        kafkaWarnLogger.warn("try to start kafka service for topic=" + topic + ", source type=" + source + ", platformType=" + platform);

        PlatformType platformType = PlatformType.asPlatformType(platform);
        SourceType sourceType = SourceType.asSourceType(source);
        Preconditions.checkNotNull(platformType, platform + " is not defined  in PlatformType ");
        TopicType topicType = TopicType.asTopicType(topic);
        Preconditions.checkNotNull(topicType, topic + " is not defined  in TopicType ");
        IHandler handler = selectHandler(topicType);
        Preconditions.checkNotNull(handler, "can't get handler by topic : " + topic);

        KafkaParser<?> parser = KafkaParserFacotry.getParser(topicType);
        Preconditions.checkNotNull(parser, "can't get parser by totopicTypepic : " + topicType);
        handler.setParser(parser);

        String key = getConsumerKey(topic, source, platform);
        ConsumerConnector consumer = getConsumerByKey(key);
        try {
            kafkaWarnLogger.warn("接受kafka参数:" + zookeeper + ":" + zookeeper_timeout + ":" + kafka_group + ":" + topic);
            Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
            // 一次只取一条数据,如果这里要取多条数据的话,需要使用多线程进行读取
            topicCountMap.put(topic, new Integer(1));
            Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
            // 每次只获取一条数据
            KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);
            kafkaWarnLogger.warn("kafka流式数据转换:" + stream);
            ConsumerIterator<byte[], byte[]> it = stream.iterator();
            while (it.hasNext()) {
                MessageAndMetadata<byte[], byte[]> message = it.next();
                int partition = message.partition();
                long offset = message.offset();
                String msg = new String(message.message());
                kafkaWarnLogger.warn("kafka消费基本消息记录:" + "paration:" + partition + "," + "\t" + "offset:" + offset);
                boolean successed = handler.process(msg);
                if (!successed) {
                    kafkaErrorLogger.error("message [" + msg + "] can't be handled by handler ");
                }
            }
        } catch (Exception e) {
            kafkaErrorLogger.error(ExceptionUtils.getFullStackTrace(e));
            //sendInfo("kafka实时消费队列数据出现错误", ExceptionUtils.getFullStackTrace(e));
        }
    }

    @GET
    @Path("stop")
    @Override
    public boolean shutdown(@QueryParam(value = "topic") String topic, @QueryParam(value = "source") String source, @QueryParam(value = "platform") String platform) {
        kafkaWarnLogger.warn("try to stop kafka service for topic=" + topic + ", source type=" + source + ", platform Type=" + platform);
        String key = getConsumerKey(topic, source, platform);
        if (consumerPools.containsKey(key)) {
            consumerPools.get(key).shutdown();
            consumerPools.remove(key);
            kafkaWarnLogger.warn("try to stop kafka service for topic=" + topic + ", source type=" + source + ", platform Type=" + platform + " is done!");
            return true;
        } else {
            kafkaWarnLogger.warn("kafka service for topic=" + topic + ", source type=" + source + ", platformType=" + platform + " is not start");
            return false;
        }
    }

    /**
     * 初始化消费者配置
     * 
     * @return
     */
    private ConsumerConnector initConsumer() {
        Properties props = new Properties();
        props.put(KafkaConstantUtil.ZOOKEEPER_CONNECT, zookeeper);
        props.put(KafkaConstantUtil.KAFKA_GROUP, kafka_group);
        props.put(KafkaConstantUtil.ZOOKEEPER_INTERVAL_TIME, kafka_interval);
        props.put(KafkaConstantUtil.ZOOKEEPER_SYNC_TIMEOUT, zookeeper_sync_timeout);
        props.put(KafkaConstantUtil.ZOOKEEPER_TIMEOUT, zookeeper_timeout);
        props.put(KafkaConstantUtil.KAFKA_SERIALIZER_CLASS, "kafka.serializer.StringEncoder");
        props.put("rebalance.max.retries", "5");
        props.put("rebalance.backoff.ms", "1200");
        ConsumerConfig config = new ConsumerConfig(props);
        ConsumerConnector consumer = kafka.consumer.Consumer.createJavaConsumerConnector(config);
        return consumer;
    }

    private ConsumerConnector getConsumerByKey(String key) {
        if (!consumerPools.containsKey(key)) {
            ConsumerConnector consumer = initConsumer();
            consumerPools.put(key, consumer);
            kafkaWarnLogger.warn("kafaka consumer key=" + key + " , is not in consumer pools");
            kafkaWarnLogger.warn("初始化consumer:" + consumer.toString());
        }
        return consumerPools.get(key);
    }

    private String getConsumerKey(String topic, String source, String platform) {
        return StringUtils.trimToEmpty(topic) + "_" + StringUtils.trimToEmpty(source) + "_" + StringUtils.trimToEmpty(platform);
    }

    private IHandler selectHandler(TopicType topicType) {
        IHandler handler = null;
        switch (topicType) {
        case NGIX_WEB:
            handler = recommendHandleImpl;
            break;
        case MONITOR_BC_PRODUCT_STATUS_TOPIC:
        case MONITOR_MER_SPU_STATUS_TOPIC:
            handler = monitorHandlerImpl;
            break;
        }
        return handler;
    }
}

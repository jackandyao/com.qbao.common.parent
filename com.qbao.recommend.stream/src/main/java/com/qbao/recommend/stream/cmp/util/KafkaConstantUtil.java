package com.qbao.recommend.stream.cmp.util;

public class KafkaConstantUtil {
    /**
     * kafka常量
     */
    public final static String   ZOOKEEPER_CONNECT="zookeeper.connect";
    public final static String   KAFKA_GROUP="group.id";
    public final static String   ZOOKEEPER_TIMEOUT="zookeeper.session.timeout.ms";
    public final static String   ZOOKEEPER_SYNC_TIMEOUT="zookeeper.sync.time.ms";
    public final static String   ZOOKEEPER_INTERVAL_TIME="auto.commit.interval.ms";
    public final static String   KAFKA_SERIALIZER_CLASS="serializer.class";
    public final static String   KAFKA_MAX_RETRIES="rebalance.max.retries";
    public final static String   KAFKA_BACK_TIMEOUT="rebalance.backoff.ms";
}

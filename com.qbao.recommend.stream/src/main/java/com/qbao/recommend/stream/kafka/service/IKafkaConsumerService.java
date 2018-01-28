package com.qbao.recommend.stream.kafka.service;

/**
 * KAKFA消费服务
 * 
 * @author 贾红平
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
public interface IKafkaConsumerService {

    void start(String topic, String source, String platform);

    boolean shutdown(String topic, String source, String platform);
}

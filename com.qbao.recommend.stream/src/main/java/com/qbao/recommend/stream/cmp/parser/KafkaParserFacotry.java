/**
 * 
 */
package com.qbao.recommend.stream.cmp.parser;

import com.qbao.recommend.stream.cmp.enums.TopicType;
import com.qbao.recommend.stream.cmp.parser.binlog.BcProductBinLogParser;
import com.qbao.recommend.stream.cmp.parser.binlog.MerSpuBinLogParser;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
public class KafkaParserFacotry {

    public static KafkaParser<?> getParser(TopicType topicType) {
        KafkaParser<?> kafkaParser = null;
        switch (topicType) {
        case NGIX_WEB: {
            kafkaParser = new NginxParser(topicType);
            break;
        }
        case MONITOR_BC_PRODUCT_STATUS_TOPIC: {
            kafkaParser = new BcProductBinLogParser(topicType);
            break;
        }
        case MONITOR_MER_SPU_STATUS_TOPIC: {
            kafkaParser = new MerSpuBinLogParser(topicType);
            break;
        }

        }
        
        return kafkaParser;
    }
}

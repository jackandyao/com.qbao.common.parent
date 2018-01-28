/**
 * 
 */
package com.qbao.recommend.stream.cmp.parser;

import org.apache.log4j.Logger;

import com.qbao.recommend.stream.cmp.enums.EventType;
import com.qbao.recommend.stream.cmp.enums.TopicType;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
public abstract class KafkaParser<T> {
    public static final Logger logger = Logger.getLogger(KafkaParser.class);
    private TopicType topicType;

    public KafkaParser(TopicType topicType) {
        this.topicType = topicType;
    }

    public KafkaParser() {
    }

    public abstract T parse(String line);

    public abstract EventType getEventType();

    public TopicType getTopicType() {
        return topicType;
    }

}

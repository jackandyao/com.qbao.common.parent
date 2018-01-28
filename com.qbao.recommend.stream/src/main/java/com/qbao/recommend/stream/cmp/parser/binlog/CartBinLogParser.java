/**
 * 
 */
package com.qbao.recommend.stream.cmp.parser.binlog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qbao.recommend.stream.cmp.domain.nginx.Record;
import com.qbao.recommend.stream.cmp.enums.EventType;
import com.qbao.recommend.stream.cmp.enums.TopicType;
import com.qbao.recommend.stream.cmp.parser.KafkaParser;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
public class CartBinLogParser extends KafkaParser<Record> {
    private Gson gson = new GsonBuilder().serializeNulls().create();

    public CartBinLogParser(TopicType type) {
        super(type);
    }

    @Override
    public Record parse(String line) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EventType getEventType() {
        // TODO Auto-generated method stub
        return null;
    }

}

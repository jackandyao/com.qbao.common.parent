/**
 * 
 */
package com.qbao.recommend.stream.cmp.parser.binlog;

import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qbao.recommend.stream.cmp.domain.maxwell.MerSpuBinLogInfo;
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
public class MerSpuBinLogParser extends KafkaParser<MerSpuBinLogInfo> {
    private Gson gson = new GsonBuilder().serializeNulls().create();

    public MerSpuBinLogParser(TopicType type) {
        super(type);
    }

    @Override
    public MerSpuBinLogInfo parse(String line) {
        MerSpuBinLogInfo result = null;
        if (StringUtils.isNotBlank(line)) {
            result = gson.fromJson(line, MerSpuBinLogInfo.class);
        }
        return result;
    }

    @Override
    public EventType getEventType() {
        // TODO Auto-generated method stub
        return null;
    }

}

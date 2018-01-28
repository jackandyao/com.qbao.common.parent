/**
 * 
 */
package com.qbao.recommend.stream.cmp.parser.binlog;

import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qbao.recommend.stream.cmp.domain.maxwell.BcProductBinLogInfo;
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
public class BcProductBinLogParser extends KafkaParser<BcProductBinLogInfo> {
    private Gson gson = new GsonBuilder().serializeNulls().create();
   
    public BcProductBinLogParser(TopicType type){
        super(type);
    }
    @Override
    public BcProductBinLogInfo parse(String line) {
        BcProductBinLogInfo result = null;
        if (StringUtils.isNotBlank(line)) {
            result = gson.fromJson(line, BcProductBinLogInfo.class);
        }
        return result;
    }

    @Override
    public EventType getEventType() {
        // TODO Auto-generated method stub
        return null;
    }
    public static void main(String[] args){
        String json ="{\"database\":\"merchant\",\"table\":\"mer_spu\",\"type\":\"insert\",\"ts\":1472541721,\"xid\":17328097027,\"commit\":true,\"data\":{\"spu_id\":4178819,\"spu_name\":\"COS风圆圈耳环 925纯银\",\"publish_status\":2,\"audit_status\":1}}";
        Gson gson = new GsonBuilder().serializeNulls().create();
        System.out.println(gson.fromJson("{}", MerSpuBinLogInfo.class));
        System.out.println(gson.fromJson(json, MerSpuBinLogInfo.class));
    }

}

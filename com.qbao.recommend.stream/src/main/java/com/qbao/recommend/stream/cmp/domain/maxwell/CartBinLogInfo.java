/**
 * 
 */
package com.qbao.recommend.stream.cmp.domain.maxwell;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.qbao.recommend.stream.cmp.domain.nginx.Record;
import com.qbao.recommend.stream.cmp.domain.recommend.CscCartDetail;
import com.qbao.recommend.stream.cmp.enums.EventType;
import com.qbao.recommend.stream.cmp.enums.TopicType;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
public class CartBinLogInfo extends BinLogInfo {
    
    @SerializedName("data")
    @Expose
    private CscCartDetail data;

    public CscCartDetail getData() {
        return data;
    }

    public void setData(CscCartDetail data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }


    @Override
    public Record toRecord(EventType type, TopicType topicType, boolean isBaoGou) {
        return new Record(String.valueOf(data.getUserId()), String.valueOf(data.getGoodsId()), type, topicType, isBaoGou);

    }

}
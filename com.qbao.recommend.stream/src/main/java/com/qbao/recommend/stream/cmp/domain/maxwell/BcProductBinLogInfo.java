/**
 * 
 */
package com.qbao.recommend.stream.cmp.domain.maxwell;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.qbao.recommend.stream.cmp.domain.monitor.BcProductStatus;
import com.qbao.recommend.stream.cmp.domain.nginx.Record;
import com.qbao.recommend.stream.cmp.enums.EventType;
import com.qbao.recommend.stream.cmp.enums.TopicType;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
public class BcProductBinLogInfo extends BinLogInfo {
    @SerializedName("data")
    @Expose
    private BcProductStatus data;

    /**
     * @return the data
     */
    public BcProductStatus getData() {
        return data;
    }

    /**
     * @param data
     * the data to set
     */
    public void setData(BcProductStatus data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public Record toRecord(EventType type, TopicType topicType, boolean isBaoGou) {
        throw new RuntimeException("unimplements of this method");
    }
}

/**
 * 
 */
package com.qbao.recommend.stream.cmp.domain.maxwell;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.qbao.recommend.stream.cmp.domain.monitor.MerSpuStatus;
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
public class MerSpuBinLogInfo extends BinLogInfo {

    @SerializedName("data")
    @Expose
    private MerSpuStatus data;
    
    @SerializedName("old")
    @Expose
    private MerSpuStatus old;
    /**
     * @return the data
     */
    public MerSpuStatus getData() {
        return data;
    }

    /**
     * @param data
     * the data to set
     */
    public void setData(MerSpuStatus data) {
        this.data = data;
    }

    public MerSpuStatus getOld() {
        return old;
    }

    public void setOld(MerSpuStatus old) {
        this.old = old;
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

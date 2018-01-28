/**
 * 
 */
package com.qbao.recommend.stream.cmp.domain.monitor;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */

@Generated("org.jsonschema2pojo")
public class MerSpuStatus {

    @SerializedName("spu_id")
    @Expose
    private Long spuId;
    @SerializedName("spu_name")
    @Expose
    private String spuName;
    @SerializedName("view_price")
    @Expose
    private Long viewPrice;
    @SerializedName("main_img")
    @Expose
    private String mainImg;
    @SerializedName("publish_status")
    @Expose
    private Long publishStatus;
    @SerializedName("audit_status")
    @Expose
    private Long auditStatus;
    @SerializedName("sell_count_aggregated")
    @Expose
    private Long sellCountAggregated;

    /**
     * 
     * @return
     * The spuId
     */
    public Long getSpuId() {
        return spuId;
    }

    /**
     * 
     * @param spuId
     * The spu_id
     */
    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    /**
     * 
     * @return
     * The spuName
     */
    public String getSpuName() {
        return spuName;
    }

    /**
     * 
     * @param spuName
     * The spu_name
     */
    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    /**
     * 
     * @return
     * The viewPrice
     */
    public Long getViewPrice() {
        return viewPrice;
    }

    /**
     * 
     * @param viewPrice
     * The view_price
     */
    public void setViewPrice(Long viewPrice) {
        this.viewPrice = viewPrice;
    }

    /**
     * 
     * @return
     * The mainImg
     */
    public String getMainImg() {
        return mainImg;
    }

    /**
     * 
     * @param mainImg
     * The main_img
     */
    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    /**
     * 
     * @return
     * The publishStatus
     */
    public Long getPublishStatus() {
        return publishStatus;
    }

    /**
     * 
     * @param publishStatus
     * The publish_status
     */
    public void setPublishStatus(Long publishStatus) {
        this.publishStatus = publishStatus;
    }

    /**
     * 
     * @return
     * The auditStatus
     */
    public Long getAuditStatus() {
        return auditStatus;
    }

    /**
     * 
     * @param auditStatus
     * The audit_status
     */
    public void setAuditStatus(Long auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 
     * @return
     * The sellCountAggregated
     */
    public Long getSellCountAggregated() {
        return sellCountAggregated;
    }

    /**
     * 
     * @param sellCountAggregated
     * The sell_count_aggregated
     */
    public void setSellCountAggregated(Long sellCountAggregated) {
        this.sellCountAggregated = sellCountAggregated;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(spuId).append(spuName).append(viewPrice).append(mainImg).append(publishStatus).append(auditStatus).append(sellCountAggregated).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MerSpuStatus) == false) {
            return false;
        }
        MerSpuStatus rhs = ((MerSpuStatus) other);
        return new EqualsBuilder().append(spuId, rhs.spuId).append(spuName, rhs.spuName).append(viewPrice, rhs.viewPrice).append(mainImg, rhs.mainImg).append(publishStatus, rhs.publishStatus).append(auditStatus, rhs.auditStatus).append(sellCountAggregated, rhs.sellCountAggregated).isEquals();
    }

    public static void main(String[] args) {
    }
}

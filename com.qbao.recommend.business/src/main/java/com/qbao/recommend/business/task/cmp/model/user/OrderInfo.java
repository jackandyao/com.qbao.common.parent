
package com.qbao.recommend.business.task.cmp.model.user;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class OrderInfo {

    @SerializedName("baogou_order_count")
    @Expose
    private Integer baogouOrderCount;
    @SerializedName("merchant_order_count")
    @Expose
    private Integer merchantOrderCount;
    @SerializedName("total_order_count")
    @Expose
    private Integer totalOrderCount;

    /**
     * 
     * @return
     *     The baogouOrderCount
     */
    public Integer getBaogouOrderCount() {
        return baogouOrderCount;
    }

    /**
     * 
     * @param baogouOrderCount
     *     The baogou_order_count
     */
    public void setBaogouOrderCount(Integer baogouOrderCount) {
        this.baogouOrderCount = baogouOrderCount;
    }

    /**
     * 
     * @return
     *     The merchantOrderCount
     */
    public Integer getMerchantOrderCount() {
        return merchantOrderCount;
    }

    /**
     * 
     * @param merchantOrderCount
     *     The merchant_order_count
     */
    public void setMerchantOrderCount(Integer merchantOrderCount) {
        this.merchantOrderCount = merchantOrderCount;
    }

    /**
     * 
     * @return
     *     The totalOrderCount
     */
    public Integer getTotalOrderCount() {
        return totalOrderCount;
    }

    /**
     * 
     * @param totalOrderCount
     *     The total_order_count
     */
    public void setTotalOrderCount(Integer totalOrderCount) {
        this.totalOrderCount = totalOrderCount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(baogouOrderCount).append(merchantOrderCount).append(totalOrderCount).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OrderInfo) == false) {
            return false;
        }
        OrderInfo rhs = ((OrderInfo) other);
        return new EqualsBuilder().append(baogouOrderCount, rhs.baogouOrderCount).append(merchantOrderCount, rhs.merchantOrderCount).append(totalOrderCount, rhs.totalOrderCount).isEquals();
    }

}

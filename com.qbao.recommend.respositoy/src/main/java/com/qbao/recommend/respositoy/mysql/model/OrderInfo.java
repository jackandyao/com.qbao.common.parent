
package com.qbao.recommend.respositoy.mysql.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class OrderInfo {

    @SerializedName("total_order_count")
    @Expose
    private Long totalOrderCount;
    @SerializedName("baogou_order_count")
    @Expose
    private Long baogouOrderCount;
    @SerializedName("merchant_order_count")
    @Expose
    private Long merchantOrderCount;

    /**
     * 
     * @return
     *     The totalOrderCount
     */
    public Long getTotalOrderCount() {
        return totalOrderCount;
    }

    /**
     * 
     * @param totalOrderCount
     *     The total_order_count
     */
    public void setTotalOrderCount(Long totalOrderCount) {
        this.totalOrderCount = totalOrderCount;
    }

    /**
     * 
     * @return
     *     The baogouOrderCount
     */
    public Long getBaogouOrderCount() {
        return baogouOrderCount;
    }

    /**
     * 
     * @param baogouOrderCount
     *     The baogou_order_count
     */
    public void setBaogouOrderCount(Long baogouOrderCount) {
        this.baogouOrderCount = baogouOrderCount;
    }

    /**
     * 
     * @return
     *     The merchantOrderCount
     */
    public Long getMerchantOrderCount() {
        return merchantOrderCount;
    }

    /**
     * 
     * @param merchantOrderCount
     *     The merchant_order_count
     */
    public void setMerchantOrderCount(Long merchantOrderCount) {
        this.merchantOrderCount = merchantOrderCount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(totalOrderCount).append(baogouOrderCount).append(merchantOrderCount).toHashCode();
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
        return new EqualsBuilder().append(totalOrderCount, rhs.totalOrderCount).append(baogouOrderCount, rhs.baogouOrderCount).append(merchantOrderCount, rhs.merchantOrderCount).isEquals();
    }

}


package com.qbao.recommend.respositoy.mysql.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Asset {

    @SerializedName("coupon_snapshot")
    @Expose
    private Long couponSnapshot;
    @SerializedName("baobi_snapshot")
    @Expose
    private Long baobiSnapshot;

    /**
     * 
     * @return
     *     The couponSnapshot
     */
    public Long getCouponSnapshot() {
        return couponSnapshot;
    }

    /**
     * 
     * @param couponSnapshot
     *     The coupon_snapshot
     */
    public void setCouponSnapshot(Long couponSnapshot) {
        this.couponSnapshot = couponSnapshot;
    }

    /**
     * 
     * @return
     *     The baobiSnapshot
     */
    public Long getBaobiSnapshot() {
        return baobiSnapshot;
    }

    /**
     * 
     * @param baobiSnapshot
     *     The baobi_snapshot
     */
    public void setBaobiSnapshot(Long baobiSnapshot) {
        this.baobiSnapshot = baobiSnapshot;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(couponSnapshot).append(baobiSnapshot).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Asset) == false) {
            return false;
        }
        Asset rhs = ((Asset) other);
        return new EqualsBuilder().append(couponSnapshot, rhs.couponSnapshot).append(baobiSnapshot, rhs.baobiSnapshot).isEquals();
    }

}

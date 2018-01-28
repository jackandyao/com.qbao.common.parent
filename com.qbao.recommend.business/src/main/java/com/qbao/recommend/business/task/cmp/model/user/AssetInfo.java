
package com.qbao.recommend.business.task.cmp.model.user;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class AssetInfo {

    @SerializedName("baobi_snapshot")
    @Expose
    private Long baobiSnapshot;
    @SerializedName("coupon_snapshot")
    @Expose
    private Long couponSnapshot;

    /**
     * 
     * @return
     * The baobiSnapshot
     */
    public Long getBaobiSnapshot() {
        return baobiSnapshot;
    }

    /**
     * 
     * @param baobiSnapshot
     * The baobi_snapshot
     */
    public void setBaobiSnapshot(Long baobiSnapshot) {
        this.baobiSnapshot = baobiSnapshot;
    }

    /**
     * 
     * @return
     * The couponSnapshot
     */
    public Long getCouponSnapshot() {
        return couponSnapshot;
    }

    /**
     * 
     * @param couponSnapshot
     * The coupon_snapshot
     */
    public void setCouponSnapshot(Long couponSnapshot) {
        this.couponSnapshot = couponSnapshot;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(baobiSnapshot).append(couponSnapshot).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AssetInfo) == false) {
            return false;
        }
        AssetInfo rhs = ((AssetInfo) other);
        return new EqualsBuilder().append(baobiSnapshot, rhs.baobiSnapshot).append(couponSnapshot, rhs.couponSnapshot).isEquals();
    }

}


package com.qbao.recommend.business.task.cmp.model.user;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class FavoriteItem {

    @SerializedName("goods_id")
    @Expose
    private Integer goodsId;

    /**
     * 
     * @return
     *     The goodsId
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 
     * @param goodsId
     *     The goods_id
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(goodsId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FavoriteItem) == false) {
            return false;
        }
        FavoriteItem rhs = ((FavoriteItem) other);
        return new EqualsBuilder().append(goodsId, rhs.goodsId).isEquals();
    }

}

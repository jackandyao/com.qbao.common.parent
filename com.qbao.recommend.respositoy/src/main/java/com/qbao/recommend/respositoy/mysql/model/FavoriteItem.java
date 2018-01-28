
package com.qbao.recommend.respositoy.mysql.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class FavoriteItem {

    @SerializedName("goods_id")
    @Expose
    private Long goodsId;
    @SerializedName("create_time")
    @Expose
    private String createTime;

    /**
     * 
     * @return
     *     The goodsId
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * 
     * @param goodsId
     *     The goods_id
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 
     * @return
     *     The createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime
     *     The create_time
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(goodsId).append(createTime).toHashCode();
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
        return new EqualsBuilder().append(goodsId, rhs.goodsId).append(createTime, rhs.createTime).isEquals();
    }

}

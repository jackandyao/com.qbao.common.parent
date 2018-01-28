
package com.qbao.recommend.respositoy.mysql.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ExcludeProduct {

    @SerializedName("goods_id")
    @Expose
    private String goodsId;
    @SerializedName("shop_id")
    @Expose
    private String shopId;
    @SerializedName("is_baogou")
    @Expose
    private Boolean isBaogou;
    @SerializedName("create_time")
    @Expose
    private String createTime;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("dir_id")
    @Expose
    private String dirId;

    /**
     *
     * @return
     *     The goodsId
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     *
     * @param goodsId
     *     The goods_id
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    /**
     *
     * @return
     *     The shopId
     */
    public String getShopId() {
        return shopId;
    }

    /**
     *
     * @param shopId
     *     The shop_id
     */
    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    /**
     *
     * @return
     *     The isBaogou
     */
    public Boolean getIsBaogou() {
        return isBaogou;
    }

    /**
     *
     * @param isBaogou
     *     The is_baogou
     */
    public void setIsBaogou(Boolean isBaogou) {
        this.isBaogou = isBaogou;
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

    /**
     *
     * @return
     *     The source
     */
    public String getSource() {
        return source;
    }

    /**
     *
     * @param source
     *     The source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     *
     * @return
     *     The dirId
     */
    public String getDirId() {
        return dirId;
    }

    /**
     *
     * @param dirId
     *     The dir_id
     */
    public void setDirId(String dirId) {
        this.dirId = dirId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(goodsId).append(shopId).append(isBaogou).append(createTime).append(source).append(dirId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ExcludeProduct) == false) {
            return false;
        }
        ExcludeProduct rhs = ((ExcludeProduct) other);
        return new EqualsBuilder().append(goodsId, rhs.goodsId).append(shopId, rhs.shopId).append(isBaogou, rhs.isBaogou).append(createTime, rhs.createTime).append(source, rhs.source).append(dirId, rhs.dirId).isEquals();
    }


}

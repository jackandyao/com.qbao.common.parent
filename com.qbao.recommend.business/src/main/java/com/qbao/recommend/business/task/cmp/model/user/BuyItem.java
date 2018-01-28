
package com.qbao.recommend.business.task.cmp.model.user;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class BuyItem {

    @SerializedName("buy_count")
    @Expose
    private Integer buyCount;
    @SerializedName("goods_id")
    @Expose
    private String goodsId;
    @SerializedName("shop_id")
    @Expose
    private String shopId;
    @SerializedName("is_baogou")
    @Expose
    private Boolean isBaogou;
    @SerializedName("pay_time")
    @Expose
    private String payTime;
    @SerializedName("thumbs_up_count")
    @Expose
    private Integer thumbsUpCount;

    /**
     * 
     * @return
     *     The buyCount
     */
    public Integer getBuyCount() {
        return buyCount;
    }

    /**
     * 
     * @param buyCount
     *     The buy_count
     */
    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

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
     *     The payTime
     */
    public String getPayTime() {
        return payTime;
    }

    /**
     * 
     * @param payTime
     *     The pay_time
     */
    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    /**
     * 
     * @return
     *     The thumbsUpCount
     */
    public Integer getThumbsUpCount() {
        return thumbsUpCount;
    }

    /**
     * 
     * @param thumbsUpCount
     *     The thumbs_up_count
     */
    public void setThumbsUpCount(Integer thumbsUpCount) {
        this.thumbsUpCount = thumbsUpCount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(buyCount).append(goodsId).append(shopId).append(isBaogou).append(payTime).append(thumbsUpCount).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BuyItem) == false) {
            return false;
        }
        BuyItem rhs = ((BuyItem) other);
        return new EqualsBuilder().append(buyCount, rhs.buyCount).append(goodsId, rhs.goodsId).append(shopId, rhs.shopId).append(isBaogou, rhs.isBaogou).append(payTime, rhs.payTime).append(thumbsUpCount, rhs.thumbsUpCount).isEquals();
    }

}


package com.qbao.recommend.respositoy.mysql.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class BuyItem {

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
    @SerializedName("pay_time")
    @Expose
    private String payTime;
    @SerializedName("order_state_info")
    @Expose
    private String orderStateInfo;
    @SerializedName("thumbs_up")
    @Expose
    private Boolean thumbsUp;

    @SerializedName("category")
    @Expose
    private String category;

    @SerializedName("goods_name")
    @Expose
    private String goodsName;

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
     *     The orderStateInfo
     */
    public String getOrderStateInfo() {
        return orderStateInfo;
    }

    /**
     * 
     * @param orderStateInfo
     *     The order_state_info
     */
    public void setOrderStateInfo(String orderStateInfo) {
        this.orderStateInfo = orderStateInfo;
    }

    /**
     * 
     * @return
     *     The thumbsUp
     */
    public Boolean getThumbsUp() {
        return thumbsUp;
    }

    /**
     * 
     * @param thumbsUp
     *     The thumbs_up
     */
    public void setThumbsUp(Boolean thumbsUp) {
        this.thumbsUp = thumbsUp;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getBaogou() {
        return isBaogou;
    }

    public void setBaogou(Boolean baogou) {
        isBaogou = baogou;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(goodsId).append(category).append(goodsName).append(shopId).append(isBaogou).append(createTime).append(payTime).append(orderStateInfo).append(thumbsUp).toHashCode();
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
        return new EqualsBuilder().append(goodsId, rhs.goodsId).append(category,rhs.category).append(goodsName,rhs.getGoodsName()).append(shopId, rhs.shopId).append(isBaogou, rhs.isBaogou).append(createTime, rhs.createTime).append(payTime, rhs.payTime).append(orderStateInfo, rhs.orderStateInfo).append(thumbsUp, rhs.thumbsUp).isEquals();
    }

}

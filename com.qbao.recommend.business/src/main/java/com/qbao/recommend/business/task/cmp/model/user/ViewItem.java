
package com.qbao.recommend.business.task.cmp.model.user;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ViewItem {

    @SerializedName("click_count")
    @Expose
    private Integer clickCount;
    @SerializedName("goods_id")
    @Expose
    private String goodsId;
    @SerializedName("shop_id")
    @Expose
    private Object shopId;
    @SerializedName("is_baogou")
    @Expose
    private Boolean isBaogou;
    @SerializedName("view_time")
    @Expose
    private String viewTime;

    /**
     * 
     * @return
     *     The clickCount
     */
    public Integer getClickCount() {
        return clickCount;
    }

    /**
     * 
     * @param clickCount
     *     The click_count
     */
    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
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
    public Object getShopId() {
        return shopId;
    }

    /**
     * 
     * @param shopId
     *     The shop_id
     */
    public void setShopId(Object shopId) {
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
     *     The viewTime
     */
    public String getViewTime() {
        return viewTime;
    }

    /**
     * 
     * @param viewTime
     *     The view_time
     */
    public void setViewTime(String viewTime) {
        this.viewTime = viewTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(clickCount).append(goodsId).append(shopId).append(isBaogou).append(viewTime).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ViewItem) == false) {
            return false;
        }
        ViewItem rhs = ((ViewItem) other);
        return new EqualsBuilder().append(clickCount, rhs.clickCount).append(goodsId, rhs.goodsId).append(shopId, rhs.shopId).append(isBaogou, rhs.isBaogou).append(viewTime, rhs.viewTime).isEquals();
    }

}

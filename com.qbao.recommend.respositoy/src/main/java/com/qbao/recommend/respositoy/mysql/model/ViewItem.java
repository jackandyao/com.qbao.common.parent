
package com.qbao.recommend.respositoy.mysql.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class ViewItem {

    @SerializedName("goods_id")
    @Expose
    private String goodsId;
    @SerializedName("is_baogou")
    @Expose
    private Boolean isBaogou;
    @SerializedName("view_time")
    @Expose
    private String viewTime;
    @SerializedName("click_count")
    @Expose
    private Long clickCount;

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

    /**
     * 
     * @return
     *     The clickCount
     */
    public Long getClickCount() {
        return clickCount;
    }

    /**
     * 
     * @param clickCount
     *     The click_count
     */
    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(goodsId).append(isBaogou).append(viewTime).append(clickCount).toHashCode();
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
        return new EqualsBuilder().append(goodsId, rhs.goodsId).append(isBaogou, rhs.isBaogou).append(viewTime, rhs.viewTime).append(clickCount, rhs.clickCount).isEquals();
    }

}

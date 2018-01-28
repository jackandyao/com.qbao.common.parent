
package com.qbao.recommend.business.task.cmp.model.user;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class User {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("base_info")
    @Expose
    private BaseInfo baseInfo;
    @SerializedName("order_info")
    @Expose
    private OrderInfo orderInfo;
    @SerializedName("goods")
    @Expose
    private Goods goods;
    @SerializedName("asset")
    @Expose
    private AssetInfo asset;

    /**
     * 
     * @return
     *     The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId
     *     The user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 
     * @return
     *     The userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName
     *     The user_name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 
     * @return
     *     The baseInfo
     */
    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    /**
     * 
     * @param baseInfo
     *     The base_info
     */
    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    /**
     * 
     * @return
     *     The orderInfo
     */
    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    /**
     * 
     * @param orderInfo
     *     The order_info
     */
    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    /**
     * 
     * @return
     *     The goods
     */
    public Goods getGoods() {
        return goods;
    }

    /**
     * 
     * @param goods
     *     The goods
     */
    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    /**
     * 
     * @return
     *     The asset
     */
    public AssetInfo getAssetInfo() {
        return asset;
    }

    /**
     * 
     * @param asset
     *     The asset
     */
    public void setAsset(AssetInfo asset) {
        this.asset = asset;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(userId).append(userName).append(baseInfo).append(orderInfo).append(goods).append(asset).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof User) == false) {
            return false;
        }
        User rhs = ((User) other);
        return new EqualsBuilder().append(userId, rhs.userId).append(userName, rhs.userName).append(baseInfo, rhs.baseInfo).append(orderInfo, rhs.orderInfo).append(goods, rhs.goods).append(asset, rhs.asset).isEquals();
    }

}

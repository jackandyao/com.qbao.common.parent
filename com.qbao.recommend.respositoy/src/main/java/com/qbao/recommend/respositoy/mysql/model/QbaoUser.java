
package com.qbao.recommend.respositoy.mysql.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class QbaoUser {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("score_info")
    @Expose
    private ScoreInfo scoreInfo;
    @SerializedName("asset")
    @Expose
    private Asset asset;
    @SerializedName("base_info")
    @Expose
    private BaseInfo baseInfo;
    @SerializedName("bao_yue")
    @Expose
    private BaoYue baoYue;
    @SerializedName("you_piao")
    @Expose
    private YouPiao youPiao;
    @SerializedName("order_info")
    @Expose
    private OrderInfo orderInfo;
    @SerializedName("goods")
    @Expose
    private Goods goods;

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
     *     The scoreInfo
     */
    public ScoreInfo getScoreInfo() {
        return scoreInfo;
    }

    /**
     * 
     * @param scoreInfo
     *     The score_info
     */
    public void setScoreInfo(ScoreInfo scoreInfo) {
        this.scoreInfo = scoreInfo;
    }

    /**
     * 
     * @return
     *     The asset
     */
    public Asset getAsset() {
        return asset;
    }

    /**
     * 
     * @param asset
     *     The asset
     */
    public void setAsset(Asset asset) {
        this.asset = asset;
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
     *     The baoYue
     */
    public BaoYue getBaoYue() {
        return baoYue;
    }

    /**
     * 
     * @param baoYue
     *     The bao_yue
     */
    public void setBaoYue(BaoYue baoYue) {
        this.baoYue = baoYue;
    }

    /**
     * 
     * @return
     *     The youPiao
     */
    public YouPiao getYouPiao() {
        return youPiao;
    }

    /**
     * 
     * @param youPiao
     *     The you_piao
     */
    public void setYouPiao(YouPiao youPiao) {
        this.youPiao = youPiao;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(userId).append(userName).append(scoreInfo).append(asset).append(baseInfo).append(baoYue).append(youPiao).append(orderInfo).append(goods).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof QbaoUser) == false) {
            return false;
        }
        QbaoUser rhs = ((QbaoUser) other);
        return new EqualsBuilder().append(userId, rhs.userId).append(userName, rhs.userName).append(scoreInfo, rhs.scoreInfo).append(asset, rhs.asset).append(baseInfo, rhs.baseInfo).append(baoYue, rhs.baoYue).append(youPiao, rhs.youPiao).append(orderInfo, rhs.orderInfo).append(goods, rhs.goods).isEquals();
    }

}

package com.qbao.recommend.business.shop.cmp.model.goodshop;


import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class BaseInfo {

    @SerializedName("arbitrate_total")
    @Expose
    private Integer arbitrateTotal;
    @SerializedName("delay_shipping_count")
    @Expose
    private Integer delayShippingCount;
    @SerializedName("shop_thumb_total")
    @Expose
    private Integer shopThumbTotal;
    @SerializedName("total_orders")
    @Expose
    private Integer totalOrders;

    /**
     * 
     * @return
     *     The arbitrateTotal
     */
    public Integer getArbitrateTotal() {
        return arbitrateTotal;
    }

    /**
     * 
     * @param arbitrateTotal
     *     The arbitrate_total
     */
    public void setArbitrateTotal(Integer arbitrateTotal) {
        this.arbitrateTotal = arbitrateTotal;
    }

    /**
     * 
     * @return
     *     The delayShippingCount
     */
    public Integer getDelayShippingCount() {
        return delayShippingCount;
    }

    /**
     * 
     * @param delayShippingCount
     *     The delay_shipping_count
     */
    public void setDelayShippingCount(Integer delayShippingCount) {
        this.delayShippingCount = delayShippingCount;
    }

    /**
     * 
     * @return
     *     The shopThumbTotal
     */
    public Integer getShopThumbTotal() {
        return shopThumbTotal;
    }

    /**
     * 
     * @param shopThumbTotal
     *     The shop_thumb_total
     */
    public void setShopThumbTotal(Integer shopThumbTotal) {
        this.shopThumbTotal = shopThumbTotal;
    }

    /**
     * 
     * @return
     *     The totalOrders
     */
    public Integer getTotalOrders() {
        return totalOrders;
    }

    /**
     * 
     * @param totalOrders
     *     The total_orders
     */
    public void setTotalOrders(Integer totalOrders) {
        this.totalOrders = totalOrders;
    }

}

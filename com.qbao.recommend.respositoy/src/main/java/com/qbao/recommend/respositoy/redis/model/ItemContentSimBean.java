package com.qbao.recommend.respositoy.redis.model;

import java.io.Serializable;
import java.util.List;

public class ItemContentSimBean implements Serializable {

    private static final long serialVersionUID = 4224267410256078201L;

    private List<GoodsItems> goodsItems;
    private String spuId;
    private String createTime;
    private String updateTime;

    public ItemContentSimBean() {

    }

    public List<GoodsItems> getGoodsItems() {
        return this.goodsItems;
    }

    public void setGoodsItems(List<GoodsItems> goodsItems) {
        this.goodsItems = goodsItems;
    }

    public String getSpuId() {
        return spuId;
    }

    public void setSpuId(String spuId) {
        this.spuId = spuId;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

}

package com.qbao.recommend.respositoy.redis.model;

import java.io.Serializable;

//浏览的商品次数
public class SpuCount implements Serializable {

    private String spuId;
    private int count;

    public String getSpuId() {
        return spuId;
    }

    public void setSpuId(String spuId) {
        this.spuId = spuId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
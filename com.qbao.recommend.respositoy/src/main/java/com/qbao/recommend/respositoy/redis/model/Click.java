package com.qbao.recommend.respositoy.redis.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.json.JSONObject;

public class Click implements Serializable {
    private static final long serialVersionUID = "$Id: Click.java 896 2016-09-05 10:26:32Z jiahongping $".hashCode();
    private String goodsId;
    private boolean isBaogou;

    public Click() {

    }

    public Click(JSONObject json) {

        this.goodsId = json.optString("goods_id");
        this.isBaogou = json.optBoolean("is_baogou");

    }
    public Click(String goodsId, boolean isBaogou){
        this.goodsId = goodsId;
        this.isBaogou = isBaogou;
    }

    public String getGoodsId() {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public boolean getIsBaogou() {
        return this.isBaogou;
    }

    public void setIsBaogou(boolean isBaogou) {
        this.isBaogou = isBaogou;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(ToStringStyle.SIMPLE_STYLE);
    }

}

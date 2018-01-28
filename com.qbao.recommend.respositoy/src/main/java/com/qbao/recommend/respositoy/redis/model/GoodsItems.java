package com.qbao.recommend.respositoy.redis.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.json.*;

public class GoodsItems implements Serializable {
    private static final long serialVersionUID = "$Id: GoodsItems.java 1116 2016-09-21 02:41:55Z shuaizhihu $".hashCode();
    private double score;
    private String goodsId;
    private int type;//0:宝购 1：购物集市 2：精选商城
    private boolean isBaogou;

    public GoodsItems() {

    }

    public GoodsItems(String goodsId, double score, int type) {
		super();
		this.score = score;
		this.goodsId = goodsId;
		this.type = type;
	}

	public GoodsItems(JSONObject json) {

        this.score = json.optDouble("score");
        this.goodsId = json.optString("goods_id");
        this.isBaogou = json.optBoolean("is_baogou");
        this.type = json.optInt("type");

    }

    public double getScore() {
        return this.score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getGoodsId() {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    
    public boolean isBaogou() {
		return isBaogou;
	}

	public void setBaogou(boolean isBaogou) {
		this.isBaogou = isBaogou;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(ToStringStyle.SIMPLE_STYLE);
    }

}

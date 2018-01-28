package com.qbao.recommend.respositoy.redis.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ItemDirSimBean implements Serializable {

	private static final long serialVersionUID = 8913233853884034356L;
	private List<List<GoodsItems>> goodsItems;
    private String spuId;
    private String createTime;
    private String updateTime;

    public ItemDirSimBean() {

    }


    public List<List<GoodsItems>> getGoodsItems() {
		return goodsItems;
	}

	public void setGoodsItems(List<List<GoodsItems>> goodsItems) {
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
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(ToStringStyle.MULTI_LINE_STYLE);
    }

}

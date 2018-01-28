package com.qbao.recommend.respositoy.redis.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class LookBuyBean implements Serializable {
    private static final long serialVersionUID = "$Id: LookBuyBean.java 896 2016-09-05 10:26:32Z jiahongping $".hashCode();
    private long id;
    private String items;
    private int type;
    private String updateTime;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(ToStringStyle.MULTI_LINE_STYLE);
    }

	public static LookBuyBean createDefaultLookBuyBean(){
		LookBuyBean lookBuy = new LookBuyBean();
		lookBuy.setUpdateTime(dateFormat.format(new Date()));
        return lookBuy;
    }
}

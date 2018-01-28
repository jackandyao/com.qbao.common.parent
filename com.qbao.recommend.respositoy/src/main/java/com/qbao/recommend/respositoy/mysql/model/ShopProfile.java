package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;

/**
 * @author	yuandongrui
 * @date 	2016年6月29日
 */
public class ShopProfile implements Serializable{
	
	private static final long serialVersionUID = "$Id: ShopProfile.java 1199 2016-09-28 07:09:26Z zhangjun $".hashCode();
	private long shopId;
	private String items;
	public long getShopId() {
		return shopId;
	}
	public void setShopId(long shopId) {
		this.shopId = shopId;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	
}

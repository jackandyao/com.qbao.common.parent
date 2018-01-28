package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Lists;

/**
 * @author yuandongrui
 * @date 2016年6月30日
 */
public class RecommendShop implements Serializable{
	private static final long serialVersionUID = "$Id: RecommendShop.java 1202 2016-09-28 08:36:29Z zhangjun $".hashCode();
	private long userId;
	private String shopIds;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getShopIds() {
		return shopIds;
	}

	public void setShopIds(String shopIds) {
		this.shopIds = shopIds;
	}

	public List<String> getShopList() {
		List<String> shopList = Lists.newArrayList();
		if (!StringUtils.isEmpty(shopIds)) {
			for (String shop : shopIds.split(";")) {
				if(StringUtils.isEmpty(shop)) continue;
				int index = shop.indexOf("/");
				if(index>=0) shop=shop.substring(++index);
				shopList.add(shop);
			}
		}
		return shopList;
	}
}

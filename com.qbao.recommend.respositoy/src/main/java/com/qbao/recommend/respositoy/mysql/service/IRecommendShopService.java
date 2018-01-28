
package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.RecommendShop;

/**
 * @author	yuandongrui
 * @date 	2016年6月30日
 */
public interface IRecommendShopService {
	public RecommendShop findByUserId(long userId);
}

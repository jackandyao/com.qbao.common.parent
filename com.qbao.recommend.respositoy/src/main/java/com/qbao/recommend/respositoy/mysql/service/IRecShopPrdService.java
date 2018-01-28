package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.RecommendShop;

/**
 * @author	sjzhangjun
 * @date 	2016年9月27日
 */
public interface IRecShopPrdService{
	/**
	 * 根据userId获取对应的Prd店铺推荐结果
	 * @param userId
	 * @return
	 */
    public RecommendShop findByUserId(long userId);
}

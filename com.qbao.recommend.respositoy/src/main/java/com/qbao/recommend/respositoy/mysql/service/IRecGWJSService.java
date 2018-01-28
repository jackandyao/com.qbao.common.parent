/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.RecommendItems;

/**
 * @author	yuandongrui
 * @date 	2016年6月29日
 */
public interface IRecGWJSService{
	/**
	 * 根据userId获取对应所有的spuId（此时的spuId是微商的Id）
	 * @param userId
	 * @return
	 */
    public RecommendItems findByUserId(long userId);
}

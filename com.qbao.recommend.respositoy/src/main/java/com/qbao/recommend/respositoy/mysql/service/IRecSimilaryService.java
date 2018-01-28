package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.RecommendItems;

/**
 * @author	yuandongrui
 * @date 	2016年6月29日
 */
public interface IRecSimilaryService{
	/**
	 * 根据userId获取对应的用户相异度记录
	 * @param userId
	 * @return
	 */
    public RecommendItems findByUserId(long userId);
}

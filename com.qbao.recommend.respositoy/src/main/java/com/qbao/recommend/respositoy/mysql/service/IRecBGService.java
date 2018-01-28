package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.RecommendItems;

/**
 * @author	yuandongrui
 * @date 	2016年6月29日
 */
public interface IRecBGService{
	/**
	 * 从限时抢购推荐结果的表中根据userId获取对应的记录
	 * @param userId
	 * @return
	 */
    public RecommendItems findByUserId(long userId);
}

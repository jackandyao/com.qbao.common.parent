package com.qbao.recommend.respositoy.mysql.service;
import com.qbao.recommend.respositoy.mysql.model.RecommendItems;

/**
 * @author	zhangjun
 * @date 	2016年9月8日
 */
public interface IRecAgenspuService{
	/**
	 * 根据userId获取对应的agentspu算法记录
	 * @param userId
	 * @return
	 */
    public RecommendItems findByUserId(long userId);
}

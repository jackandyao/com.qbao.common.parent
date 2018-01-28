package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.RecAgentLook;

/**
 * @author	yuandongrui
 * @date 	2016年7月11日
 */
public interface IRecAgentLookService {
	/**
	 * 根据taskId查询看了又看的推荐
	 * @param userId
	 * @return
	 */
	public RecAgentLook findByTaskId(long taskId);
}

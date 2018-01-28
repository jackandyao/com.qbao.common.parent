package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.RecAgentGuess;

/**
 * @author	yuandongrui
 * @date 	2016年7月11日
 */
public interface IRecAgentGuessService {
	/**
	 * 根据userId查询到分销猜你喜欢的推荐
	 * @param userId
	 * @return
	 */
	public RecAgentGuess findByUserId(long userId);
}

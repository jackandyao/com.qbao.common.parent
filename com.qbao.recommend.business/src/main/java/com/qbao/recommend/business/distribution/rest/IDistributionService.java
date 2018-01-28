package com.qbao.recommend.business.distribution.rest;

import javax.ws.rs.QueryParam;

/**
 * @author	yuandongrui
 * @date 	2016年7月8日
 */
public interface IDistributionService {
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public Object guessLike(@QueryParam("userId") long userId);
	
	public Object lookAgain(@QueryParam("userId") long userId,@QueryParam("taskId") long taskId);
}

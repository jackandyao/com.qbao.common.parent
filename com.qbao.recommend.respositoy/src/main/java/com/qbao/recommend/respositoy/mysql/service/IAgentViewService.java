package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.AgentView;

/**
 * @author	yuandongrui
 * @date 	2016年7月11日
 */
public interface IAgentViewService {

	public AgentView findByUserId(long userId);

}	

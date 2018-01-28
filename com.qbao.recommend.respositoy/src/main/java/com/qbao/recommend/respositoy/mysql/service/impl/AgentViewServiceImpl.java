package com.qbao.recommend.respositoy.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.AgentViewDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.AgentView;
import com.qbao.recommend.respositoy.mysql.service.IAgentViewService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

/**
 * @author	yuandongrui
 * @date 	2016年7月11日
 */
@Service
public class AgentViewServiceImpl implements IAgentViewService {
    @Value("${merchant_middle.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${AGENT_VIEW}")
    private String DATATABLE_NAME;
    
    @Autowired
    private AgentViewDao agentViewDao;

	@Override
	@RedisCache(expire = 60 * 60, clazz = AgentView.class, cacheType = CacheType.OBJECT)
    public AgentView findByUserId(long userId) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		AgentView view = agentViewDao.findByUserId(DATATABLE_NAME, userId);
		return view != null ? view : null;
	}

}

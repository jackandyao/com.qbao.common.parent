package com.qbao.recommend.respositoy.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.RecAgentLookDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.RecAgentGuess;
import com.qbao.recommend.respositoy.mysql.model.RecAgentLook;
import com.qbao.recommend.respositoy.mysql.service.IRecAgentLookService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

/**
 * @author	yuandongrui
 * @date 	2016年7月11日
 */
@Service
public class RecAgentLookServiceImpl implements IRecAgentLookService{
    @Value("${recommend.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${REC_AGENT_LOOKAGAIN}")
    private String DATATABLE_NAME;
	@Autowired
	private RecAgentLookDao recAgentLookDao;
	@RedisCache(expire = 60 * 60, clazz = RecAgentLook.class, cacheType = CacheType.OBJECT)
	public RecAgentLook findByTaskId(long taskId) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		RecAgentLook look = recAgentLookDao.findByUserId(DATATABLE_NAME,taskId);
		return look != null ? look : null;
	}

}

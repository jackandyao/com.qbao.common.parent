package com.qbao.recommend.respositoy.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.RecAgentGuessDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.RecAgentGuess;
import com.qbao.recommend.respositoy.mysql.model.SpuInfoMerchant;
import com.qbao.recommend.respositoy.mysql.service.IRecAgentGuessService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

/**
 * @author	yuandongrui
 * @date 	2016年7月11日
 */
@Service
public class RecAgentGuessServiceImpl implements IRecAgentGuessService{
    @Value("${recommend.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${REC_AGENT_GUESSLIKE}")
    private String DATATABLE_NAME;
	@Autowired
	private RecAgentGuessDao recAgentGuessDao;
	@Override
	@RedisCache(expire = 60 * 60, clazz = RecAgentGuess.class, cacheType = CacheType.OBJECT)
    public RecAgentGuess findByUserId(long userId) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		RecAgentGuess guess = recAgentGuessDao.findByUserId(DATATABLE_NAME,userId);
		return guess != null ? guess : null;
	}

}

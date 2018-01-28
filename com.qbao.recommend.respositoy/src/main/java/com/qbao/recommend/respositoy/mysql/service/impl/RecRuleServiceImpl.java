package com.qbao.recommend.respositoy.mysql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.RecRuleDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.RecRule;
import com.qbao.recommend.respositoy.mysql.model.RecommendShop;
import com.qbao.recommend.respositoy.mysql.service.IRecRuleService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;



/**
 * @author	yuandongrui
 * @date 	2016年6月21日
 */
@Service
public class RecRuleServiceImpl implements IRecRuleService {
    @Value("${recommend.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${RECRULE}")
    private String DATATABLE_NAME;
    
    @Autowired
    private RecRuleDao recRuleDao;

	@Override
	@RedisCache(expire=60*60,clazz=RecRule.class,cacheType=CacheType.OBJECT)
	public RecRule findByRuleName(String ruleName) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		RecRule recRule = recRuleDao.findByRuleName(DATATABLE_NAME, ruleName);
		return recRule;
	}

	@Override
	@RedisCache(expire=60*60,clazz=RecRule.class,cacheType=CacheType.LIST)
	public List<RecRule> findAll() {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		List<RecRule> list = recRuleDao.findAll(DATATABLE_NAME);
		return list;
	}

}

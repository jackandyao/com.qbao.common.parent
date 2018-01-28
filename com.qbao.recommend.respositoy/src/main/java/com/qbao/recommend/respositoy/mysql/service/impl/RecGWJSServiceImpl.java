package com.qbao.recommend.respositoy.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.RecommendItemsDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.RecommendItems;
import com.qbao.recommend.respositoy.mysql.service.IRecGWJSService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

/**
 * @author	yuandongrui
 * @date 	2016年6月29日
 */
@Service
public class RecGWJSServiceImpl implements IRecGWJSService{
    @Value("${recommend.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${RECOMMEND_GWJS}")
    private String DATATABLE_NAME;
    
    @Autowired
    private RecommendItemsDao recommendItemsDao;
    
	@Override
	@RedisCache(expire=60*60,clazz=RecommendItems.class,cacheType=CacheType.OBJECT)
	public RecommendItems findByUserId(long userId) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		RecommendItems items = recommendItemsDao.findById(DATATABLE_NAME, userId);
		if (items == null){
			items = recommendItemsDao.findById(DATATABLE_NAME, 0);
		}
		return items;
	}
}

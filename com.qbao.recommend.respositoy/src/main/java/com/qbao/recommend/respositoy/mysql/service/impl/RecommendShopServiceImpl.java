package com.qbao.recommend.respositoy.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.RecommendShopDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.RecommendItems;
import com.qbao.recommend.respositoy.mysql.model.RecommendShop;
import com.qbao.recommend.respositoy.mysql.service.IRecommendShopService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

/**
 * @author	yuandongrui
 * @date 	2016年6月30日
 */
@Service
public class RecommendShopServiceImpl implements IRecommendShopService {
    @Value("${recommend.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${RECOMMEND_SHOP}")
    private String DATATABLE_NAME;
	
	@Autowired
	RecommendShopDao recommendShopDao;
	
	@Override
	@RedisCache(expire=60*60,clazz=RecommendShop.class,cacheType=CacheType.OBJECT)
	public RecommendShop findByUserId(long userId) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		RecommendShop recShop = recommendShopDao.findByUserId(DATATABLE_NAME, userId);
		if (recShop == null){
			recShop = recommendShopDao.findByUserId(DATATABLE_NAME, 0);
		}
		return recShop;
	}

}

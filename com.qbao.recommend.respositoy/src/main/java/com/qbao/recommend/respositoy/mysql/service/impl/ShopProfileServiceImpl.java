package com.qbao.recommend.respositoy.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.ShopProfileDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.RecRule;
import com.qbao.recommend.respositoy.mysql.model.ShopProfile;
import com.qbao.recommend.respositoy.mysql.service.IShopProfileService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

/**
 * @author	yuandongrui
 * @date 	2016年6月29日
 */
@Service
public class ShopProfileServiceImpl implements IShopProfileService {
    @Value("${merchant_middle.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${SHOPPROFILE}")
    private String DATATABLE_NAME;
    
    @Autowired
    ShopProfileDao shopProfileDao;
	
	@Override
	@RedisCache(expire=60*60,clazz=ShopProfile.class,cacheType=CacheType.OBJECT)
	public ShopProfile findById(long shopId) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return shopProfileDao.findById(DATATABLE_NAME, shopId);
	}

}

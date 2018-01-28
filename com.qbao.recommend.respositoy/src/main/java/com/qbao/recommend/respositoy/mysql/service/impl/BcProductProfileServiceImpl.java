package com.qbao.recommend.respositoy.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.BcProductProfileDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.AgentTask;
import com.qbao.recommend.respositoy.mysql.model.ProductProfile;
import com.qbao.recommend.respositoy.mysql.service.IProductProfileService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

/**
 * @author	yuandongrui
 * @date 	2016年6月29日
 */
@Service("bcProductProfileServiceImpl")
public class BcProductProfileServiceImpl implements IProductProfileService {
    @Value("${merchant_middle.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${BC_PRODUCT_PROFILE}")
    private String DATATABLE_NAME;
    
    @Autowired
    BcProductProfileDao productProfileDao;
	
	@Override
	@RedisCache(expire = 60 * 60, clazz = ProductProfile.class, cacheType = CacheType.OBJECT)
	public ProductProfile findByPid(long pId) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return productProfileDao.findById(DATATABLE_NAME, pId);
	}

}

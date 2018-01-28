package com.qbao.recommend.respositoy.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.MerProductProfileDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.ProductProfile;
import com.qbao.recommend.respositoy.mysql.model.SpuInfoMerchant;
import com.qbao.recommend.respositoy.mysql.service.IProductProfileService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

/**
 * @author yuandongrui
 * @date 2016年6月29日
 */
@Service("merProductProfileServiceImpl")
public class MerProductProfileServiceImpl implements IProductProfileService {
    @Value("${merchant_middle.datasource.key}")
    private String DATASOURCE_KEY;

    @Value("${MER_PRODUCT_PROFILE}")
    private String DATATABLE_NAME;

    @Autowired
    MerProductProfileDao productProfileDao;

    @Override
    @RedisCache(expire = 60 *60, clazz = ProductProfile.class, cacheType = CacheType.OBJECT)
    public ProductProfile findByPid(long pid) {
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        return productProfileDao.findById(DATATABLE_NAME, pid);
    }

}

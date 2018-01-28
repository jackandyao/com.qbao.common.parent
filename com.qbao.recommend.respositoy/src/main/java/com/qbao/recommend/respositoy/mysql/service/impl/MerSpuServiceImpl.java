package com.qbao.recommend.respositoy.mysql.service.impl;

import com.qbao.recommend.respositoy.mysql.dao.MerSpuDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.SpuInfoMerchant;
import com.qbao.recommend.respositoy.mysql.service.IMerSpuService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * @author	yuandongrui
 * @date 	2016年6月21日
 */
@Service
public class MerSpuServiceImpl implements IMerSpuService {
    @Value("${merchant.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${MER_SPU}")
    private String DATATABLE_NAME;
    
    @Autowired
    private MerSpuDao merSpuDao;

	@Override
	@RedisCache(expire = 60 * 1, clazz = SpuInfoMerchant.class, cacheType = CacheType.OBJECT)
	public SpuInfoMerchant findBySpuIdIgnoreStatus(long spuId) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return merSpuDao.findBySpuIdIgnoreStatus(DATATABLE_NAME, spuId);
	}

	@Override
	@RedisCache(expire = 60 * 1, clazz = SpuInfoMerchant.class, cacheType = CacheType.OBJECT)
	public SpuInfoMerchant findBySpuId(long spuId) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return merSpuDao.findBySpuId(DATATABLE_NAME, spuId);
	}

	@Override
	@RedisCache(expire = 60 * 1, clazz = Long.class, cacheType = CacheType.LIST)
    public List<Long> findSellingAll() {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return merSpuDao.findSellingAll(DATATABLE_NAME);
	}

	@Override
	@RedisCache(expire = 60 * 1, clazz = SpuInfoMerchant.class, cacheType = CacheType.LIST)
	public List<SpuInfoMerchant> findSellingByUserIdLimit(long userId, int page, int pageSize) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		int count = merSpuDao.findSellingByUserIdCount(DATATABLE_NAME, userId);
    	if (page > count/pageSize){
    		if (count%pageSize == 0){
    			page = count/pageSize;
    		}else{
    			page = count/pageSize+1;
    		}
        }
        int start = (page - 1)*pageSize;
        int rows =pageSize;
		return merSpuDao.findSellingByUserIdLimit(DATATABLE_NAME, userId, start, rows);
	}

}

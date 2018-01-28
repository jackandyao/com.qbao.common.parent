package com.qbao.recommend.respositoy.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.RecGoodProductDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.RecGoodProduct;
import com.qbao.recommend.respositoy.mysql.service.IRecGoodProductService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

import java.util.List;

@Service
public class RecGoodProductServiceImpl implements IRecGoodProductService {

	@Value("${recommend.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${REC_GOODPRODUCT}")
    private String REC_GOODPRODUCT;
    
    @Autowired
    private RecGoodProductDao recGoodProductDao;
    
	@Override
	@RedisCache(expire = 60 * 60, clazz = RecGoodProduct.class, cacheType = CacheType.OBJECT)
	public RecGoodProduct findBySpuId(long spuId) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return recGoodProductDao.findBySpuId(REC_GOODPRODUCT, spuId);
	}

	@Override
	@RedisCache(expire = 60 * 60, clazz = RecGoodProduct.class, cacheType = CacheType.LIST)
	public List<RecGoodProduct> findTopNSpuByDirId(long spuId ,int limit) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return recGoodProductDao.findTopNSpuByDirId(REC_GOODPRODUCT, spuId, limit);
	}


}

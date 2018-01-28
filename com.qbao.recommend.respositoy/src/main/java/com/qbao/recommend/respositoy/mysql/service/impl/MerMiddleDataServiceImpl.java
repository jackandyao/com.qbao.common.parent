package com.qbao.recommend.respositoy.mysql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.MerMiddleDataDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.SpuInfoMerchant;
import com.qbao.recommend.respositoy.mysql.service.IMerMiddleDataService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

@Service
public class MerMiddleDataServiceImpl implements IMerMiddleDataService{
	
	@Value("${merchant_middle.datasource.key}")
    private String DATASOURCE_KEY;
	
	@Value("${MER_MIDDLE_DATA}")
	private String MER_MIDDLE_DATA_TABLE_NAME;
	
	@Value("${MER_MIDDLE_MAINIMG_ATTR}")
	private String MER_MIDDLE_MAINIMG_ATTR_TABLE_NAME;
	
	@Value("${SEARCH_TAG_DIRECTORY}")
	private String SEARCH_TAG_DIRECTORY_TABLE_NAME;

	@Autowired
	private  MerMiddleDataDao merMiddleDataDao;

	@Override
	@RedisCache(expire = 60 * 2, clazz = String.class, cacheType = CacheType.LIST)
	public List<String> findIllegalitySpuList() {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return merMiddleDataDao.findIllegalitySpuList(MER_MIDDLE_DATA_TABLE_NAME);
	}

	@Override
	@RedisCache(expire = 60 * 2, clazz = String.class, cacheType = CacheType.LIST)
	public List<String> findIllegalityImgList() {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return merMiddleDataDao.findIllegalityImgList(MER_MIDDLE_MAINIMG_ATTR_TABLE_NAME);
	}

	@Override
	@RedisCache(expire = 60 * 2, clazz = String.class, cacheType = CacheType.LIST)
	public List<String> findIllegalityDirSpuList(String dirId) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return merMiddleDataDao.findIllegalityDirSpuList(MER_MIDDLE_DATA_TABLE_NAME, dirId);
	}

	@Override
	@RedisCache(expire = 60 * 2, clazz = SpuInfoMerchant.class, cacheType = CacheType.LIST)
	public List<SpuInfoMerchant> findTagKeyDirectoryList() {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return merMiddleDataDao.findTagKeyDirectoryList(MER_MIDDLE_DATA_TABLE_NAME, SEARCH_TAG_DIRECTORY_TABLE_NAME);
	}

	@Override
	@RedisCache(expire = 60 * 2, clazz = SpuInfoMerchant.class, cacheType = CacheType.OBJECT)
	public SpuInfoMerchant findBySpuId(Long spuId) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return merMiddleDataDao.findBySpuId(MER_MIDDLE_DATA_TABLE_NAME, spuId);
	}

	@Override
	@RedisCache(expire = 60 * 2, clazz = SpuInfoMerchant.class, cacheType = CacheType.OBJECT)
	public SpuInfoMerchant findBySpuIdIgnoreStatus(Long spuId) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return merMiddleDataDao.findBySpuIdIgnoreStatus(MER_MIDDLE_DATA_TABLE_NAME, spuId);
	}
	
	@Override
	public List<SpuInfoMerchant> findByPage(int offset, int limit) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return merMiddleDataDao.findByPage(MER_MIDDLE_DATA_TABLE_NAME, offset, limit);
	}
}

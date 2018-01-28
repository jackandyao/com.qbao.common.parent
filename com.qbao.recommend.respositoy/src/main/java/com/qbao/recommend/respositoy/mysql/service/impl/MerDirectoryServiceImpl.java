package com.qbao.recommend.respositoy.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.MerDirectoryDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.MerDirectory;
import com.qbao.recommend.respositoy.mysql.service.IMerDirectoryService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

@Service
public class MerDirectoryServiceImpl implements IMerDirectoryService {

	@Value("${directory.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${MER_DIRECTORY}")
    private String MER_DIRECTORY;
    
    @Autowired
    private MerDirectoryDao merDirectoyDao;
    

	@Override
	@RedisCache(expire = 60 * 60, clazz = MerDirectory.class, cacheType = CacheType.OBJECT)
	public MerDirectory findByDirId(String dirId) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return merDirectoyDao.findByDirId(MER_DIRECTORY, dirId);
	}

}

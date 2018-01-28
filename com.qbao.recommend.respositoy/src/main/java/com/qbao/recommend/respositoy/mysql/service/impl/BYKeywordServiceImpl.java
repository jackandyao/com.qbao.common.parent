package com.qbao.recommend.respositoy.mysql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.BYKeywordDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.BYKeyword;
import com.qbao.recommend.respositoy.mysql.service.IBYKeywordService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

@Service("bYKeywordServiceImpl")
public class BYKeywordServiceImpl implements IBYKeywordService {

	@Value("${recommend.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${BY_KEYWORD}")
    private String BY_KEYWORD;
    
    @Autowired
    private BYKeywordDao bykwordDao;

	@Override
//	@RedisCache(expire = 24 * 60 * 60, clazz = BYKeyword.class, cacheType = CacheType.LIST)
	public List<BYKeyword> findAll() {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return bykwordDao.findAll(BY_KEYWORD);
	}

}

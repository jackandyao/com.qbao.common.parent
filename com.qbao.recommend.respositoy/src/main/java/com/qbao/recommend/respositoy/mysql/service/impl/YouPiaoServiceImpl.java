package com.qbao.recommend.respositoy.mysql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.YouPiaoDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.service.IYouPiaoService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

@Service("youPiaoServiceImpl")
public class YouPiaoServiceImpl implements IYouPiaoService {

	@Value("${youpiao.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${TICKETS_FILM}")
    private String TICKETS_FILM;
    
    @Value("${TICKETS_SHOW_INFO}")
    private String TICKETS_SHOW_INFO;
    
    @Autowired
    private YouPiaoDao youPiaoDao;
    

	@Override
//	@RedisCache(expire = 24 * 60 * 60, clazz = String.class, cacheType = CacheType.LIST)
	public List<String> findAllFilmName() {
		// TODO Auto-generated method stub
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return youPiaoDao.findAllFileName(TICKETS_FILM);
	}

	@Override
//	@RedisCache(expire = 24 * 60 * 60, clazz = String.class, cacheType = CacheType.LIST)
	public List<String> findAllShowTitle() {
		// TODO Auto-generated method stub
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return youPiaoDao.findAllShowTitle(TICKETS_SHOW_INFO);
	}

}

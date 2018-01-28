package com.qbao.recommend.respositoy.mysql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.UserViewBuyDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.UserScoreLevel;
import com.qbao.recommend.respositoy.mysql.model.UserViewBuy;
import com.qbao.recommend.respositoy.mysql.service.IUserViewBuyService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

@Service
public class UserViewBuyServiceImpl implements IUserViewBuyService {

	@Value("${recommend.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${USER_VIEW_BUY}")
    private String USER_VIEW_BUY;
    
    @Autowired
    private UserViewBuyDao userViewBuyDao;
    
	@Override
	@RedisCache(expire = 60 * 60, clazz = UserViewBuy.class, cacheType = CacheType.LIST)
	public List<UserViewBuy> findById(long id) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return userViewBuyDao.findById(USER_VIEW_BUY, id);
	}

}

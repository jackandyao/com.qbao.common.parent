/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.RecommendShopDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.RecommendShop;
import com.qbao.recommend.respositoy.mysql.service.IRecShopPrdService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

/**
 * @author sjzhangjun@qbao.com
 *
 * $LastChangedDate: 2016-09-22 18:30:21 +0800 (星期四, 22 九月 2016) $
 * $LastChangedRevision: 1146 $
 * $LastChangedBy: zhangjun $
 */

@Service
public class RecShopPrdServiceImpl implements IRecShopPrdService {
    @Value("${recommend.datasource.key}")
    private String dataSourceKey;

    @Value("${REC_SHOP_PRD}")
    private String tableName;

    @Autowired
    private RecommendShopDao recommendShopDao;

	@Override
	@RedisCache(expire = 60 * 60, clazz = RecommendShop.class, cacheType = CacheType.OBJECT)
	public RecommendShop findByUserId(long userId) {
		MultipleDataSource.setDataSourceKey(dataSourceKey);
		RecommendShop items = recommendShopDao.findByUserId(tableName, userId);
        return items;
	}

}

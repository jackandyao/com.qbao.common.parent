/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.qbao.recommend.respositoy.mysql.dao.RecommendItemsDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.RecommendItems;
import com.qbao.recommend.respositoy.mysql.service.IRecSimilaryService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;


/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-06 19:10:32 +0800 (Tue, 06 Sep 2016) $
 * $LastChangedRevision: 912 $
 * $LastChangedBy: wangping $
 */
@Service
public class RecSimilaryServiceImpl implements IRecSimilaryService{

    @Value("${recommend.datasource.key}")
    private String dataSourceKey;
    
    @Value("${RECOMMEND_SIMILARY}")
    private String tableName;
    
    @Autowired
    private RecommendItemsDao recommendItemsDao;
    
    @Override
    @RedisCache(expire=60*60,clazz=RecommendItems.class,cacheType=CacheType.OBJECT)
    public RecommendItems findByUserId(long userId) {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        RecommendItems items = recommendItemsDao.findById(tableName, userId);
        return items;
    }

}

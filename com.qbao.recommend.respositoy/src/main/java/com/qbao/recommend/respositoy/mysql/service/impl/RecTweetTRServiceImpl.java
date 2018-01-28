/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service.impl;

import com.qbao.recommend.respositoy.mysql.dao.RecommendTweetItemsDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.RecommendTweetItems;
import com.qbao.recommend.respositoy.mysql.service.IRecTweetTRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;
/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-10-01 21:25:34 +0800 (Sat, 01 Oct 2016) $
 * $LastChangedRevision: 1243 $
 * $LastChangedBy: wangping $
 */
@Service("recTweetTRServiceImpl")
public class RecTweetTRServiceImpl implements IRecTweetTRService {

    @Value("${recommend.datasource.key}")
    private String dataSourceKey;

    @Value("${RECOMMEND_TWEET_TR}")
    private String tableName;

    @Autowired
    private RecommendTweetItemsDao recommendTweetItemsDao;

    @Override
    @RedisCache(expire = 60 * 60, clazz = RecommendTweetItems.class, cacheType = CacheType.OBJECT)
    public RecommendTweetItems findByUserId(long userId) {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        RecommendTweetItems items = recommendTweetItemsDao.findById(tableName, userId);
        return items;
    }

}

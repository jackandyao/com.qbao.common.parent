/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.qbao.recommend.respositoy.mysql.dao.RecommendItemsDao;
import com.qbao.recommend.respositoy.mysql.dao.RecommendLookItemsDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.RecommendLookItems;
import com.qbao.recommend.respositoy.mysql.service.IRecLookAgainService;
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
public class RecLookAgainServiceImpl implements IRecLookAgainService{

    @Value("${recommend.datasource.key}")
    private String dataSourceKey;
    
    @Value("${REC_LOOKAGAIN}")
    private String tableName;
    
    @Autowired
    private RecommendLookItemsDao recommendLookItemsDao;
    
    @Override
    @RedisCache(expire=60*60,clazz=RecommendLookItems.class,cacheType=CacheType.OBJECT)
    public RecommendLookItems findByIdAndType(long id, int type) {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        RecommendLookItems items = recommendLookItemsDao.findByIdAndType(tableName, id, type);
        return items;
    }

}

/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.HyipTaskDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.HyipTask;
import com.qbao.recommend.respositoy.mysql.service.IHyipTaskService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-19 18:38:46 +0800 (Mon, 19 Sep 2016) $
 * $LastChangedRevision: 1071 $
 * $LastChangedBy: shuaizhihu $
 */
@Service
public class HyipTaskServiceImpl implements IHyipTaskService {

    @Value("${hyip.task.datasource.key}")
    private String dataSourceKey;

    @Value("${HYIP_TASK}")
    private String tableName;

    @Autowired
    private HyipTaskDao hyipTaskDao;

    @Override
    @RedisCache(expire = 60 * 2, clazz = HyipTask.class, cacheType = CacheType.OBJECT)
    public HyipTask findById(long id) {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        return hyipTaskDao.findById(tableName, id);
    }

//    @Override
//    public List<HyipTask> findTasksOrderByMargins(int limit) {
//        MultipleDataSource.setDataSourceKey(dataSourceKey);
//        return hyipTaskDao.findTasksOrderByMargins(tableName, limit);
//    }

    /* (non-Javadoc)
     * @see com.qbao.recommend.respositoy.mysql.service.IHyipTaskService#findTasksOrderByMargins(int, int)
     */
    @Override
    @RedisCache(expire = 60 * 2, clazz = HyipTask.class, cacheType = CacheType.LIST)
    public List<HyipTask> findTasksOrderByMargins(int limit, int adsType) {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        return hyipTaskDao.findTasksOrderByMargins(tableName, limit, adsType);
    }

    @Override
    @RedisCache(expire = 60 * 2, clazz = HyipTask.class, cacheType = CacheType.LIST)
    public List<HyipTask> getAllTasksByAdsType(int adsType) {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        return hyipTaskDao.findAllByAdsType(tableName,adsType);
    }

    @Override
    @RedisCache(expire = 60 * 2, clazz = HyipTask.class, cacheType = CacheType.LIST)
    public List<HyipTask> findTasksLessMargins(long margins, int limit, int adsType) {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        return hyipTaskDao.findTasksLessMargins(tableName,margins,limit,adsType);
    }

}

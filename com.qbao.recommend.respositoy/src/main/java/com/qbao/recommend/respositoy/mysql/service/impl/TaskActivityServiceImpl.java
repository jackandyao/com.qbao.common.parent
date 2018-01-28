/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.qbao.recommend.respositoy.mysql.dao.TaskActivityDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.TaskActivity;
import com.qbao.recommend.respositoy.mysql.service.ITaskActivityService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-14 18:00:24 +0800 (Wed, 14 Sep 2016) $
 * $LastChangedRevision: 1027 $
 * $LastChangedBy: wangping $
 */
@Service
public class TaskActivityServiceImpl implements ITaskActivityService {

    @Value("${task.activity.datasource.key}")
    private String dataSourceKey;

    @Value("${TASK_ACTIVITY}")
    private String tableName;

    @Autowired
    private TaskActivityDao taskActivityDao;

    @Override
    @RedisCache(expire = 60 * 10, clazz = TaskActivity.class, cacheType = CacheType.LIST)
    public List<TaskActivity> findTasksOrderByMargins(int limit) {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        return taskActivityDao.findTasksOrderByMargins(tableName, limit);
    }

    @Override
    @RedisCache(expire = 60 * 10, clazz = TaskActivity.class, cacheType = CacheType.OBJECT)
    public TaskActivity findById(long id) {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        return taskActivityDao.findById(tableName, id);
    }

    @Override
    @RedisCache(expire = 60 * 10, clazz = TaskActivity.class, cacheType = CacheType.LIST)
    public List<TaskActivity> getAllTaskActivities() {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        return taskActivityDao.findAllTaskActivities(tableName);
    }

    @Override
    @RedisCache(expire = 60 * 10, clazz = TaskActivity.class, cacheType = CacheType.LIST)
    public List<TaskActivity> findTasksLessMargins(long margins, int limit) {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        return taskActivityDao.findTasksLessMargins(tableName, margins, limit);
    }
}

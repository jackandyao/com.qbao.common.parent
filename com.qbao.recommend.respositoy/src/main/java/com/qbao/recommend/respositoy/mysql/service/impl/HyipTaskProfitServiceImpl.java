package com.qbao.recommend.respositoy.mysql.service.impl;

import com.qbao.recommend.respositoy.mysql.dao.HyipTaskProfitDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.HyipTaskProfit;
import com.qbao.recommend.respositoy.mysql.service.IHyipTaskProfitService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author wangping
 * @createTime 上午11:49
 * $$LastChangedDate: 2016-11-03 14:07:14 +0800 (Thu, 03 Nov 2016) $$
 * $$LastChangedRevision: 1374 $$
 * $$LastChangedBy: wangping $$
 */
@Service
public class HyipTaskProfitServiceImpl implements IHyipTaskProfitService {

    @Value("${hyip.task.datasource.key}")
    private String dataSourceKey;

    @Value("${HYIP_TASK_PROFIT}")
    private String tableName;

    @Autowired
    private HyipTaskProfitDao dao;

    @Override
    @RedisCache(expire = 60 * 60, clazz = HyipTaskProfit.class, cacheType = CacheType.OBJECT)
    public HyipTaskProfit findByTaskId(long taskId) {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        return dao.findByTaskId(tableName, taskId);
    }
}

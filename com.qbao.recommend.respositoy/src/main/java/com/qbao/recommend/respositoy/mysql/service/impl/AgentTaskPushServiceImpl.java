package com.qbao.recommend.respositoy.mysql.service.impl;

import com.qbao.recommend.respositoy.mysql.dao.AgentTaskPushDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.AgentTaskPush;
import com.qbao.recommend.respositoy.mysql.service.IAgentTaskPushService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangping
 * @createTime 下午2:39
 * $$LastChangedDate: 2016-12-05 19:03:49 +0800 (Mon, 05 Dec 2016) $$
 * $$LastChangedRevision: 1513 $$
 * $$LastChangedBy: wangping $$
 */

@Service
public class AgentTaskPushServiceImpl implements IAgentTaskPushService {
    @Value("${agent.datasource.key}")
    private String DATASOURCE_KEY;

    @Value("${AGENT_TASK_PUSH}")
    private String tableName;

    @Autowired
    private AgentTaskPushDao dao;


    @Override
    @RedisCache(expire = 60 * 10, clazz = AgentTaskPush.class, cacheType = CacheType.LIST)
    public List<AgentTaskPush> findByUserId(long userId) {
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        return dao.findByUserId(tableName, userId);
    }
}

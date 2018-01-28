package com.qbao.recommend.respositoy.mysql.service.impl;

import com.qbao.recommend.respositoy.mysql.dao.AgentTaskDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.AgentTask;
import com.qbao.recommend.respositoy.mysql.service.IAgentTaskService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuandongrui
 * @date 2016年7月11日
 */
@Service
public class AgentTaskServiceImpl implements IAgentTaskService {

    @Value("${agent.datasource.key}")
    private String DATASOURCE_KEY;

    @Value("${AGENT_TASK}")
    private String DATATABLE_NAME;

    @Autowired
    private AgentTaskDao agentTaskDao;

    @Override
    @RedisCache(expire = 60 * 10, clazz = AgentTask.class, cacheType = CacheType.OBJECT)
    public AgentTask findById(long id) {
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        AgentTask agentTask = agentTaskDao.findById(DATATABLE_NAME, id);
        return agentTask != null ? agentTask : null;
    }

    @Override
    @RedisCache(expire = 60 * 10, clazz = AgentTask.class, cacheType = CacheType.OBJECT)
    public AgentTask findByIdAndTaskType(long id, int taskType) {
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        AgentTask agentTask = agentTaskDao.findByIdAndTaskType(DATATABLE_NAME, id,taskType);
        return agentTask != null ? agentTask : null;
    }

    @Override
    @RedisCache(expire = 60 * 10, clazz = AgentTask.class, cacheType = CacheType.OBJECT)
    public AgentTask findRecommendTaskByIdAndTaskType(long id) {
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        AgentTask agentTask = agentTaskDao.findRcommendTaskById(DATATABLE_NAME, id);
        return agentTask != null ? agentTask : null;
    }

    @Override
    @RedisCache(expire = 60 * 10, clazz = AgentTask.class, cacheType = CacheType.OBJECT)
    public AgentTask findByIdAndNotEqualTaskType(long id, int  taskType) {
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        AgentTask agentTask = agentTaskDao.findByIdAndNotEqualTaskType(DATATABLE_NAME, id,taskType);
        return agentTask != null ? agentTask : null;
    }

    @Override
    @RedisCache(expire = 60 * 2, clazz = Boolean.class, cacheType = CacheType.OBJECT)
    public boolean isSellingByTaskId(long taskId) {
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        AgentTask task = agentTaskDao.findRcommendTaskById(DATATABLE_NAME, taskId);
        if (task != null && task.getStatus() == 4) {
            return true;
        }
        return false;
    }

    @Override
    @RedisCache(expire = 60 * 10, clazz = AgentTask.class, cacheType = CacheType.LIST)
    public List<AgentTask> findTasksOrderByMargins(int limit) {
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        return agentTaskDao.findTasksOrderByMargins(DATATABLE_NAME, limit);
    }

}

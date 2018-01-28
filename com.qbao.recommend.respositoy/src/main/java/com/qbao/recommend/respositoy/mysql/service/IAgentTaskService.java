package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.AgentTask;

import java.util.List;

/**
 * @author yuandongrui
 * @date 2016年7月11日
 */
public interface IAgentTaskService {
    /**
     * 根据分销id获取分销实体
     * 
     * @param id
     * @return
     */
    public AgentTask findById(long id);

    public AgentTask findByIdAndTaskType(long id, int taskType);

    public AgentTask findRecommendTaskByIdAndTaskType(long id);

    public AgentTask findByIdAndNotEqualTaskType(long id, int taskType);


    /**
     * 根据taksId判断是否上架
     * 
     * @param taskId
     * @return
     */
    public boolean isSellingByTaskId(long taskId);

    public List<AgentTask> findTasksOrderByMargins(int limit);
}

package com.qbao.recommend.business.task.cmp.common;

import com.google.common.collect.Lists;
import com.qbao.recommend.business.task.cmp.model.dto.TaskDto;
import com.qbao.recommend.respositoy.mysql.model.AgentTask;
import com.qbao.recommend.respositoy.mysql.model.AgentTaskPush;
import com.qbao.recommend.respositoy.mysql.service.IAgentTaskPushService;
import com.qbao.recommend.respositoy.mysql.service.IAgentTaskService;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author wangping
 * @createTime 上午10:20
 * $$LastChangedDate: 2016-12-05 19:03:49 +0800 (Mon, 05 Dec 2016) $$
 * $$LastChangedRevision: 1513 $$
 * $$LastChangedBy: wangping $$
 */
@Service("agentTaskPushRecommender")
public class AgentTaskPushRecommender implements ITaskRecommender {

    private Logger logger = LoggerManagerUtil.getLogger(LogNameEnum.task, Level.INFO);

    @Autowired
    private IAgentTaskService agentTaskService;

    @Autowired
    private IAgentTaskPushService agentTaskPushService;

    @Override
    public List<TaskDto> recommend(long userId, long asset, int limit) {
        List<TaskDto> result = Lists.newArrayList();
        List<AgentTaskPush> agentTaskPushs = agentTaskPushService.findByUserId(userId);
        if (CollectionUtils.isNotEmpty(agentTaskPushs)) {
            //valid conditions  agent_task_push.status&&agent_task.status
            logger.info("Got [" + agentTaskPushs.size() + "] size AgentTaskPush by user id =[" + userId + "]");
            for (AgentTaskPush agentTaskPush : agentTaskPushs) {
                if (result.size() >= limit) break;
                    final Long taskId = agentTaskPush.getTaskId();
                    logger.info("Got [" + agentTaskPushs.size() + "] AgentTaskPush by user id =[" + userId + "]");
                    TaskDto taskDto = agentToTaskDto(taskId);
                    if (null != taskDto) {
                        logger.info(" task id =[" + taskId + "] in Agent_task is valid and user id =[" + userId + "]");
                        result.add(taskDto);
                    } else {
                        logger.info(" task id =[" + taskId + "] in Agent_task is invalid user id =[" + userId + "]");
                    }

            }
        }
        return result;
    }

    private TaskDto agentToTaskDto(long agentTaskId) {
        AgentTask agentTask = agentTaskService.findByIdAndTaskType(agentTaskId,getTaskType());
        return AgentTaskRecommender.agentToTaskDto(agentTask);
    }

    @Override
    public int getTaskType() {
        return 5;
    }
}

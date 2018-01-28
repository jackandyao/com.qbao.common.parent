/**
 * 
 */
package com.qbao.recommend.business.task.cmp.common;

import com.qbao.recommend.business.task.cmp.model.dto.TaskDto;
import com.qbao.recommend.business.task.cmp.util.FenXiaoUtils;
import com.qbao.recommend.business.task.cmp.util.RecAgentGuessUtils;
import com.qbao.recommend.respositoy.mysql.model.AgentTask;
import com.qbao.recommend.respositoy.mysql.model.RecAgentGuess;
import com.qbao.recommend.respositoy.mysql.service.IAgentTaskService;
import com.qbao.recommend.respositoy.mysql.service.IRecAgentGuessService;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-12-06 15:44:21 +0800 (Tue, 06 Dec 2016) $
 * $LastChangedRevision: 1517 $
 * $LastChangedBy: wangping $
 */
@Service("agentTaskRecommender")
public class AgentTaskRecommender implements ITaskRecommender {
    private Logger logger = LoggerManagerUtil.getLogger(LogNameEnum.task, Level.INFO);

    @Autowired
    private IRecAgentGuessService recAgentGuessService;

    @Autowired
    private IAgentTaskService agentTaskService;

    @Override
    public List<TaskDto> recommend(long userId, long asset,int limit) {
        List<Long> ids = fetchRecommendRes(userId,asset, limit);
        logger.info("user id [" + userId + "] , recomend the agent task " + ids);
        return agentToTaskDto(ids);

    }

    private TaskDto agentToTaskDto(long agentTaskId) {
        //ART(3, "艺术品"), ORDER(4, "预约") and 5 特定人群 不用个性化
        AgentTask agentTask = agentTaskService.findRecommendTaskByIdAndTaskType(agentTaskId);
        return  agentToTaskDto(agentTask);
    }
    protected static TaskDto agentToTaskDto(AgentTask agentTask ){
        TaskDto taskDto = null;
        if (null != agentTask) {
            taskDto = new TaskDto();
            taskDto.setTaskId(agentTask.getId());
            taskDto.setName(agentTask.getTaskName());
            taskDto.setCoverUrl(agentTask.getLogoBigUrl());
            taskDto.setDays(agentTask.getTaskCycle());
            taskDto.setMargins(agentTask.getJoinFee().toString());
            taskDto.setReward(agentTask.getRmbSubsidy().toString());
            taskDto.setRewardBaoquan(agentTask.getBqSubsidy().toString());
            //check the taskTye value source from db or from  ITaskRecommender.getTaskType() method
            taskDto.setTaskType(agentTask.getTaskType());
        }
        return taskDto;
    }

    private List<TaskDto> agentToTaskDto(List<Long> agentTaskIds) {
        List<TaskDto> result = new ArrayList<TaskDto>();
        for (Long id : agentTaskIds) {
            TaskDto taskDto = agentToTaskDto(id);
            if (null != taskDto) {
                result.add(taskDto);
            }
        }
        return result;
    }

    @Cacheable(value = "1hourCache", key = "#userId+'AgentTaskRecommender.fetchOffLineRecomm'")
    private List<Long> fetchOffLineRecomm(Long userId) {
        RecAgentGuess recommend = null;
        try {
            recommend = recAgentGuessService.findByUserId(userId);
            logger.info("The RecAgentGuess value : " + recommend);
        } catch (Exception e) {
            logger.error("fetch agent recommend result : ", e);
        }
        List<Long> taskIds = RecAgentGuessUtils.parseTasks(recommend);
        logger.info("Total recommend result size = [" + taskIds.size() + "] for user id = [" + userId + "]");
        return taskIds;
    }

    public List<Long> fetchRecommendRes(Long userId, long asset, int returnSize) {
        // 1.fetch offline result
        List<Long> recommendRes = fetchOffLineRecomm(userId);
        // 2.delete the off time agent id
        delOffTimeAgent(recommendRes);
        logger.info("After filter the off time agent , the rest of recommend size = [" + recommendRes.size() + "] for user id = [" + userId + "]");
        // return the expected size item
        if (recommendRes.size() >= returnSize) {
            recommendRes = FenXiaoUtils.subList(recommendRes, 0, returnSize);
        } else {
            logger.info("The recommend result size=[" + recommendRes.size() + "], less then expect size =[" + returnSize + "], and using the default result as additional result ");
            FenXiaoUtils.appendElements(recommendRes, fetchDefaultRecommendRes(), returnSize - recommendRes.size());
        }
        return recommendRes;
    }

    public List<Long> fetchDefaultRecommendRes() {
        // 1.fetch offline result
        List<Long> recommendRes = fetchOffLineRecomm(-1L);
        // 2.delete the off time agent id
        delOffTimeAgent(recommendRes);
        return recommendRes;
    }

    public void delOffTimeAgent(List<Long> agentIds) {
        if (CollectionUtils.isNotEmpty(agentIds)) {
            Iterator<Long> it = agentIds.iterator();
            while (it.hasNext()) {
                Long agentId = it.next();
                if (isOffTime(agentId)) {
                    logger.info("agent id =[" + agentId + "] is off time, and be deleted");
                    it.remove();
                }
            }
        }
    }

    @Cacheable(value = "twoMinCache", key = "#agentId+'AgentTaskRecommender.isOffTime'")
    private boolean isOffTime(long agentId) {
        return !agentTaskService.isSellingByTaskId(agentId);
    }

    @Override
    public int getTaskType() {
        return -1;
    }
}

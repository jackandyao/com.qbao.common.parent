/**
 * 
 */
package com.qbao.recommend.business.task.cmp.common;

import com.qbao.recommend.business.task.cmp.model.dto.TaskDto;
import com.qbao.recommend.respositoy.mysql.model.TaskActivity;
import com.qbao.recommend.respositoy.mysql.service.ITaskActivityService;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-12-05 18:53:02 +0800 (Mon, 05 Dec 2016) $
 * $LastChangedRevision: 1510 $
 * $LastChangedBy: wangping $
 */
@Service("taskActivityRecommender")
public class TaskActivityRecommender implements ITaskRecommender {

    private Logger logger = LoggerManagerUtil.getLogger(LogNameEnum.task, Level.INFO);

    @Autowired
    private ITaskActivityService taskActivityService;

    @Override
    public List<TaskDto> recommend(long userId, long asset, int limit) {
        List<TaskActivity> taskActivities = taskActivityService.findTasksLessMargins(asset, limit);
        logger.info("user id [" + userId + "] , recomend the ask activity " + taskActivities);
        return taskActivitieToTaskDto(taskActivities);
    }

    private List<TaskDto> taskActivitieToTaskDto(List<TaskActivity> taskActivities) {
        List<TaskDto> result = new ArrayList<TaskDto>();
        for (TaskActivity taskActivitiy : taskActivities) {
            TaskDto taskDto = taskActivitieToTaskDto(taskActivitiy);
            if (null != taskDto) {
                result.add(taskDto);
            }
        }
        return result;
    }

    private TaskDto taskActivitieToTaskDto(TaskActivity taskActivitiy) {
        TaskDto taskDto = null;
        if (null != taskActivitiy) {
            taskDto = new TaskDto();
            taskDto.setTaskId(taskActivitiy.getId());
            taskDto.setName(taskActivitiy.getActivityName());
            taskDto.setCoverUrl(taskActivitiy.getActivityImgUrl());
            taskDto.setDays(taskActivitiy.getDays());
            taskDto.setMargins(String.valueOf(taskActivitiy.getMargins()));
            taskDto.setReward(String.valueOf(taskActivitiy.getReward()));
            taskDto.setRewardBaoquan(String.valueOf(taskActivitiy.getExtraReward()));
            taskDto.setTaskType(getTaskType());
        }
        return taskDto;
    }

    @Override
    public int getTaskType() {
        return 3;
    }

}

/**
 * 
 */
package com.qbao.recommend.business.task.cmp.common;

import com.qbao.recommend.business.task.cmp.model.dto.TaskDto;
import com.qbao.recommend.respositoy.mysql.model.HyipTask;
import com.qbao.recommend.respositoy.mysql.model.HyipTaskProfit;
import com.qbao.recommend.respositoy.mysql.service.IHyipTaskProfitService;
import com.qbao.recommend.respositoy.mysql.service.IHyipTaskService;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
@Service("hyipTaskRecommender")
public class HyipTaskRecommender implements ITaskRecommender {
    private Logger logger = LoggerManagerUtil.getLogger(LogNameEnum.task, Level.INFO);
    @Autowired
    private IHyipTaskService hyipTaskService;

    @Autowired
    private IHyipTaskProfitService  hyipTaskProfitService;

    @Override
    public List<TaskDto> recommend(long userId, long asset,int limit) {
        // 图片
        List<HyipTask> hyipTaks = hyipTaskService.findTasksLessMargins(asset, limit, 1);
        if (CollectionUtils.isEmpty(hyipTaks)) {
            // 视频
            hyipTaks = hyipTaskService.findTasksLessMargins(asset, limit, 2);
        }
        logger.info("user id [" + userId + "] , recomend the hyip task " + hyipTaks);
        return toTaskDto(hyipTaks);
    }

    private List<TaskDto> toTaskDto(List<HyipTask> hyipTasks) {
        List<TaskDto> result = new ArrayList<TaskDto>();
        for (HyipTask hyipTask : hyipTasks) {
            TaskDto taskDto = toTaskDto(hyipTask);
            if (null != taskDto) {
                result.add(taskDto);
            }
        }
        return result;
    }

    private TaskDto toTaskDto(HyipTask hyipTask) {
        TaskDto taskDto = null;
        if (null != hyipTask) {
            taskDto = new TaskDto();
            taskDto.setTaskId(hyipTask.getId());
            taskDto.setName(hyipTask.getTaskName());
            taskDto.setCoverUrl(hyipTask.getCpaImgUrl() + "_medium.html");
            taskDto.setDays(hyipTask.getDays());
            taskDto.setMargins(String.valueOf(hyipTask.getMargins()));
            taskDto.setReward(String.valueOf(hyipTask.getTotalReward()));
            taskDto.setRewardBaoquan(calHyipTaskBaoQuan(hyipTask.getId()));
            taskDto.setTaskType(hyipTask.getAdsType());
        }
        return taskDto;
    }

    @Cacheable(value = "1hourCache", key = "#hyipTaskId+'hyipTaskToTaskDto'")
    private TaskDto hyipTaskToTaskDto(long hyipTaskId) {
        HyipTask hyipTask = hyipTaskService.findById(hyipTaskId);
        return toTaskDto(hyipTask);
    }

    @Override
    public int getTaskType() {
        return 0;
    }

    private String calHyipTaskBaoQuan(long taskId){
        String result = "0";
        HyipTaskProfit profit = hyipTaskProfitService.findByTaskId(taskId);
        if(null != profit){
          long totalBaoQuan =  profit.getCompletedSendNum() + profit.getReceivedSendNum()+ profit.getSettledSendNum();
            result = Long.toString(totalBaoQuan);
        }
        return result;
    }
}

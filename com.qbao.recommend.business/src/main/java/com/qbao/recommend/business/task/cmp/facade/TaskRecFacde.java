/**
 *
 */
package com.qbao.recommend.business.task.cmp.facade;

import com.google.common.collect.Lists;
import com.qbao.recommend.business.task.cmp.common.ITaskRecommender;
import com.qbao.recommend.business.task.cmp.common.UserService;
import com.qbao.recommend.business.task.cmp.model.dto.TaskDto;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2017-01-25 13:22:03 +0800 (Wed, 25 Jan 2017) $
 * $LastChangedRevision: 1557 $
 * $LastChangedBy: wangping $
 */
@Component
public class TaskRecFacde {
    private Logger logger = LoggerManagerUtil.getLogger(LogNameEnum.task, Level.INFO);

    @Autowired
    @Qualifier("agentTaskRecommender")
    private ITaskRecommender agentTaskRecommender;
//
//    @Autowired
//    @Qualifier("hyipTaskRecommender")
//    private ITaskRecommender hyipTaskRecommender;
//
//    @Autowired
//    @Qualifier("taskActivityRecommender")
//    private ITaskRecommender taskActivityRecommender;

    @Autowired
    @Qualifier("agentTaskPushRecommender")
    private ITaskRecommender agentTaskPushRecommender;

    @Autowired
    private UserService userService;

    public List<TaskDto> recommend(long userId,int limit) {
        List<TaskDto> result = Lists.newArrayList();
        //特定的人特定分销任务
        result = agentTaskPushRecommender.recommend(userId, 0, limit);
        if (CollectionUtils.isNotEmpty(result) && result.size() >= limit) {
            logger.info("catch the agent task push data , user id =[" + userId + "]");
            return result;
        }

        logger.info("user id [" + userId + "] try to use AgentTaskRecommender ....");
        result.addAll(agentTaskRecommender.recommend(userId, 0, limit - result.size()));

////        //
//        long asset = userService.getUserAsset(userId);
//        UserLevel level = userService.getUserLevel(userId);
//
//        // TODO
//        switch (level) {
//        case P_LV7:
//        case P_LV6:
//        case P_LV5:
//        case P_LV4:
//            logger.info("user id [" + userId + "] try to use HyipTaskRecommender ....");
//            result.addAll(hyipTaskRecommender.recommend(userId, asset, limit - result.size()));
//            // 补全
//            if (CollectionUtils.isEmpty(result) || result.size() < limit) {
//                logger.info("user id [" + userId + "] try to use AgentTaskRecommender as additional result ....");
//                result.addAll(agentTaskRecommender.recommend(userId, asset, limit - result.size()));
//            }
//            break;
//        case P_LV3:
//        case P_LV2:
//            //logger.info("user id [" + userId + "] try to use TaskActivityRecommender ....");
//            //result = taskActivityRecommender.recommend(userId, asset, limit);
//            //break;
//        case P_LV1:
//        case UNKNOW:
//            logger.info("user id [" + userId + "] try to use AgentTaskRecommender ....");
//            result.addAll(agentTaskRecommender.recommend(userId, asset, limit - result.size()));
//            break;
//        }
        return result;
    }

}

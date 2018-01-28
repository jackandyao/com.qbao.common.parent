/**
 * 
 */
package com.qbao.recommend.business.task.cmp.factory;

import com.google.common.base.Preconditions;
import com.qbao.recommend.business.task.cmp.common.ITaskRecommender;
import com.qbao.recommend.business.task.cmp.model.user.UserLevel;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-13 22:24:14 +0800 (Tue, 13 Sep 2016) $
 * $LastChangedRevision: 1016 $
 * $LastChangedBy: wangping $
 */
public class TaskRecommenderFactory {

    public static ITaskRecommender getRecommender(String level) {
        UserLevel userLevel = UserLevel.valueOf(level);
        Preconditions.checkNotNull(userLevel, " user level is not definited " + level);
        switch (userLevel) {
        case P_LV7:
            break;
        case P_LV6:

            break;
        case P_LV5:

            break;
        case P_LV4:

            break;
        case P_LV3:

            break;
        case P_LV2:

            break;
        case P_LV1:
            break;
        default:
            break;
        }
        return null;
    }

}

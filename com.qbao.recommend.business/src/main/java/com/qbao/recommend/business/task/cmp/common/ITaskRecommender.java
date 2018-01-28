/**
 * 
 */
package com.qbao.recommend.business.task.cmp.common;

import com.qbao.recommend.business.task.cmp.model.dto.TaskDto;

import java.util.List;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-12-05 18:53:02 +0800 (Mon, 05 Dec 2016) $
 * $LastChangedRevision: 1510 $
 * $LastChangedBy: wangping $
 */
public interface ITaskRecommender {
    /**
    * 
    * */
    public List<TaskDto> recommend(long userId, long asset, int returnSize);

    /// **任务类型 1： 图片任务类型 2：视频任务类型 3：分享任务类型 4：分销任务类型 5 特定推送* /
    public int getTaskType();
}

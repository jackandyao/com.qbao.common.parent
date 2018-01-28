package com.qbao.recommend.respositoy.mysql.service;

import java.util.List;

import com.qbao.recommend.respositoy.mysql.model.TaskActivity;

/**
 * @author yuandongrui
 * @date 2016年7月11日
 */
public interface ITaskActivityService {

    public TaskActivity findById(long id);

    public List<TaskActivity> findTasksOrderByMargins(int limit);

    public List<TaskActivity> findTasksLessMargins(long margins, int limit);

    public List<TaskActivity> getAllTaskActivities();
}

package com.qbao.recommend.respositoy.mysql.service;

import java.util.List;

import com.qbao.recommend.respositoy.mysql.model.HyipTask;

/**
 * @author yuandongrui
 * @date 2016年7月11日
 */
public interface IHyipTaskService {

    public HyipTask findById(long id);

//    /**
//     * 根据taksId判断是否上架
//     * 
//     * @param taskId
//     * @return
//     */
//    public List<HyipTask> findTasksOrderByMargins(int limit);

    /**
     * 
     * @param limit
     * @param adsType
     * 1 图片 2 视频
     * @return
     */
    public List<HyipTask> findTasksOrderByMargins(int limit, int adsType);

    /**
     * 
     * @param adsType
     * 1 图片 2 视频
     * @return
     */
    public List<HyipTask> getAllTasksByAdsType(int adsType);

    /**
     * @param asset
     * @param limit
     * @param adsType
     * 1 图片 2 视频
     * @return
     */
    public List<HyipTask> findTasksLessMargins(long margins, int limit, int adsType);
}

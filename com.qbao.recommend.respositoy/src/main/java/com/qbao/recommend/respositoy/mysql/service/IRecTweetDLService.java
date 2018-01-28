package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.RecommendTweetItems;

/**
 * @author zhangjun
 * @date 2016年9月8日
 */
public interface IRecTweetDLService {
    public RecommendTweetItems findByUserId(long userId);
}

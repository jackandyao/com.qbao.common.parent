package com.qbao.recommend.business.distribution.cmp.service;

import java.util.List;

/**
 * @author	yuandongrui
 * @date 	2016年7月11日
 */
public interface IFenXiaoLookBiz {
    public List<Long> fetchRecommendRes(Long userId, Long agentId);
    public List<Long> fetchRecommendRes(Long userId,Long agentId,int returnSize);
    public List<Long> fetchDefaultRecommendRes();
}

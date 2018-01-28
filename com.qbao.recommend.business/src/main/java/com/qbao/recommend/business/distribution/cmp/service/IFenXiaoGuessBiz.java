package com.qbao.recommend.business.distribution.cmp.service;

import java.util.List;

/**
 * @author	yuandongrui
 * @date 	2016年7月11日
 */
public interface IFenXiaoGuessBiz {
    public List<Long> fetchRecommendRes(Long userId);
    public List<Long> fetchRecommendRes(Long userId,int returnSize);
    public List<Long> fetchDefaultRecommendRes();
}

package com.qbao.recommend.business.distribution.cmp.service;

import java.util.List;

/**
 * @author	yuandongrui
 * @date 	2016年7月8日
 */
public interface IFenXiaoRecommendBiz {
	
    public List<Long> fetchRecommendGuessRes(Long userId) ;

    public List<Long> fetchRecommendLookRes(Long userId, Long agentId);
}

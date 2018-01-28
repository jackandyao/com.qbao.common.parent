package com.qbao.recommend.business.distribution.cmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qbao.recommend.business.distribution.cmp.service.IFenXiaoGuessBiz;
import com.qbao.recommend.business.distribution.cmp.service.IFenXiaoLookBiz;
import com.qbao.recommend.business.distribution.cmp.service.IFenXiaoRecommendBiz;

/**
 * @author yuandongrui
 * @date 2016年7月8日
 */
@Component
public class FenXiaoRecommendBizImpl implements IFenXiaoRecommendBiz {
	
	@Autowired
	IFenXiaoGuessBiz fenXiaoGuessBiz;
	
	@Autowired
	IFenXiaoLookBiz fenXiaoLookBiz;


	@Override
	public List<Long> fetchRecommendLookRes(Long userId, Long agentId) {
		return fenXiaoLookBiz.fetchRecommendRes(userId, agentId);
	}


	@Override
	public List<Long> fetchRecommendGuessRes(Long userId) {
		return fenXiaoGuessBiz.fetchRecommendRes(userId);
	}	
}

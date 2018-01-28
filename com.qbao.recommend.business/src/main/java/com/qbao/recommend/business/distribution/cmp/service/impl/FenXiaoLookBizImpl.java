package com.qbao.recommend.business.distribution.cmp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qbao.recommend.business.distribution.cmp.common.AbstractFenXiaoRecommend;
import com.qbao.recommend.business.distribution.cmp.service.IFenXiaoLookBiz;
import com.qbao.recommend.business.distribution.cmp.util.ConstantUtils;
import com.qbao.recommend.business.distribution.cmp.util.FenXiaoUtils;
import com.qbao.recommend.business.distribution.cmp.util.RecAgentLookUtils;
import com.qbao.recommend.respositoy.mysql.model.RecAgentLook;
import com.qbao.recommend.respositoy.mysql.service.IRecAgentLookService;

/**
 * @author yuandongrui
 * @date 2016年7月11日
 */
@Component
public class FenXiaoLookBizImpl extends AbstractFenXiaoRecommend implements IFenXiaoLookBiz {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    IRecAgentLookService recAgentLookService;

    @Override
    public List<Long> fetchRecommendRes(Long userId, Long agentId) {
        return fetchRecommendRes(userId, agentId, ConstantUtils.DEFAULT_RETURN_SIZE_LOOK);
    }

    @Override
    public List<Long> fetchRecommendRes(Long userId, Long agentId, int returnSize) {
        List<Long> recAgentIds = fetchOffLineRecomm(agentId);
        Set<Long> histryViewAgentIds = getUserAgentHistory(userId); //
        logger.info("Histroy view agent id size = [" + histryViewAgentIds.size() + "] for user id = [" + userId + "]");
        FenXiaoUtils.delAgentIds(recAgentIds, histryViewAgentIds);
        if (recAgentIds.size() >= returnSize) {
            recAgentIds = FenXiaoUtils.subList(recAgentIds, 0, returnSize);
        } else {
            logger.info("The recommend result size=[" + recAgentIds.size() + "], less then expect size =[" + returnSize + "], and using the default result as additional result ");
            FenXiaoUtils.appendElements(recAgentIds, fetchDefaultRecommendRes(), returnSize - recAgentIds.size());
        }
        return recAgentIds;
    }

    @Override
    public List<Long> fetchDefaultRecommendRes() {
        // 1.fetch offline result
        List<Long> recommendRes = fetchOffLineRecomm(-1L);
        // 2.delete the off time agent id
        delOffTimeAgent(recommendRes);
        return recommendRes;
    }

    private List<Long> fetchOffLineRecomm(Long agentId) {
        // ArrayList<Long> result = new ArrayList<>();
        RecAgentLook recAgentLook = recAgentLookService.findByTaskId(agentId);
        ArrayList<Long> recAgentIds = RecAgentLookUtils.parseTasks(recAgentLook);
        logger.info("Agent id =[" + agentId + "], get offline RecAgent result size =" + recAgentIds.size());
        delOffTimeAgent(recAgentIds);
        logger.info("After filter the off time agent , the rest of recommend size = [" + recAgentIds.size() + "] for Agent id = [" + agentId + "]");
        return recAgentIds;
    }

}

package com.qbao.recommend.business.distribution.cmp.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qbao.recommend.business.distribution.cmp.common.AbstractFenXiaoRecommend;
import com.qbao.recommend.business.distribution.cmp.service.IFenXiaoGuessBiz;
import com.qbao.recommend.business.distribution.cmp.util.ConstantUtils;
import com.qbao.recommend.business.distribution.cmp.util.FenXiaoUtils;
import com.qbao.recommend.business.distribution.cmp.util.RecAgentGuessUtils;
import com.qbao.recommend.respositoy.mysql.model.RecAgentGuess;
import com.qbao.recommend.respositoy.mysql.service.IRecAgentGuessService;

/**
 * @author yuandongrui
 * @date 2016年7月11日
 */
@Component
public class FenXiaoGuessBizImpl extends AbstractFenXiaoRecommend implements IFenXiaoGuessBiz{
   
    private Logger logger = Logger.getLogger(this.getClass().getName());
    @Autowired
    IRecAgentGuessService recAgentGuessService;

    private List<Long> fetchOffLineRecomm(Long userId) {
        RecAgentGuess recommend = null;
        try {
            recommend = recAgentGuessService.findByUserId(userId);
            logger.info("The RecAgentGuess value : " + recommend);
        } catch (Exception e) {
            logger.error("fetch agent recommend result : ", e);
        }
        List<Long> taskIds = RecAgentGuessUtils.parseTasks(recommend);
        logger.info("fetch agent recommend result for user id = [" + userId + "]");
        logger.info("Total recommend result size = [" + taskIds.size() + "] for user id = [" + userId + "]");
        return taskIds;
    }
    @Override
    public List<Long> fetchRecommendRes(Long userId, int returnSize) {
        //1.fetch offline result
        List<Long> recommendRes = fetchOffLineRecomm(userId);
        //2.delete the off time agent id
        delOffTimeAgent(recommendRes);
        logger.info("After filter the off time agent , the rest of recommend size = [" + recommendRes.size()+"] for user id = [" + userId + "]");
        //return the expected size item 
       if (recommendRes.size() >= returnSize) {
           recommendRes = FenXiaoUtils.subList(recommendRes, 0, returnSize);
        }else {
            logger.info("The recommend result size=["+recommendRes.size()+"], less then expect size =["+ returnSize +"], and using the default result as additional result ");
            FenXiaoUtils.appendElements(recommendRes,fetchDefaultRecommendRes(), returnSize - recommendRes.size());
        }
       return recommendRes;
    }
    
   
    @Override 
    public List<Long> fetchRecommendRes(Long userId) {
       return fetchRecommendRes(userId,ConstantUtils.DEFAULT_RETURN_SIZE_GUESS);
    }
    
    @Override
    public List<Long> fetchDefaultRecommendRes() {
        //1.fetch offline result
        List<Long> recommendRes = fetchOffLineRecomm(-1L);
        //2.delete the off time agent id
        delOffTimeAgent(recommendRes);
        return recommendRes;
    }

}

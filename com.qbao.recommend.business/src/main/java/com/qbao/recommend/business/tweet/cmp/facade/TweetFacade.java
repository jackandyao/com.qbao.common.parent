/**
 * 
 */
package com.qbao.recommend.business.tweet.cmp.facade;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.qbao.recommend.business.tweet.cache.TweetCacheService;
import com.qbao.recommend.business.tweet.cmp.emergency.EmergencyData;
import com.qbao.recommend.business.tweet.cmp.handler.factory.TweetHandlerFactory;
import com.qbao.recommend.business.tweet.cmp.service.factory.TweetRecommendFactory;
import com.qbao.recommend.business.tweet.cmp.strategy.TweetStrategyFacotry;
import com.qbao.recommend.business.tweet.cmp.util.NotifierUtil;
import com.qbao.recommend.business.tweet.cmp.util.ParametersUtil;
import com.qbao.recommend.business.tweet.cmp.util.TweetConstantUtil;
import com.qbao.recommend.business.tweet.model.TweetDTO;
import com.qbao.recommend.respositoy.mysql.model.TweetInfo;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2017-01-19 21:29:15 +0800 (Thu, 19 Jan 2017) $
 * $LastChangedRevision: 1553 $
 * $LastChangedBy: wangping $
 */
@Component
public class TweetFacade {
    private Logger tweetInfoLogger = LoggerManagerUtil.getLogger(LogNameEnum.tweet, Level.INFO);
    private Logger tweetErrorLogger = LoggerManagerUtil.getLogger(LogNameEnum.tweet, Level.ERROR);

    @Autowired
    private TweetHandlerFactory tweetHandlerFactory;

    @Autowired
    private TweetStrategyFacotry tweetStrategyFacotry;

    @Autowired
    private TweetRecommendFactory tweetRecomendFacotry;

    @Autowired
    private TweetCacheService tweetCacheService;

    public List<TweetDTO> recommend(JSONObject context, Map<String, Object> requestParameters) {
        List<TweetDTO> result = Lists.newArrayList();
        Long userId = (Long) ParametersUtil.getParameter(requestParameters, TweetConstantUtil.USER_ID, 0L);
        int totalSize = (Integer) ParametersUtil.getParameter(requestParameters, TweetConstantUtil.TOTAL_SIZE, 3);
        int dlSize = (Integer) ParametersUtil.getParameter(requestParameters, TweetConstantUtil.DL_SIZE, 0); //

        if (totalSize < dlSize) {
            String msg = "user id =[" + userId + "], the request parameters are error totalsize = [" + totalSize + "] less then dlSize = [" + dlSize + "]" + DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
            tweetErrorLogger.error(msg);
            NotifierUtil.notifyByEmail(requestParameters, msg);
            return result;
        }
        tweetInfoLogger.info("user id [" + userId + "] request [" + dlSize + "] size tweets from ding ling and the rest of [" + (totalSize - dlSize) + "] size tweets from teng rong");
        List<TweetInfo> tweetInfos = Lists.newArrayList();
        tweetRecomendFacotry.execute(context, requestParameters, tweetInfos);

        String handlerCmds = context.getString(TweetConstantUtil.HANDLER_CMDS);
        if(StringUtils.isNotBlank(handlerCmds)) {
            tweetHandlerFactory.execute(handlerCmds, requestParameters, tweetInfos);
        }

        if (tweetInfos.size() < totalSize && StringUtils.isNotBlank(context.getString(TweetConstantUtil.STRATEGY_CMDS))) {
           // String strategyCmds = context.getString(TweetConstantUtil.STRATEGY_CMDS);
            String msg =  "user id =[" + userId + "] and the tweet recommend result size ["+tweetInfos.size()+"] less then expected size ["+totalSize+"], then execute strategy ... "+DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
            tweetInfoLogger.info(msg);
            tweetStrategyFacotry.executeStrategy(context,requestParameters, tweetInfos, (totalSize - tweetInfos.size()));
            NotifierUtil.notifyByEmail(requestParameters, msg);
            NotifierUtil.notifyByPhone("藤榕推文数据不够,通过定陵数据补全.用户ID:" + userId);
        }

        // Emergency Strategy
        if (CollectionUtils.isEmpty(tweetInfos) ) {
            String msg = "user id [" + userId + "] Tweet recomend result is empty,use emergency data!  " + DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
            NotifierUtil.notifyByEmail(requestParameters, msg);
            NotifierUtil.notifyByPhone("推文使用紧急数据. 用户ID:" + userId);
            tweetErrorLogger.error(msg);
            if (StringUtils.trimToEmpty((String)ParametersUtil.getParameter(requestParameters, TweetConstantUtil.DEV_TYPE)).equalsIgnoreCase(TweetConstantUtil.PC)) {
                return EmergencyData.buildPcEmergencyData();
            } else {
                return EmergencyData.buildAppEmergencyData();
            }
        }
        
        // convert to DTO
        for (TweetInfo tweetInfo : tweetInfos) {
            result.add(toTweetDTO(tweetInfo));
        }
        //cache the recommend result
        tweetCacheService.cacheRecommendResult(userId,result);
        return result;
    }

    public TweetDTO toTweetDTO(TweetInfo tweetInfo) {
        TweetDTO dto = null;
        if (null != tweetInfo) {
            dto = new TweetDTO();
            dto.setUrl(tweetInfo.getUrl());
            dto.setTitle(tweetInfo.getTitle());
            dto.setId(tweetInfo.getId());
            dto.setSource(tweetInfo.getSource());
        }
        return dto;
    }
}

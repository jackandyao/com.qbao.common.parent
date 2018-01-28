/**
 *
 */
package com.qbao.recommend.business.tweet.cmp.service;

import com.google.common.collect.Lists;
import com.qbao.recommend.business.tweet.cmp.util.TweetConstantUtil;
import com.qbao.recommend.respositoy.mysql.model.RecommendTweetItems;
import com.qbao.recommend.respositoy.mysql.model.TweetInfo;
import com.qbao.recommend.respositoy.mysql.service.IRecTweetDLService;
import com.qbao.recommend.respositoy.mysql.service.IRecTweetTRService;
import com.qbao.recommend.respositoy.mysql.service.ITweetInfoService;
import com.qbao.recommend.respositoy.mysql.service.ITweetPoolServcie;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-10-01 11:44:07 +0800 (Sat, 01 Oct 2016) $
 * $LastChangedRevision: 1234 $
 * $LastChangedBy: wangping $
 */
@Service
public class TweetPoolService {

    private Logger tweetInfoLogger = LoggerManagerUtil.getLogger(LogNameEnum.tweet, Level.INFO);
    private Logger tweetErrorLogger = LoggerManagerUtil.getLogger(LogNameEnum.tweet, Level.ERROR);

    @Autowired
    @Qualifier("tweetInfoServiceImpl")
    private ITweetInfoService tweetInfoService;

    @Autowired
    @Qualifier("tweetPoolServcieImpl")
    private ITweetPoolServcie tweetPoolServcie;

    @Autowired
    @Qualifier("recTweetDLServiceImpl")
    private IRecTweetDLService recTweetDLService;

    @Autowired
    @Qualifier("recTweetTRServiceImpl")
    private IRecTweetTRService recTweetTRService;




    private List<Long> fetchDLRecommendResult(Long userId) {
        RecommendTweetItems recommend = recTweetDLService.findByUserId(userId);
        List<Long> tweetIds = parseRecommendTweetItems(recommend);
        tweetInfoLogger.info("user id [" + userId + "] get recommend tweet ids  from  ding ling  " + tweetIds);
        return tweetIds;
    }

    private List<Long> parseRecommendTweetItems(RecommendTweetItems recommend) {
        List<Long> tweetIds = Lists.newArrayList();
        if (null != recommend) {
            String tweets = recommend.getTweets();
            if (!StringUtils.isEmpty(tweets)) {// 3:0.0,2:0.0,1:0.0
                String[] pairs = StringUtils.split(tweets, ",");
                for (String str : pairs) {
                    if (StringUtils.isNotBlank(str)) {
                        String[] pair = StringUtils.split(str, ":");
                        tweetIds.add(NumberUtils.toLong(pair[0]));
                    }
                }
            }
        }
        return tweetIds;
    }

    public List<TweetInfo> dlRecommend(Long userId) {
        List<TweetInfo> result = Lists.newArrayList();
        List<Long> tweetIds = fetchDLRecommendResult(userId);
        for (Long tweetId : tweetIds) {
            TweetInfo tweetInfo = getTweetInfo(tweetId);
            if (null != tweetInfo) {
                result.add(tweetInfo);
            }
        }
        return result;
    }

    private TweetInfo getTweetInfo(long tweetId) {

        TweetInfo tweetInfo = tweetInfoService.getTweetInfoById(tweetId);
        if(null != tweetInfo){
            tweetInfo.setSource(TweetConstantUtil.SOURCE_DINGLING);
        }
        return tweetInfo;
    }

    private TweetInfo getTweetsPool(long id) {
        TweetInfo tweetInfo = tweetPoolServcie.getTweetInfoById(id);
        if(null != tweetInfo){
            tweetInfo.setSource(TweetConstantUtil.SOURCE_TENGRONG);
        }
        return tweetInfo;
    }

    public List<TweetInfo> recommend(Long userId, int dlSize, int totalSize) {
        List<TweetInfo> result = Lists.newArrayList();
        if (dlSize > 0) {
            List<Long> dlResult = fetchDLRecommendResult(userId);
            if (dlResult.size() < dlSize) {
                List<Long> defaultResult = fetchDLRecommendResult(0L);
                disorderList(defaultResult);
                for (Long id : defaultResult) {
                    if (!dlResult.contains(id) && dlResult.size() < dlSize) {
                        dlResult.add(id);
                    }
                }
            } else {
                disorderList(dlResult);
                dlResult = dlResult.subList(0, dlSize);
            }
            for (Long tweetId : dlResult) {
                TweetInfo tweetInfo = getTweetInfo(tweetId);
                if (null != tweetInfo) {
                    result.add(tweetInfo);
                    tweetInfoLogger.info("user id [" + userId + "] Tweet Info id  [" + tweetId+"] is on");
                }else {
                    tweetInfoLogger.info("user id [" + userId + "] Tweet Info id  [" + tweetId+"] is off");
                }
            }
        }

        int trSize = totalSize - dlSize;
        if (trSize > 0) {
            List<Long> trResult = fetchTrRecommendResult(userId);
            if (trResult.size() < trSize) {
                List<Long> defaultResult = fetchTrRecommendResult(0L);
              //  disorderList(defaultResult);
                for (Long id : defaultResult) {
                    if (!trResult.contains(id)) {
                        trResult.add(id);
                    }
                }
            } else {
               // disorderList(trResult);

                //trResult = trResult.subList(0, trSize);
            }
            disorderList(trResult);
            List<TweetInfo> trTweetInfos = Lists.newArrayList();
            for (Long tweetId : trResult) {
                TweetInfo tweetInfo = getTweetsPool(tweetId);
                if (null != tweetInfo) {
                    trTweetInfos.add(tweetInfo);
                }
            }
            for(int i=0,j=0; i<trTweetInfos.size() && j < trSize; i++,j++){
                result.add(trTweetInfos.get(i));
            }


        }
        return result;
    }

    private List<Long> fetchTrRecommendResult(Long userId) {
        RecommendTweetItems recommend = recTweetTRService.findByUserId(userId);
        tweetInfoLogger.info("user id [" + userId + "] get teng rong recommendTweetItems : " + recommend);
        List<Long> tweetIds  =  parseRecommendTweetItems(recommend);
        tweetInfoLogger.info("user id [" + userId + "] get recommend tweet ids  from  teng rong " + tweetIds);
        return tweetIds;
    }

    private  void disorderList(List<Long> list){
        int sed = list.size() - 1;
        if(sed < 1){
            return;
        }
        for(int i =0; i< list.size(); i++) {
            int j = RandomUtils.nextInt(sed);
            if (j > -1 && j < list.size()) {// swap list[i] list[j]
                Long a = list.get(i);
                list.set(i, list.get(j));
                list.set(j, a);
            }
        }
    }

}

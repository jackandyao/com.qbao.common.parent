package com.qbao.recommend.business.tweet.cmp.service.impl;

import com.google.common.collect.Lists;
import com.qbao.recommend.business.tweet.cache.TweetCacheService;
import com.qbao.recommend.business.tweet.cmp.service.TweetRecommend;
import com.qbao.recommend.business.tweet.cmp.util.RecommendUtils;
import com.qbao.recommend.business.tweet.cmp.util.TweetConstantUtil;
import com.qbao.recommend.business.tweet.model.RecommendResult;
import com.qbao.recommend.respositoy.mysql.model.RecommendTweetItems;
import com.qbao.recommend.respositoy.mysql.model.TweetInfo;
import com.qbao.recommend.respositoy.mysql.service.IRecTweetDLService;
import com.qbao.recommend.respositoy.mysql.service.ITweetInfoService;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2017-01-13 15:35:09 +0800 (Fri, 13 Jan 2017) $
 * $LastChangedRevision: 1545 $
 * $LastChangedBy: wangping $
 *
 * DL is forshort ding ling
 * this class for dingling tweet recommend
 */

@Component(value = TweetConstantUtil.TWEET_DL_RECOMMEND)
public class TweetDlRecommend implements TweetRecommend {

    private Logger tweetInfoLogger = LoggerManagerUtil.getLogger(LogNameEnum.tweet, Level.INFO);

    @Autowired
    @Qualifier("tweetInfoServiceImpl")
    private ITweetInfoService tweetInfoService;

    @Autowired
    @Qualifier("recTweetDLServiceImpl")
    private IRecTweetDLService recTweetDLService;

    @Autowired
    private TweetCacheService tweetCacheService;

    @Override
    public void execute(Long userId, List<TweetInfo> tweetInfos, int appendLimit) {
        if (appendLimit > 0) {
           // RecommendResult recommenedResult = tweetCacheService.fetchRecommendResult(userId);//最近推荐的结果
            RecommendResult recommenedResult = null;
            List<TweetInfo> result = fetchValidRecommendDetail(userId, recommenedResult);
            if (result.size() < appendLimit) { // the result size less then appendLimit
                List<TweetInfo> defaultResult = fetchValidRecommendDetail(0L, recommenedResult);
                for (int i = 0, j = 0; i < defaultResult.size() && j < appendLimit; i++) {// merge the result and dedup the result
                    if (!result.contains(defaultResult.get(i))) {
                        result.add(defaultResult.get(i));
                        j++;
                    }
                }
            }
            List<TweetInfo> finalResults = result.size() <= appendLimit ? result : result.subList(0, appendLimit);
            tweetInfos.addAll(finalResults);
        }
    }

    @Override
    public void execute(Long userId, List<TweetInfo> tweetInfos) {
       // RecommendResult recommenedResult = tweetCacheService.fetchRecommendResult(userId);//最近推荐的结果
        RecommendResult recommenedResult = null;
        List<TweetInfo> result = fetchValidRecommendDetail(userId, recommenedResult);
        List<TweetInfo> defaultResult = fetchValidRecommendDetail(0L, recommenedResult);
        for (int i = 0; i < defaultResult.size(); i++) {// merge the result and dedup the result
            if (!result.contains(defaultResult.get(i))) {
                result.add(defaultResult.get(i));
            }
        }
        tweetInfos.addAll(result);
    }

    private void addToResult(List<Long> result, List<TweetInfo> tweetInfos) {
        for (Long id : result) {
            TweetInfo tweetInfo = getTweetsInfo(id);
            if (null != tweetInfo) {
                tweetInfos.add(tweetInfo);
            }
        }
    }

    private TweetInfo getTweetsInfo(long id) {
        TweetInfo tweetInfo = tweetInfoService.getTweetInfoById(id);
        if (null != tweetInfo) {
            tweetInfo.setSource(TweetConstantUtil.SOURCE_DINGLING);
        }
        return tweetInfo;
    }

    private List<Long> fetchRecommendResult(Long userId) {
        RecommendTweetItems recommend = recTweetDLService.findByUserId(userId);
        List<Long> tweetIds = RecommendUtils.parseRecommendTweetItems(recommend);
        tweetInfoLogger.info("user id [" + userId + "] get recommend tweet ids  from  ding ling  " + tweetIds);
        return tweetIds;
    }

    /**
     *
     * @param userId
     * @return remove the off tweets
     */
    private List<TweetInfo> fetchValidRecommendDetail(long userId, RecommendResult recommendResult) {
        List<TweetInfo> tweetInfos = Lists.newArrayList();
        List<Long> ids = fetchRecommendResult(userId);
        logInfo.info("user id =[" + userId + "], 推荐定菱推文 ID : " + ids);

        if (null != recommendResult) {//昨天已经推过推文
            ids = RecommendUtils.sort(ids, recommendResult.fetchTweetIdBySource(TweetConstantUtil.SOURCE_DINGLING));
            logInfo.info("user id =[" + userId + "], 推荐定菱推文ID 排序后 : " + ids);
        }

        RecommendUtils.disorderList(ids);

        for (Long id : ids) {
            TweetInfo tweetInfo = getTweetsInfo(id);
            if (null != tweetInfo) {
                tweetInfos.add(tweetInfo);
            } else {
                logInfo.info("user id =[" + userId + "], 推荐定菱推文ID=[" + id + "] 已经下架");
            }
        }
        return tweetInfos;
    }

    //  @Override
    public boolean recommend(RecommendResult recommendResult, long tweetId) {
        // 保证推荐结果和昨天不一样
        if (null != recommendResult && !DateUtils.isSameDay(recommendResult.getRecommendDate(), new Date())) {
            return !recommendResult.fetchTweetIdBySource(TweetConstantUtil.SOURCE_DINGLING).contains(tweetId);
        }
        return true;
    }
}

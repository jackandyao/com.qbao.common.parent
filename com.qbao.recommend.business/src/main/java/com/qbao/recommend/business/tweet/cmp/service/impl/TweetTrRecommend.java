package com.qbao.recommend.business.tweet.cmp.service.impl;

import com.google.common.collect.Lists;
import com.qbao.recommend.business.tweet.cache.TweetCacheService;
import com.qbao.recommend.business.tweet.cmp.common.WhiteListService;
import com.qbao.recommend.business.tweet.cmp.service.TweetRecommend;
import com.qbao.recommend.business.tweet.cmp.util.RecommendUtils;
import com.qbao.recommend.business.tweet.cmp.util.TweetConstantUtil;
import com.qbao.recommend.business.tweet.model.RecommendResult;
import com.qbao.recommend.respositoy.mysql.model.RecommendTweetItems;
import com.qbao.recommend.respositoy.mysql.model.TweetInfo;
import com.qbao.recommend.respositoy.mysql.service.IRecTweetTRService;
import com.qbao.recommend.respositoy.mysql.service.ITweetPoolServcie;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2017-01-20 11:01:12 +0800 (Fri, 20 Jan 2017) $
 * $LastChangedRevision: 1554 $
 * $LastChangedBy: wangping $
 *
 * TR is fors hort Teng Rong
 * this class for teng rong tweet recommend
 */

@Component(value = TweetConstantUtil.TWEET_TR_RECOMMEND)
public class TweetTrRecommend implements TweetRecommend {

    private Logger tweetInfoLogger = LoggerManagerUtil.getLogger(LogNameEnum.tweet, Level.INFO);
    @Autowired
    @Qualifier("tweetPoolServcieImpl")
    private ITweetPoolServcie tweetPoolServcie;

    @Autowired
    @Qualifier("recTweetTRServiceImpl")
    private IRecTweetTRService recTweetTRService;

    @Autowired
    private TweetCacheService tweetCacheService;

    @Autowired
    private WhiteListService whiteListService;

    @Override
    public void execute(Long userId, List<TweetInfo> tweetInfos, int appendLimit) {
        if (appendLimit > 0) {
            //   RecommendResult recommenedResult = tweetCacheService.fetchRecommendResult(userId);//最近推荐的结果
            RecommendResult recommenedResult = null;
            List<TweetInfo> result = fetchValidRecommendDetail(userId, recommenedResult);
            if (result.size() < appendLimit) { // the result size less then appendLimit
                int restSize = appendLimit-result.size();
                List<TweetInfo> defaultResult = fetchValidRecommendDetail(0L, recommenedResult);
                for (int i = 0; i < defaultResult.size() && restSize >0 ; i++) {// merge the result and dedup the result
                    if (!result.contains(defaultResult.get(i))) {
                        result.add(defaultResult.get(i));
                        restSize--;
                    }
                }
            }

            //user_id = 0 补全后都够不够, 可能有漏网之鱼的推文,即使推文推荐结果不对也要补全
            if (result.size() < appendLimit){
                int restSize = appendLimit-result.size();
                Date today = new Date();
               List<TweetInfo> allTweetInfos = tweetPoolServcie.getAllValidTwettInfos();
                for (int i = 0; i < allTweetInfos.size() && restSize>0; i++) {// merge the result and dedup the result
                    TweetInfo tweetInfo = allTweetInfos.get(i);
                    tweetInfo.setSource(TweetConstantUtil.SOURCE_TENGRONG);
                    Date createTime = tweetInfo.getCreateTime();
                    if (!result.contains(tweetInfo)  && !DateUtils.isSameDay(createTime,today)) { //当天新上的推文,推荐算法还没有解析该推文
                        result.add(tweetInfo);
                        logInfo.info("user id = ["+userId+"],  通过默认推文补充都不够返回结果. 通过非个性化的推文补充: "+ tweetInfo);
                        restSize--;
                    }
                }
            }

            List<TweetInfo> finalResults = result.size() <= appendLimit ? result : result.subList(0, appendLimit);
            tweetInfos.addAll(finalResults);
        }
    }

    @Override
    public void execute(Long userId, List<TweetInfo> tweetInfos) {
        //  RecommendResult recommenedResult = tweetCacheService.fetchRecommendResult(userId);//最近推荐的结果
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

    private TweetInfo getTweetsPool(long id) {
        TweetInfo tweetInfo = tweetPoolServcie.getTweetInfoById(id);
        if (null != tweetInfo) {
            tweetInfo.setSource(TweetConstantUtil.SOURCE_TENGRONG);
        }
        return tweetInfo;
    }

    private List<Long> fetchRecommendResult(Long userId) {
        RecommendTweetItems recommend = recTweetTRService.findByUserId(userId);
        tweetInfoLogger.info("user id [" + userId + "] get teng rong recommendTweetItems : " + recommend);
        List<Long> tweetIds = RecommendUtils.parseRecommendTweetItems(recommend);
        tweetInfoLogger.info("user id [" + userId + "] get recommend tweet ids  from  teng rong " + tweetIds);
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
        logInfo.info("user id =[" + userId + "], 推荐藤榕推文 ID : " + ids);

        if (null != recommendResult) {//昨天已经推过推文 排序到最后
            ids = RecommendUtils.sort(ids, recommendResult.fetchTweetIdBySource(TweetConstantUtil.SOURCE_TENGRONG));
            logInfo.info("user id =[" + userId + "], 推荐藤榕推文 排序后 : " + ids);
        }

        for (Long id : ids) {
            TweetInfo tweetInfo = getTweetsPool(id);
            if (null != tweetInfo) {
                tweetInfos.add(tweetInfo);
            } else {
                logInfo.info("user id =[" + userId + "], 藤榕推文ID=[" + id + "] 已经下架");
            }
        }
        //随机打算user_id = 0的 推荐顺序
        if (0 == userId) {
            RecommendUtils.disorderList(tweetInfos);
        } else {
            Collections.sort(tweetInfos);//TODO 推文优先级排序
            //白名单优先
            Set<Long> whiteListTweetIds = whiteListService.getWhiteList(userId);
            if (CollectionUtils.isNotEmpty(whiteListTweetIds)) {
                logInfo.info("user id =[" + userId + "], 藤榕推文白名单 : " + whiteListTweetIds);
                Iterator<Long> it = whiteListTweetIds.iterator();
                while (it.hasNext()) {
                    Long tweetId = it.next();
                    TweetInfo tweetInfo = getTweetsPool(tweetId);
                    if (ids.contains(tweetId) && null != tweetInfo) {
                        ids.remove(tweetId);
                        tweetInfos.remove(tweetInfo);
                    }
                    if (null != tweetInfo) {
                        tweetInfos.add(0, tweetInfo);
                    }
                }
                logInfo.info("user id =[" + userId + "], 加入白名单后推荐藤榕推文排序后 : " + tweetInfos);
            }
        }
        return tweetInfos;
    }

    public boolean recommend(RecommendResult recommendResult, long tweetId) {
        // 保证推荐结果和上次不一样
        if (null != recommendResult && !DateUtils.isSameDay(recommendResult.getRecommendDate(), new Date())) {
            return !recommendResult.fetchTweetIdBySource(TweetConstantUtil.SOURCE_TENGRONG).contains(tweetId);
        }
        return true;
    }
}

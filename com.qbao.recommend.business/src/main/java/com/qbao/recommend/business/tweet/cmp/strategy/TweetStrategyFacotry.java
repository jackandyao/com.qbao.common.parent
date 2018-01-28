/**
 * 
 */
package com.qbao.recommend.business.tweet.cmp.strategy;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qbao.recommend.business.tweet.cmp.strategy.chain.TweetStrategyChain;
import com.qbao.recommend.respositoy.mysql.model.TweetInfo;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-28 17:47:46 +0800 (Wed, 28 Sep 2016) $
 * $LastChangedRevision: 1203 $
 * $LastChangedBy: wangping $
 */
@Component
public class TweetStrategyFacotry {
    @Autowired
    TweetStrategyChain tweetStrategyContext;

    /**
     *
     * @param context  meta JSON
     * @param requestParameters parameters from url
     * @param tweetInfos
     * @param expectedNum
     */
    public void executeStrategy(JSONObject context, Map<String, Object> requestParameters,List<TweetInfo> tweetInfos, int expectedNum) {
        tweetStrategyContext.execute(context, requestParameters,tweetInfos, expectedNum);
    }
}

package com.qbao.recommend.business.tweet.cmp.service.factory;

import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.tweet.cmp.service.chain.TweetRecommendChain;
import com.qbao.recommend.respositoy.mysql.model.TweetInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-10-01 17:15:35 +0800 (Sat, 01 Oct 2016) $
 * $LastChangedRevision: 1237 $
 * $LastChangedBy: wangping $
 */

@Component
public class TweetRecommendFactory {
    @Autowired
    TweetRecommendChain tweetRecommendChain;

    /**
     *
     * @param context  metadata data from mysql
     * @param requestParameters from the request url
     * @param tweetInfos return result list
      */
    public void execute(JSONObject context, Map<String, Object> requestParameters, List<TweetInfo> tweetInfos) {
        tweetRecommendChain.execute(context,requestParameters, tweetInfos);
    }
}

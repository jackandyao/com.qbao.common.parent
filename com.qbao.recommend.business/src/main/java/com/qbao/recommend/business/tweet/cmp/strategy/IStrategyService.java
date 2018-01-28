/**
 * 
 */
package com.qbao.recommend.business.tweet.cmp.strategy;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.respositoy.mysql.model.TweetInfo;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-28 17:47:46 +0800 (Wed, 28 Sep 2016) $
 * $LastChangedRevision: 1203 $
 * $LastChangedBy: wangping $
 */
public interface IStrategyService {

    public void execute(JSONObject context, Map<String, Object> requestParameters, List<TweetInfo> tweetInfos, int expectedNum);
}

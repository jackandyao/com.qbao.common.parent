/**
 * 
 */
package com.qbao.recommend.business.tweet.rest;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-11-10 14:50:12 +0800 (Thu, 10 Nov 2016) $
 * $LastChangedRevision: 1378 $
 * $LastChangedBy: wangping $
 */
public interface ITweetService {

    Map<String, Object> recommend(long userId, String devType, int total, int limit);

    Map<String, Object> notify(long tweetId,int state, String title,String env);

    JSONObject setup();

}

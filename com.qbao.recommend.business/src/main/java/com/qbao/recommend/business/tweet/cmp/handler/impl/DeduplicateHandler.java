/**
 * 
 */
package com.qbao.recommend.business.tweet.cmp.handler.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.qbao.recommend.business.tweet.cmp.handler.TweetHandler;
import com.qbao.recommend.business.tweet.cmp.util.TweetConstantUtil;
import com.qbao.recommend.respositoy.mysql.model.TweetInfo;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-28 10:57:28 +0800 (Wed, 28 Sep 2016) $
 * $LastChangedRevision: 1194 $
 * $LastChangedBy: wangping $
 */
@Component(value = TweetConstantUtil.DEUPLICATE_HANDLER)
public class DeduplicateHandler implements TweetHandler {

    @Override
    public void execute(List<TweetInfo> tweetInfos) {
        HashSet<TweetInfo> unique = new HashSet<>(tweetInfos);
        tweetInfos.clear();
        tweetInfos.addAll(unique);
    }

    @Override
    public void setup(Map<String, Object> context) {

    }

}

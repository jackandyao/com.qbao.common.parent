/**
 * 
 */
package com.qbao.recommend.business.tweet.cmp.handler.impl;

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
@Component(value = TweetConstantUtil.STATUS_HANDLER)
public class StatusHandler implements TweetHandler {

    @Override
    public void execute(List<TweetInfo> tweetsInfo) {

    }

    @Override
    public void setup(Map<String, Object> context) {

    }

}

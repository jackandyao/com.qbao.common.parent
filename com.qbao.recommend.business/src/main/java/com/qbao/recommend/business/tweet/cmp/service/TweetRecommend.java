package com.qbao.recommend.business.tweet.cmp.service;

import com.qbao.recommend.respositoy.mysql.model.TweetInfo;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2017-01-12 15:31:24 +0800 (Thu, 12 Jan 2017) $
 * $LastChangedRevision: 1542 $
 * $LastChangedBy: wangping $
 */

public interface TweetRecommend {

    Logger logInfo = LoggerManagerUtil.getLogger(LogNameEnum.tweet, Level.INFO);

    /**
     * add the size of recommend result to tweetInfo list
     * @param userId
     * @param tweetInfos the recommend result list
     * @param size  the size of recommend result to be added to tweetInfos for userId
     */
    public void execute(Long userId, List<TweetInfo> tweetInfos , int size);

    /**
     * add all of recommend result to tweetInfos
     *
     * @param userId
     * @param tweetInfos the recommend result list
     */
    public void execute(Long userId, List<TweetInfo> tweetInfos);


}

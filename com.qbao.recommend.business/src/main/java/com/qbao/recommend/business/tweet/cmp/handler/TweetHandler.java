/**
 * 
 */
package com.qbao.recommend.business.tweet.cmp.handler;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.qbao.recommend.respositoy.mysql.model.TweetInfo;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-28 01:38:22 +0800 (Wed, 28 Sep 2016) $
 * $LastChangedRevision: 1187 $
 * $LastChangedBy: wangping $
 */
public interface TweetHandler {
    Logger handleLogger = LoggerManagerUtil.getLogger(LogNameEnum.tweet, Level.INFO);

    public void execute(List<TweetInfo> tweetInfos);

    public void setup(Map<String, Object> context);
}

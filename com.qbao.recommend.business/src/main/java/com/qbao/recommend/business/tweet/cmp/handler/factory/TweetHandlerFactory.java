/**
 * 
 */
package com.qbao.recommend.business.tweet.cmp.handler.factory;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qbao.recommend.business.tweet.cmp.handler.chain.TweetHandlerChain;
import com.qbao.recommend.respositoy.mysql.model.TweetInfo;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-27 19:29:01 +0800 (Tue, 27 Sep 2016) $
 * $LastChangedRevision: 1180 $
 * $LastChangedBy: wangping $
 */
@Component
public class TweetHandlerFactory {
    @Autowired
    TweetHandlerChain tweetHandlerChain;

    public void execute(String cmds, Map<String, Object> context, List<TweetInfo> tweetInfos) {
        tweetHandlerChain.execute(cmds, context, tweetInfos);
    }

}

/**
 * 
 */
package com.qbao.recommend.business.tweet.cmp.handler.chain;
import com.qbao.recommend.business.tweet.cmp.handler.TweetHandler;
import com.qbao.recommend.business.tweet.spring.SpringApplicationManager;
import com.qbao.recommend.respositoy.mysql.model.TweetInfo;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
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
public class TweetHandlerChain {

    Logger tweetInfo = LoggerManagerUtil.getLogger(LogNameEnum.tweet, Level.INFO);

    @Resource(name = "springApplicationManager")
    private SpringApplicationManager springApplicationManager;

    /**
     *
     * @param cmds  the handler names from metadata
     * @param requestParameters the request parameters from url
     * @param tweetInfos  the List of TweetInfos are  processed by handler
     */
    public void execute(String cmds, Map<String, Object> requestParameters, List<TweetInfo> tweetInfos) {
        if (cmds != null) {
            for (String cmd : cmds.split(",")) {
                tweetInfo.info("executing " + StringUtils.trimToEmpty(cmd) + " handler  ...");
                TweetHandler handler =   springApplicationManager.getApplicationContext().getBean(StringUtils.trimToEmpty(cmd), TweetHandler.class);
                handler.setup(requestParameters);
                handler.execute(tweetInfos);
            }
        }

    }

}

/**
 * 
 */
package com.qbao.recommend.business.tweet.cmp.strategy.chain;

import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.tweet.cmp.strategy.IStrategyService;
import com.qbao.recommend.business.tweet.cmp.util.TweetConstantUtil;
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
public class TweetStrategyChain {

    Logger tweetInfo = LoggerManagerUtil.getLogger(LogNameEnum.tweet, Level.INFO);

    @Resource(name = "springApplicationManager")
    private SpringApplicationManager springApplicationManager;

    /**
     * @param context  the metadata json from mysql
     * @param requestParameters the request parameters from url
     * @param tweetInfos  the recommend result list
     * @param expectedNum  the number of complement
     */
    public void execute(JSONObject context, Map<String, Object> requestParameters, List<TweetInfo> tweetInfos, int expectedNum) {
        String cmds = context.getString(TweetConstantUtil.STRATEGY_CMDS);
        if (null != cmds) {
            for (String cmd : cmds.split(",")) {
                tweetInfo.info("executing " + StringUtils.trimToEmpty(cmd) + " strategy to complement [" + expectedNum + "] items  ...");
                IStrategyService strategyService =   springApplicationManager.getApplicationContext().getBean(StringUtils.trimToEmpty(cmd), IStrategyService.class);
                strategyService.execute(context,requestParameters,tweetInfos, expectedNum);
            }
        }
    }

}

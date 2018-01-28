/**
 * 
 */
package com.qbao.recommend.business.tweet.cmp.strategy.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.qbao.recommend.business.tweet.cmp.handler.factory.TweetHandlerFactory;
import com.qbao.recommend.business.tweet.cmp.service.impl.TweetDlRecommend;
import com.qbao.recommend.business.tweet.cmp.strategy.IStrategyService;
import com.qbao.recommend.business.tweet.cmp.util.TweetConstantUtil;
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
@Component(value = TweetConstantUtil.COMPLEMENTED_STRATEGY)
public class ComplementedStrategy implements IStrategyService {

    @Autowired
    private TweetDlRecommend tweetDlRecommend;

    @Autowired
    private TweetHandlerFactory tweetHandlerFactory;

    @Override
    public void execute(JSONObject context, Map<String, Object> requestParameters, List<TweetInfo> tweetInfos, int expectedNum) {
        List<TweetInfo> defaultTweeInfos = Lists.newArrayList();
         tweetDlRecommend.execute(0L,defaultTweeInfos);

        int count = 0;
        List<TweetInfo> appendList = Lists.newArrayList();
        for (TweetInfo tweetInfo : defaultTweeInfos) {
            if (count < expectedNum && !tweetInfos.contains(tweetInfo)  ) {
                appendList.add(tweetInfo);
                count++;
            }
        }
        String handlerCmds = context.getString(TweetConstantUtil.HANDLER_CMDS);
        tweetHandlerFactory.execute(handlerCmds, requestParameters, appendList);
        tweetInfos.addAll(appendList);

    }
}

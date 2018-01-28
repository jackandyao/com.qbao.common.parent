/**
 * 
 */
package com.qbao.recommend.business.tweet.cmp.handler.impl;

import com.google.common.base.Preconditions;
import com.qbao.recommend.business.tweet.cmp.handler.TweetHandler;
import com.qbao.recommend.business.tweet.cmp.util.ParametersUtil;
import com.qbao.recommend.business.tweet.cmp.util.TweetConstantUtil;
import com.qbao.recommend.respositoy.mysql.model.TweetInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-12-12 09:42:40 +0800 (Mon, 12 Dec 2016) $
 * $LastChangedRevision: 1521 $
 * $LastChangedBy: wangping $
 */
@Component(value = TweetConstantUtil.URL_HANDLER)
public class UrlHandler implements TweetHandler {
    private String devType;
    private String platform = "&devType=pc";
    private Map<String, Object> context;
    private long userId;

    // http://mp2.qbao.com/s/5ee7538c8b6d45cd9213fb0d7672e50b?sn=211cf2577bb54d93896fb30fc247a2c8&devType=pc

    // "http://sign.qbao.com/sign/tuiwen/detail/" + id + ".html"这是web的
    // "http://sign.qbao.com/sign4Client/tuiwen/detail/" + id + ".html"这是wap的

    @Override
    public void execute(List<TweetInfo> tweetInfos) {
        Preconditions.checkNotNull(context, " please invoke setupContext(Map<String, Object> context) method ");
        devType = StringUtils.trimToEmpty((String) ParametersUtil.getParameter(context, TweetConstantUtil.DEV_TYPE));
        userId = (Long) ParametersUtil.getParameter(context, TweetConstantUtil.USER_ID);
        handleLogger.info("devType : " + devType);
        for (TweetInfo tweetInfo : tweetInfos) {
            if (null != tweetInfo) {
                String url = StringUtils.trimToEmpty(tweetInfo.getUrl());
                handleLogger.debug("handle : " + tweetInfo);
                if (StringUtils.equalsIgnoreCase(tweetInfo.getSource(), TweetConstantUtil.SOURCE_DINGLING)) {
                    if (StringUtils.equalsIgnoreCase(devType, TweetConstantUtil.PC)) {
                        if (!StringUtils.containsIgnoreCase(url, platform)) {
                            url = url + platform+"&userId="+userId;
                        }
                    } else {
                        url = StringUtils.remove(url, platform)+"&userId="+userId;
                    }
                    tweetInfo.setUrl(url);
                } else if (StringUtils.equalsIgnoreCase(tweetInfo.getSource(), TweetConstantUtil.SOURCE_TENGRONG)) {
                    if (StringUtils.equalsIgnoreCase(devType, TweetConstantUtil.PC)) {
                        url = "https://sign.qbao.com/sign/tuiwen/detail/" + tweetInfo.getId() + ".html";
                    } else {
                        url = "https://sign.qbao.com/sign4Client/tuiwen/detail/" + tweetInfo.getId() + ".html";
                    }
                    tweetInfo.setUrl(url);
                }
            }
        }
    }

    @Override
    public void setup(Map<String, Object> context) {
        this.context = context;
    }
}

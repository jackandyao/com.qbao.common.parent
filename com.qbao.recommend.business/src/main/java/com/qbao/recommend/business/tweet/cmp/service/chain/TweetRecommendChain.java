package com.qbao.recommend.business.tweet.cmp.service.chain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.qbao.recommend.business.tweet.spring.SpringApplicationManager;
import com.qbao.recommend.business.tweet.cmp.service.TweetRecommend;
import com.qbao.recommend.business.tweet.cmp.util.ParametersUtil;
import com.qbao.recommend.business.tweet.cmp.util.TweetConstantUtil;
import com.qbao.recommend.respositoy.mysql.model.TweetInfo;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
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
public class TweetRecommendChain {
    Logger logger = LoggerManagerUtil.getLogger(LogNameEnum.tweet, Level.INFO);

    @Resource(name = "springApplicationManager")
    private SpringApplicationManager springApplicationManager;


    /**
     *
     * @param context  the metadata json from mysql
     * @param requestParameters the request parameters from url
     * @param tweetInfos  the List of TweetInfos are  processed by handler
     */
    public void execute(JSONObject context, Map<String, Object> requestParameters, List<TweetInfo> tweetInfos) {
        String recommends = context.getString(TweetConstantUtil.RECOMMEND_CMDS);
        Long userId = (Long) ParametersUtil.getParameter(requestParameters, TweetConstantUtil.USER_ID, 0L);

        if(StringUtils.isNotBlank(recommends)){
            JSONArray cmds = JSON.parseArray(recommends);
            for(int index =0; index< cmds.size(); index++){
                JSONObject cmdObj = cmds.getJSONObject(index);
                String cmdName =  cmdObj.getString(TweetConstantUtil.RECOMMEND_NAME);
               // String size =  cmdObj.getString(TweetConstantUtil.RECOMMEND_NUM);
                if(StringUtils.isNotBlank(cmdName)){
                    Integer size = getSpecialRecommendSize(requestParameters,cmdName,cmdObj.getString(TweetConstantUtil.RECOMMEND_NUM));
                    logger.info(" executing " + cmdName +" for userId ["+userId+"] ...");
                    TweetRecommend recommend =   springApplicationManager.getApplicationContext().getBean(cmdName, TweetRecommend.class);
                    Preconditions.checkNotNull(recommend ,  " can't get  " + cmdName);
                    if(null!= size){
                       recommend.execute(userId,tweetInfos, size);
                    }else {
                        recommend.execute(userId,tweetInfos);
                    }
                }
            }
        }
    }

    /**
     *
     * @param requestParameters
     * @param cmdName
     * @param defaultSize
     * @return the size number of the recommend result
     */
    private Integer getSpecialRecommendSize(Map<String, Object> requestParameters, String cmdName, String defaultSize){
        int totalSize = (Integer) ParametersUtil.getParameter(requestParameters, TweetConstantUtil.TOTAL_SIZE, 3);
        int dlSize = (Integer) ParametersUtil.getParameter(requestParameters, TweetConstantUtil.DL_SIZE, 0); //
        if(StringUtils.equalsIgnoreCase(cmdName,TweetConstantUtil.TWEET_DL_RECOMMEND)){
            return  Integer.valueOf(dlSize);
        }
        if(StringUtils.equalsIgnoreCase(cmdName,TweetConstantUtil.TWEET_TR_RECOMMEND)){
            return Integer.valueOf(totalSize - dlSize);
        }
        return NumberUtils.createInteger(defaultSize);
    }

    public static void main(String[] args){
        String json ="[{\"name\":\"rc_tweet_dl\",\"num\":100},{\"name\":\"rc_tweet_tr\",\"num\":100}]";

        if(StringUtils.isNotBlank(json)) {
            JSONArray cmds = JSON.parseArray(json);
           System.out.println(cmds.contains(TweetConstantUtil.TWEET_DL_RECOMMEND));
            for (int index = 0; index < cmds.size(); index++) {
                JSONObject cmdObj = cmds.getJSONObject(index);
                String cmdName =  cmdObj.getString(TweetConstantUtil.RECOMMEND_NAME);
                String cmdNum =  cmdObj.getString(TweetConstantUtil.RECOMMEND_NUM);
                  System.out.println(cmdName  +", " + cmdNum);
            }
        }
    }
}

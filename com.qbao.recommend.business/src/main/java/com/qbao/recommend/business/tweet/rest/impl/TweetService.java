/**
 * 
 */
package com.qbao.recommend.business.tweet.rest.impl;

import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.qbao.recommend.business.tweet.cmp.facade.TweetFacade;
import com.qbao.recommend.business.tweet.cmp.util.NotifierUtil;
import com.qbao.recommend.business.tweet.cmp.util.ParametersUtil;
import com.qbao.recommend.business.tweet.model.TweetDTO;
import com.qbao.recommend.respositoy.mysql.util.StateEnum;
import com.qbao.recommend.business.tweet.rest.ITweetService;
import com.qbao.recommend.respositoy.mysql.model.RecommendMetadata;
import com.qbao.recommend.respositoy.mysql.service.IRecommendMetadataService;
import com.qbao.recommend.respositoy.mysql.service.ITweetPoolServcie;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2017-01-18 23:55:31 +0800 (Wed, 18 Jan 2017) $
 * $LastChangedRevision: 1551 $
 * $LastChangedBy: wangping $
 */
@Path("recommend")
public class TweetService implements ITweetService {
    private Logger tweetInfoLogger = LoggerManagerUtil.getLogger(LogNameEnum.tweet, Level.INFO);
    private Logger tweetErrorLogger = LoggerManagerUtil.getLogger(LogNameEnum.tweet, Level.ERROR);

    @Autowired
    private TweetFacade tweetFacade;

    @Autowired
    IRecommendMetadataService recommendMetadataService;

    @Autowired
    ITweetPoolServcie  tweetPoolServcie;

    private static JSONObject context;

    /**
     *
     * @param userId
     * @param devType pc or app
     * @param total return total size
     * @param dlSize return ding ling size
     * @return
     */

    @GET
    @Path("/tweet/{userId}")
    @Produces(ContentType.APPLICATION_JSON_UTF_8)
    public Map<String, Object> recommend(@PathParam("userId") long userId, @DefaultValue("pc") @QueryParam("devType") String devType, @DefaultValue("3") @QueryParam("total") int total, @DefaultValue("3") @QueryParam("dlSize") int dlSize) {
        tweetInfoLogger.info("starting Tweet Recommend Service : user id =[" + userId + "], devType =[" + devType + "], total=[" + total + "], dlSize = [" + dlSize + "] ...");
        if (null == context) {
            context = setup();
        }
        Map<String, Object> requestParams = ParametersUtil.wrap(userId, this.getClass().getSimpleName(), devType, dlSize, total);
        Map<String, Object> response = new HashMap<String, Object>();
        List<TweetDTO> data = Lists.newArrayList();
        try {
            data = tweetFacade.recommend(context, requestParams);
            response.put("success", true);
            response.put("returnCode", 0);
            response.put("message", "Ok");
            response.put("data", data);
        }catch (RpcException  ex){
            //skip it timeout exception
        }
        catch (Exception e) {
            response.put("returnCode", "-1");
            response.put("success", false);
            String msg = ExceptionUtils.getFullStackTrace(e);
            response.put("message", msg);
            NotifierUtil.notifyByEmail(requestParams, e);
            NotifierUtil.notifyByPhone("推文接口异常: "+StringUtils.substringBefore(ExceptionUtils.getMessage(e),":"));
            tweetErrorLogger.error("推文推荐接口 用户账号:" + userId + ", 错误信息为:" + msg);
        }
        tweetInfoLogger.info("user id [" + userId + "]  Tweet recommendation is done ! and recomend [" + data.size() + "] items tweets");
        return response;
    }

    @GET
    @Path("/tweet/notify")
    @Produces(ContentType.APPLICATION_JSON_UTF_8)
    public Map<String, Object> notify(@QueryParam("tweetId")long tweetId, @DefaultValue("0") @QueryParam("state") int state,  @QueryParam("title")  String title, @DefaultValue("prod") @QueryParam("env")  String env) {
        tweetInfoLogger.info("新的推文id["+tweetId+"], and state =["+state+"] 处理...");

        Map<String, Object> response = new HashMap<String, Object>();
        String msg ="";
        try {
            StateEnum stateEnum = tweetPoolServcie.tweetNotify(tweetId,state);
            boolean isSuccess = stateEnum == StateEnum.提交成功 ? true : false;
            msg =  isSuccess ? "推文状态通知成功" : "推文状态通知失败 ";
            response.put("success", isSuccess);
            response.put("returnCode", 0);
            response.put("message", stateEnum);
            NotifierUtil.notifyByPhone(env+" : 有新的推文["+title+"],id["+tweetId+"] 入库,请尽快配置推文标签");
        }catch (RpcException  ex){
            //skip it timeout exception
        }
        catch (Exception e) {
            response.put("returnCode", "-1");
            response.put("success", false);
            msg = ExceptionUtils.getFullStackTrace(e);
            response.put("message", "推文状态通知失败 : "+ msg);
            NotifierUtil.notifyByEmail("新推文状态更新", msg);
            NotifierUtil.notifyByPhone("推文接口异常: "+StringUtils.substringBefore(ExceptionUtils.getMessage(e),":"));
            tweetErrorLogger.error("推文推荐接口 推文ID :" + tweetId + ", 错误信息为:" + msg);
        }
        return response;
    }

    @Override
    public JSONObject setup() {
        String serviceName = this.getClass().getSimpleName();
        RecommendMetadata metaData = recommendMetadataService.findByParamKey(serviceName);
        if (metaData == null || StringUtils.isEmpty(metaData.getParam_value())) {
            throw new RuntimeException("Key =[" + serviceName + "], RecommendMetadata must not be null or value not be empty！");
        }
        String json = metaData.getParam_value();
        tweetInfoLogger.info("setup [" + serviceName + " ], and context = [" + json + "]");
        return JSONObject.parseObject(json);
    }

}

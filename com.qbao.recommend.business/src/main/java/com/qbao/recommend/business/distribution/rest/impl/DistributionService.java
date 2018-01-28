package com.qbao.recommend.business.distribution.rest.impl;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.alarm.facade.AlaramServiceFacotryFacade;
import com.qbao.recommend.alarm.util.MessageConstanUtil;
import com.qbao.recommend.business.distribution.cmp.service.IFenXiaoRecommendBiz;
import com.qbao.recommend.business.distribution.rest.IDistributionService;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;

/**
 * 
 * @author sjzhangjun
 * 2016年10月12日
 */
@Path("fenxiao/fenXiaoRecommend")
public class DistributionService implements IDistributionService {
	
	private Logger distributionInfoLogger = LoggerManagerUtil.getLogger(LogNameEnum.distribution, Level.INFO);
	private Logger distributionWarnLogger = LoggerManagerUtil.getLogger(LogNameEnum.distribution, Level.WARN);
    private Logger distributionErrorLogger = LoggerManagerUtil.getLogger(LogNameEnum.distribution, Level.ERROR);
    
    @Autowired
    IFenXiaoRecommendBiz fenXiaoBiz;

    @GET
    @Path("guessLike")
    public Object guessLike(@QueryParam("userId") long userId) {
        distributionInfoLogger.warn("process userId =[" + userId + "]");
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Long> recommendIds = fenXiaoBiz.fetchRecommendGuessRes(userId);
            map.put("success", true);
            map.put("returnCode", 0);
            map.put("data", recommendIds);
            map.put("message", "Ok");
            
            //打印结果到日志
            distributionInfoLogger.info(userId+"\t"+StringUtils.join(recommendIds, ","));
		} catch (Exception e) {
			map.put("success", false);
			map.put("returnCode", -1);
			map.put("message", "分销猜你喜欢数据获取出现异常");
			map.put("data", Collections.EMPTY_LIST);
			distributionErrorLogger.error("分销推荐-猜您喜欢 ：" + e.getMessage());
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(MessageConstanUtil.ALARM_EXCEPTION, e);
            jsonObject.put(MessageConstanUtil.ALARM_TYPE, MessageConstanUtil.MAIL_ERROR);
            jsonObject.put(MessageConstanUtil.ALARM_USERID, userId);
			AlaramServiceFacotryFacade.sendAlaramMessageByMail(jsonObject);
			//sendInfo("调用分销推荐接口出现错误", "用户编号:"+userId+","+ExceptionUtils.getFullStackTrace(e));
		}
        return net.sf.json.JSONObject.fromObject(map).toString();
    }

    @GET
    @Path("lookAgain")
    public Object lookAgain(@QueryParam("userId") long userId,@QueryParam("taskId") long taskId) {
        distributionWarnLogger.warn("taskId:"+taskId+",userId:"+userId);
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Long> recommendIds = fenXiaoBiz.fetchRecommendLookRes(userId, taskId);
            map.put("success", true);
            map.put("returnCode", 0);
            map.put("data", recommendIds);
            map.put("message", "Ok");
            //打印结果到日志
            distributionInfoLogger.info(userId+"\t"+StringUtils.join(recommendIds, ","));
		} catch (Exception e) {
			map.put("success", false);
			map.put("returnCode", -1);
			map.put("message", "分销推荐看了又看数据获取出现异常");
			map.put("data", Collections.EMPTY_LIST);
			distributionErrorLogger.error("分销推荐看了又看数据获取出现异常：" + e.getMessage());
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(MessageConstanUtil.ALARM_EXCEPTION, e);
            jsonObject.put(MessageConstanUtil.ALARM_TYPE, MessageConstanUtil.MAIL_ERROR);
            jsonObject.put(MessageConstanUtil.ALARM_USERID, userId);
			AlaramServiceFacotryFacade.sendAlaramMessageByMail(jsonObject);
			//sendInfo("分销推荐看了又看数据获取出现异常", "用户编号:"+userId+","+ExceptionUtils.getFullStackTrace(e));
		}
        return net.sf.json.JSONObject.fromObject(map).toString();
    }
}

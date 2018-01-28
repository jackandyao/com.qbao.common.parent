package com.qbao.recommend.business.baoyue.rest.impl;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.qbao.recommend.business.baoyue.cmp.facade.BaoYueFacade;
import com.qbao.recommend.business.baoyue.cmp.util.ParametersUtil;
import com.qbao.recommend.business.baoyue.rest.IBaoYueRecommendService;
import com.qbao.recommend.business.baoyue.rest.dto.BaoYueDto;
import com.qbao.recommend.business.tweet.cmp.util.NotifierUtil;
import com.qbao.recommend.respositoy.mysql.model.RecommendMetadata;
import com.qbao.recommend.respositoy.mysql.service.IRecommendMetadataService;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangping
 * @createTime 上午10:33
 * $$LastChangedDate: 2016-11-25 15:23:56 +0800 (Fri, 25 Nov 2016) $$
 * $$LastChangedRevision: 1491 $$
 * $$LastChangedBy: wangping $$
 */
@Path("recommend")
public class BaoYueRecommendService implements IBaoYueRecommendService {

    private static JSONObject context;
    @Autowired
    IRecommendMetadataService recommendMetadataService;
    private Logger infoLogger = LoggerManagerUtil.getLogger(LogNameEnum.bao_yue, Level.INFO);
    private Logger errorLogger = LoggerManagerUtil.getLogger(LogNameEnum.bao_yue, Level.ERROR);
    @Autowired
    private BaoYueFacade baoyueFacade;

    @Override
    @GET
    @Path("/baoyue/{themeId}")
    @Produces(ContentType.APPLICATION_JSON_UTF_8)
    public Map<String, Object> recommend(@PathParam("themeId") long themeId, @QueryParam("title") String title, @QueryParam("lat") double lat, @QueryParam("lon") double lon, @QueryParam("range") @DefaultValue("10000") long range, @DefaultValue("2") @QueryParam("limit") int limit) {
        String info = "themeId=[" + themeId + "],title=[" + title + "],lat=[" + lat + "], lon=[" + lon + "],range=[" + range + "] and limit=[" + limit + "]";
        infoLogger.info("Starting Bao Yue Recommend Service : " + info);
        if (null == context) {
            context = setup();
        }
        Preconditions.checkNotNull(context, "BaoYue metadata is null");
        Map<String, Object> requestParams = ParametersUtil.wrap(this.getClass().getSimpleName(), themeId, title, lat, lon, range, limit);
        Map<String, Object> response = new HashMap<String, Object>();
        List<BaoYueDto> data = baoyueFacade.recommend(requestParams, context);

        try {
            response.put("success", true);
            response.put("returnCode", 0);
            response.put("message", "Ok");
            response.put("data", data);
        } catch (Exception ex) {
            response.put("returnCode", "-1");
            response.put("success", false);
            String msg = ExceptionUtils.getFullStackTrace(ex);
            response.put("message", msg);
            final String subject = "宝约推荐接口异常";
            NotifierUtil.notifyByPhone(subject);
            NotifierUtil.notifyByEmail(subject, msg);
            errorLogger.error("宝约荐接口:" + info + msg);
        }
        infoLogger.info("Bao Yue recommendation is done !" + info + " and recommend [" + data.size() + "] items bao yue");
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
        infoLogger.info("setup [" + serviceName + " ], and context = [" + json + "]");
        return JSONObject.parseObject(json);
    }
}

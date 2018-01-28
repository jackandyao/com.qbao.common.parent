package com.qbao.recommend.business.baogou.rest.impl;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.qbao.recommend.business.baogou.cmp.facade.BaoGouFacde;
import com.qbao.recommend.business.baogou.cmp.util.ParametersUtil;
import com.qbao.recommend.business.baogou.rest.IBaoGouRecommendService;
import com.qbao.recommend.business.baogou.rest.dto.BaoGouGrankDto;
import com.qbao.recommend.business.baogou.rest.dto.TopViewSpuDto;
import com.qbao.recommend.business.tweet.cmp.util.NotifierUtil;
import com.qbao.recommend.respositoy.mysql.model.RecommendMetadata;
import com.qbao.recommend.respositoy.mysql.service.IRecommendMetadataService;
import com.qbao.recommend.respositoy.mysql.util.DateUtil;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.*;

/**
 * @author wangping
 * @createTime 下午2:24
 * $$LastChangedDate: 2016-11-21 13:55:11 +0800 (Mon, 21 Nov 2016) $$
 * $$LastChangedRevision: 1420 $$
 * $$LastChangedBy: wangping $$
 */
@Path("baogouspu")
public class BaoGouRecommendService implements IBaoGouRecommendService {

    private Logger infoLogger = LoggerManagerUtil.getLogger(LogNameEnum.bao_gou, Level.INFO);
    private Logger errorLogger = LoggerManagerUtil.getLogger(LogNameEnum.bao_gou, Level.ERROR);

    private static JSONObject context;

    @Autowired
    private BaoGouFacde baoGouFacde;

    @Autowired
    IRecommendMetadataService recommendMetadataService;

    @Override
    @GET
    @Path("/browse/gettop")
    @Produces(ContentType.APPLICATION_JSON_UTF_8)
    public Map<String, Object> fetchTopViewSpu(@DefaultValue("30") @QueryParam("limit") int limit) {
        infoLogger.info("starting Bao Gou Recommend Service ... and the limit =["+limit+"]");
        if (null == context) {
            context = setup();
        }
        Preconditions.checkNotNull(context,"Bao Gou metadata is null");

        Map<String, Object> requestParams = ParametersUtil.wrap(this.getClass().getSimpleName(),limit);
        Map<String, Object> response = new HashMap<String, Object>();
        List<TopViewSpuDto> data =  baoGouFacde.fetchTopViewSpu(requestParams,context);

        try {
            response.put("success", true);
            response.put("returnCode", 0);
            response.put("message", "Ok");
            response.put("data", data);
        } catch (Exception ex) {
            response.put("returnCode", "-1");
            response.put("success", false);
            String msg = ExceptionUtils.getFullStackTrace(ex);
            response.put("message",msg);
            final String subject = "宝购推荐接口异常";
            NotifierUtil.notifyByPhone(subject);
            NotifierUtil.notifyByEmail(subject,msg);
            errorLogger.error("宝购荐接口 用户账号:  错误信息为:" + msg);
        }
       infoLogger.info(" Bao Gou recommendation is done ! and recommend [" + data.size() + "] items ");
        return response;
    }

    @Override
    @GET
    @Path("/haohuo/{baoGouId}")
    @Produces(ContentType.APPLICATION_JSON_UTF_8)
    public Map<String, Object> fetchHaoHuoIndex(@PathParam("baoGouId") long baoGouId) {
        infoLogger.info("starting Bao Gou Recommend Service ... and the baoGouId =["+baoGouId+"]");
        if (null == context) {
            context = setup();
        }
        Preconditions.checkNotNull(context,"Bao Gou metadata is null");
        Map<String, Object> response = new HashMap<String, Object>();
        BaoGouGrankDto data =  baoGouFacde.fetchHaoHuoIndex(baoGouId);
        try {
            response.put("success", true);
            response.put("returnCode", 0);
            response.put("message", "Ok");
            response.put("data", data == null ? "": data);
        } catch (Exception ex) {
            response.put("returnCode", "-1");
            response.put("success", false);
            String msg = ExceptionUtils.getFullStackTrace(ex);
            response.put("message",msg);
            final String subject = "宝购好货指数接口异常: 宝购商品Id ["+baoGouId+"]";
            NotifierUtil.notifyByPhone(subject);
            NotifierUtil.notifyByEmail(subject,msg);
            errorLogger.error(subject + msg);
        }
        infoLogger.info(" Bao Gou["+baoGouId+"] hao huo index is done !  ");
        return response;
    }

    @Override
    @GET
    @Path("/haohuo/batch")
    @Produces(ContentType.APPLICATION_JSON_UTF_8)
    public Map<String, Object> batchFetchHaoHuoIndex(@QueryParam("baoGouIds") String baoGouIds) {
        infoLogger.info("starting Bao Gou Recommend Service ... and the baoGouIds =["+baoGouIds+"]");
        if (null == context) {
            context = setup();
        }
        Preconditions.checkNotNull(context,"Bao Gou metadata is null");
        Map<String, Object> response = new HashMap<String, Object>();
        List<Long> ids =  parseBaogouIdStr(baoGouIds);
        infoLogger.info("total get ["+ids.size()+"] bao gou ids" );
        List<BaoGouGrankDto> data = Lists.newArrayList();
        try {
        for(Long baoGouId : ids) {
            BaoGouGrankDto grank  = baoGouFacde.fetchHaoHuoIndex(baoGouId);
            if(null != grank){
                data.add(grank);
                infoLogger.info("Got the  Bao Gou ["+baoGouId+"] hao huo index  !  ");
            }else {
                infoLogger.info(" Bao Gou["+baoGouId+"] hao huo index is not exist !  ");
            }

        }
            response.put("success", true);
            response.put("returnCode", 0);
            response.put("message", "Ok");
            response.put("data", data == null ? "": data);
        } catch (Exception ex) {
            response.put("returnCode", "-1");
            response.put("success", false);
            String msg = ExceptionUtils.getFullStackTrace(ex);
            response.put("message",msg);
            final String subject = "宝购好货指数接口异常: 宝购商品Ids ["+baoGouIds+"]";
            NotifierUtil.notifyByPhone(subject);
            NotifierUtil.notifyByEmail(subject,msg);
            errorLogger.error(subject + msg);
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
        infoLogger.info("setup [" + serviceName + " ], and context = [" + json + "]");
        return JSONObject.parseObject(json);
    }

    @Override
    @GET
    @Path("/history/salenum")
    @Produces(ContentType.APPLICATION_JSON_UTF_8)
    public Map<String, Object> fetchGoodsSaleNum(@QueryParam("spuId") long spuId,@QueryParam("startDate") String startDate, @QueryParam("endDate") String endDate) {
        infoLogger.info("baogouspu/history/salenum?spuId="+spuId+"&startDate="+startDate+"&endDate="+endDate);
        Map<String, Object> response = new HashMap<String, Object>();
        try {
            if (StringUtils.isEmpty(startDate) || StringUtils.isEmpty(endDate)) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                endDate = DateUtil.format.format(cal);
                cal.add(Calendar.DAY_OF_YEAR,-90);
                startDate =  DateUtil.format.format(cal);
            }
            long totalNum = baoGouFacde.findTotalSaleNumBySpuId(spuId, startDate, endDate);
            response.put("responseCode", "1000");
            response.put("errorCode", "0");
            response.put("errorMsg", "ok");
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("spuId", spuId);
            data.put("sales", totalNum);
            response.put("data", data);
        }catch(Exception e){
            response.put("responseCode", "1001");
            response.put("errorCode", "1001");
            response.put("errorMsg", "系统错误");
        }
        return response;

    }
    private List<Long> parseBaogouIdStr(String baoGouIds){
        List<Long> ids = Lists.newArrayList();
        if(StringUtils.isNotBlank(baoGouIds)){
            String[] idStrs =  StringUtils.split(baoGouIds,",");
            if(null != idStrs){
                for(String idStr : idStrs){
                    ids.add(NumberUtils.toLong(idStr));
                }
            }
        }
        return ids;
    }
}

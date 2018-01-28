/**
 *
 */
package com.qbao.recommend.business.goodProduct.rest.impl;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.google.common.collect.Maps;
import com.qbao.recommend.business.goodProduct.cmp.RecommendGoodProductFacade;
import com.qbao.recommend.business.goodProduct.rest.IGoodProductService;
import com.qbao.recommend.business.goodProduct.rest.dto.*;
import com.qbao.recommend.business.tweet.cmp.util.NotifierUtil;
import com.qbao.recommend.respositoy.mysql.model.GoodProductDir;
import com.qbao.recommend.respositoy.mysql.page.Page;
import com.qbao.recommend.respositoy.restful.entities.GoodGoods;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sjzhangjun
 *
 * $LastChangedDate$
 * $LastChangedRevision$
 * $LastChangedBy$
 */
@Path("goods_stat")
public class GoodProductService implements IGoodProductService {

    Logger goodstafWarnLogger = LoggerManagerUtil.getLogger(LogNameEnum.good_product, Level.WARN);
    Logger goodstafErrorLogger = LoggerManagerUtil.getLogger(LogNameEnum.good_product, Level.ERROR);
    Logger reprotLogger = LoggerManagerUtil.getLogger(LogNameEnum.good_product, Level.INFO);

    @Autowired
    RecommendGoodProductFacade recommendGoodProductFacade;

    @GET
    @Path("performance_data")
    @Produces(ContentType.APPLICATION_JSON_UTF_8)
    @Override
    public Map<String, Object> getGoodProduct(@QueryParam("goodsId") long goodsId) {
        Map<String, Object> response = Maps.newHashMap();
        try {
            goodstafWarnLogger.warn("好货出货走趋/业绩表现 : goods id = [" + goodsId + "] ");
            PerformanceDTO data = recommendGoodProductFacade.fetchGoodProduct(goodsId);
            if (null != data) {
                response.put("success", true);
                response.put("returnCode", 0);
                response.put("message", "出货走趋/业绩表现");
                response.put("data", data);
            } else {
                response.put("success", false);
                response.put("returnCode", 2000);
                response.put("message", "请求数据超时，请稍后再试");
                response.put("data", "");
            }
        } catch (Exception e) {
            response.put("returnCode", 1000);
            String notiferMsg = "好货出货走趋/业绩表现 : goods id [" + goodsId + "] , 错误信息为:" + ExceptionUtils.getMessage(e);
            String returnMsg = "服务请求过于繁忙,请您稍后再试";
            response.put("success", false);
            response.put("message", returnMsg);
            response.put("data", "");
            final String subject = "好货出货走趋/业绩表现异常";
            NotifierUtil.notifyByPhone(subject);
            NotifierUtil.notifyByEmail(subject,notiferMsg);
            goodstafErrorLogger.error(notiferMsg);
        }
        return response;
    }

    @GET
    @Path("goods_likes")
    @Produces(ContentType.APPLICATION_JSON_UTF_8)
    @Override
    public Map<String, Object> getGoodsLikes(@QueryParam("goodsId") long goodsId, @DefaultValue("6") @QueryParam("pageSize") int pageSize) {
        Map<String, Object> response = Maps.newHashMap();
        goodstafWarnLogger.warn("starting goods likes service for goods id =[" + goodsId + "] and pageSize = [" + pageSize + "]... ");
        List<GoodsLikesDTO> data = recommendGoodProductFacade.fetchGoodsLikes(goodsId, pageSize);
        try {
            if (CollectionUtils.isNotEmpty(data)) {
                response.put("success", true);
                response.put("returnCode", 0);
                response.put("message", "可能喜欢的商品");
                response.put("data", data);
            } else {
                response.put("success", false);
                response.put("returnCode", 3000);
                response.put("message", "后台无相关联的产品");
                response.put("data", "");
            }
        } catch (Exception e) {
            String notiferMsg = "好货可能喜欢接口异常: goods id [" + goodsId + "], 错误信息为:" + ExceptionUtils.getMessage(e);
            String returnMsg = "服务请求过于繁忙,请您稍后再试";
            response.put("returnCode", 1000);
            response.put("success", false);
            response.put("message", returnMsg);
            response.put("data", "");
            final String subject = "好货可能喜欢接口异常";
            NotifierUtil.notifyByPhone(subject);
            NotifierUtil.notifyByEmail(subject,notiferMsg);
            goodstafErrorLogger.error(notiferMsg);
        }
        goodstafWarnLogger.warn("goods id =[" + goodsId + "]  goods likes service is done ! ");
        return response;
    }

    @GET
    @Path("goods_kpi")
    @Produces(ContentType.APPLICATION_JSON_UTF_8)
    @Override
    public Map<String, Object> getGoodsKPI(@QueryParam("goodsId") long goodsId) {
        Map<String, Object> response = Maps.newHashMap();
        goodstafWarnLogger.warn("starting goods KPI service for goods id =[" + goodsId + "] ... ");
        reprotLogger.info(goodsId );
        try {
            KpiDTO data = recommendGoodProductFacade.fetchGoodsKpi(goodsId);
            if (null != data) {
                response.put("success", true);
                response.put("returnCode", 0);
                response.put("message", "好货KPI");
                response.put("data", data);
            } else {
                response.put("success", false);
                response.put("returnCode", 2000);
                response.put("message", "请求数据超时，请稍后再试");
                response.put("data", "");
            }
        } catch (Exception e) {
            String notiferMsg = "好货KPI: goods id [" + goodsId + "] , 错误信息为:" + ExceptionUtils.getMessage(e);
            String returnMsg = "服务请求过于繁忙,请您稍后再试";
            response.put("returnCode", 1000);
            response.put("success", false);
            response.put("message", returnMsg);
            response.put("data", "");
            final String subject = "好货KPI接口异常";
            NotifierUtil.notifyByPhone(subject);
            NotifierUtil.notifyByEmail(subject,notiferMsg);
            goodstafErrorLogger.error(notiferMsg);
        }
        goodstafWarnLogger.warn("goods id =[" + goodsId + "]  KPI service is done ! ");
        return response;
    }

    /**
     * 有好货 分类接口
     *
     * @return
     */
    @Override
    @GET
    @Path("goods_class")
    @Produces(ContentType.APPLICATION_JSON_UTF_8)
    public Map<String, Object> getGoodsClasses() {
        goodstafWarnLogger.warn("starting goods_class service ");
        Map<String,Object> response = new HashMap<String,Object>();
        try {
            List<GoodClassDTO> dataList = new ArrayList<GoodClassDTO>();
            List<GoodProductDir> dirs = recommendGoodProductFacade.findHaohuoClasses();
            for (GoodProductDir dir : dirs) {
                GoodClassDTO dto = new GoodClassDTO();
                dto.setId(dir.getId());
                dto.setName(dir.getDirName());
                dataList.add(dto);
            }
            response.put("returnCode", "1000");
            response.put("returnMsg", "ok");
            response.put("data", dataList);
        }catch(Exception e){
            response.put("returnCode", "1001");
            response.put("returnMsg", "系统错误！");
        }
        return response;

    }

    /**
     * 好货列表接口
     *
     * @param cid
     * @param page
     * @param size
     */
    @Override
    @GET
    @Path("goods_list")
    @Produces(ContentType.APPLICATION_JSON_UTF_8)
    public Map<String, Object> getGoodsList(@QueryParam("cid")long cid, @DefaultValue("")@QueryParam("kw") String kw,@DefaultValue("1")@QueryParam("page")int page, @DefaultValue("8")@QueryParam("size")int size) {
        goodstafWarnLogger.warn("starting goods_list service param: cid:"+cid+" kw:"+kw+" page:"+page+"  size:"+size);
        Map<String,Object> response = new HashMap<String,Object>();
        try {
            Page<GoodGoods> result = recommendGoodProductFacade.findHaohuoPage(cid,kw, page, size);
            int total = result.getTotalNumber();
            List<GoodGoodsDTO> dataList = new ArrayList<GoodGoodsDTO>();
            Map<String, Object> data = new HashMap<String, Object>();
            for (GoodGoods gg : result.getItems()) {
                GoodGoodsDTO dto = new GoodGoodsDTO();
                dto.setBuyNum(gg.getSaleNum());
                dto.setChannelName(gg.getFromSource());
                dto.setGoodNum(Double.parseDouble(gg.getHaohuoScore() + ""));
                dto.setGoodsId(gg.getProductId());
                dto.setItemImage(gg.getMainImg());
                dto.setItemOriginalPrice(gg.getProductPrice());
                dto.setItemPresentPrice(gg.getProductPrice());
                dto.setItemUrl(gg.getHaohuoUrl());
                dto.setItemName(gg.getProductName());
                dataList.add(dto);
            }
            data.put("total", total);
            data.put("list", dataList);
            response.put("returnCode", "1000");
            response.put("returnMsg", "ok");
            response.put("data", data);
        }catch (Exception e){
            goodstafErrorLogger.error("系统错误！error info："+ExceptionUtils.getFullStackTrace(e));
            response.put("returnCode", "1001");
            response.put("returnMsg", "系统错误！");
        }
        return response;

    }

}

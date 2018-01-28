/**
 * 
 */
package com.qbao.recommend.business.product.rest.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSONArray;
import com.qbao.recommend.alarm.util.MessageConstanUtil;
import com.qbao.recommend.business.product.cmp.RecommendSpuFacade;
import com.qbao.recommend.business.product.cmp.service.exclude.IExcludeProductService;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.business.product.rest.IHaohuoService;
import com.qbao.recommend.respositoy.mysql.model.RecommendMetadata;
import com.qbao.recommend.respositoy.mysql.model.SpuInfoMerchant;
import com.qbao.recommend.respositoy.mysql.service.IMerSpuService;
import com.qbao.recommend.respositoy.mysql.service.IRecommendMetadataService;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.haohuo.HaoHuoConstant;
import com.qbao.recommend.util.haohuo.HaoHuoUtil;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import com.qbao.recommend.util.page.PageUtil;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate$
 * $LastChangedRevision$
 * $LastChangedBy$
 */
@Path("recommend/haoHuoRecommend")
public class HaohuoService  implements IHaohuoService{
    
    @Autowired
    RecommendSpuFacade recommendSpuFacade;
    
    @Autowired
    IRecommendMetadataService recommendMetadataService;
    
    @Autowired
    IMerSpuService merSpuService;

    @Autowired
    IExcludeProductService excludeProductService;
    
    /* (non-Javadoc)
     * @see com.qbao.recommend.business.product.rest.IHaohuoService#getHaohuos(java.lang.String)
     */
    @POST
    @Path("mustBuy")
    @Produces(ContentType.APPLICATION_JSON_UTF_8)
    @Override
    public Map<String, Object> getHaohuos(@FormParam("userId") long userId, @FormParam("page") int page, @FormParam("pageSize") int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        Logger goodstafInfoLogger = LoggerManagerUtil.getLogger(LogNameEnum.goodstaf, Level.INFO);
        Logger goodstafWarnLogger = LoggerManagerUtil.getLogger(LogNameEnum.goodstaf, Level.WARN);
        Logger goodstafErrorLogger = LoggerManagerUtil.getLogger(LogNameEnum.goodstaf, Level.ERROR);
        goodstafWarnLogger.warn("params:userId:" + userId + "\t page:" + page + "\t pageSize:" + pageSize);
        Map<String, Object> params = new HashMap<String, Object>();
        page=page<=0?1:page;
        pageSize=pageSize<=0?12:pageSize;
        params.put(RecommendConstantUtil.USER_ID, userId);
        params.put(RecommendConstantUtil.CURRENT_PAGE, page);
        params.put(RecommendConstantUtil.PAGE_SIZE, pageSize);
        params.put(MessageConstanUtil.ALARM_CLASS_NAME, "IHaohuoService");

        RecommendMetadata metaData = recommendMetadataService.findByParamKey("IHaohuoService");
        if (metaData == null || StringUtils.isEmpty(metaData.getParam_value())) {
              goodstafErrorLogger.error("RecommendMetadata must not be null or value not be empty！");
              throw new RuntimeException("RecommendMetadata must not be null or value not be empty！");
        }
        String json = metaData.getParam_value();
        goodstafWarnLogger.warn("recommendMetadata json:"+json);
        JSONArray jsonObject = JSONArray.parseArray(json);
        List<Long> spuIds =  recommendSpuFacade.getSpuTopList(jsonObject, params);
        PageUtil<Long> util = new PageUtil<Long>(spuIds);
        if(util.getPageSize()!=pageSize) {
            util.setPageSize(pageSize);
        }
        goodstafWarnLogger.warn("alllist:"+spuIds);
        goodstafInfoLogger.info(userId+"\t"+util.getPage(page));
        List<MustBuyDTO> spus = new ArrayList<MustBuyDTO>();
        if(util.getPage(page).size()==pageSize){
             spus = this.toMustBuyDTo(util.getPage(page));
        }
        map.put("success", true);
        map.put("returnCode", 0);
        map.put("message", "Ok");
        map.put("data", spus);
        return map;
    }

    /* (non-Javadoc)
     * @see com.qbao.recommend.business.product.rest.IHaohuoService#getFlashSales(java.lang.String)
     */
    @POST
    @Path("flashSale")
    @Override
    public Map<String, Object> getFlashSales(@FormParam("userId") long userId, @FormParam("pageSize") int pageSize, @FormParam("single") int single) {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    
    private List<MustBuyDTO> toMustBuyDTo(List<Long> idsRepos) {
        List<MustBuyDTO> mustBuyList = new ArrayList<>();
        for (int i = 0; i < idsRepos.size(); i++) {
            SpuInfoMerchant merChant = getSpuInfoMerchant(idsRepos.get(i));
            if (merChant != null) {
                MustBuyDTO m = parseMerChantToMustBuyDTO(merChant);
                mustBuyList.add(m);
            }
        }
        return mustBuyList;
    }

    private MustBuyDTO toMustBuyDTO(Long id) {
        MustBuyDTO m = null;
        SpuInfoMerchant merChant =getSpuInfoMerchant(id);
        if (merChant != null) {
            m = parseMerChantToMustBuyDTO(merChant);
        }
        return m;
    }
    
    @Cacheable(value="twoMinCache", key="#id+'getSpuInfoMerchant'")
    private SpuInfoMerchant getSpuInfoMerchant(long id){
       return  merSpuService.findBySpuId(id);
    }
    
    /**
     * 从SpuInfoMerchant对象中提取数据转化成MustBuyDTO
     * 
     * @param merChant
     * @return
     */
    private MustBuyDTO parseMerChantToMustBuyDTO(SpuInfoMerchant merChant) {
        MustBuyDTO mustBuy = new MustBuyDTO();
        mustBuy.setId(merChant.getSpuId());
        mustBuy.setName(merChant.getSpuName());
        mustBuy.setFreeDelivery(-1);
        mustBuy.setPrice(merChant.getViewPrice());
        mustBuy.setSalesVolume(merChant.getSellCountAggregated());
        mustBuy.setLikes(merChant.getSpuThumb());
        mustBuy.setImgUrl(merChant.getMainImg() + "?channeType=" + HaoHuoConstant.WEISHANG_CHANNELTYPE);
        // mustBuy.setImgUrl(merChant.getMainImg());
        mustBuy.setGoodsUrl(HaoHuoUtil.getWeiShangDetailUrl(merChant.getSpuId() + ""));
        return mustBuy;

    }

    @GET
    @Path("exclude")
    @Override
    @Produces(ContentType.APPLICATION_JSON_UTF_8)
    public Map<String, Object> exclude(@QueryParam("userId") long userId, @QueryParam("goodsId") long goodsId) {
        System.out.println(userId +"," + goodsId);
        Map<String, Object> response = new HashMap<String, Object>();
        try {
            excludeProductService.exectue(userId, goodsId);
            response.put("success", true);
            response.put("returnCode", 0);
            response.put("message", "Ok");

        }catch (Exception ex){
            response.put("success", false);
            response.put("returnCode", -1);
            response.put("message", ExceptionUtils.getMessage(ex));
        }
        return response;
    }

}

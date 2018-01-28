/**
 * 
 */
package com.qbao.recommend.business.shop.rest.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qbao.recommend.alarm.util.MessageConstanUtil;
import com.qbao.recommend.business.shop.cmp.RecommendShopFacade;
import com.qbao.recommend.business.shop.cmp.model.GoodShopDTO;
import com.qbao.recommend.business.shop.cmp.model.goodshop.BaseInfo;
import com.qbao.recommend.business.shop.cmp.model.goodshop.RecProduct;
import com.qbao.recommend.business.shop.cmp.model.goodshop.ShopInfo;
import com.qbao.recommend.business.shop.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.business.shop.rest.IGoodShopService;
import com.qbao.recommend.respositoy.mysql.model.RecommendMetadata;
import com.qbao.recommend.respositoy.mysql.model.ShopProfile;
import com.qbao.recommend.respositoy.mysql.model.SpuInfoMerchant;
import com.qbao.recommend.respositoy.mysql.service.IMerSpuService;
import com.qbao.recommend.respositoy.mysql.service.IRecommendMetadataService;
import com.qbao.recommend.respositoy.mysql.service.IShopProfileService;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.haohuo.HaoHuoConstant;
import com.qbao.recommend.util.haohuo.HaoHuoUtil;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import com.qbao.recommend.util.page.PageUtil;

/**
 * @author sjzhangjun
 *
 * $LastChangedDate$
 * $LastChangedRevision$
 * $LastChangedBy$
 */
@Path("recommend/haohuoRecommend")
public class GoodShopService  implements IGoodShopService{
    
    @Autowired
    RecommendShopFacade recommendShopFacade;
    
    @Autowired
    IRecommendMetadataService recommendMetadataService;
    
    @Autowired
    IMerSpuService merSpuService;
    
    @Autowired
    IShopProfileService shopProfileService;
    
    Logger goodShopInfoLogger = LoggerManagerUtil.getLogger(LogNameEnum.shop_facade, Level.INFO);
    Logger goodShopWarnLogger = LoggerManagerUtil.getLogger(LogNameEnum.shop_facade, Level.WARN);
    Logger goodShopErrorLogger = LoggerManagerUtil.getLogger(LogNameEnum.shop_facade, Level.ERROR);
    
    /* (non-Javadoc)
     * @see com.qbao.recommend.business.product.rest.IGoodShopService#getGoodShops(java.lang.String)
     */
    @GET
    @Path("goodShop")
    @Produces(ContentType.APPLICATION_JSON_UTF_8)
    @Override
    public Map<String, Object> getGoodShops(@QueryParam("userId") long userId, @QueryParam("page") int page, @QueryParam("pageSize") int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        
        goodShopWarnLogger.warn("params:userId:" + userId + "\t page:" + page + "\t pageSize:" + pageSize);
        Map<String, Object> params = new HashMap<String, Object>();
        page=page<=0?1:page;
        pageSize=pageSize<=0?6:pageSize;
        params.put(RecommendConstantUtil.USER_ID, userId);
        params.put(RecommendConstantUtil.CURRENT_PAGE, page);
        params.put(RecommendConstantUtil.PAGE_SIZE, pageSize);
        params.put(MessageConstanUtil.ALARM_CLASS_NAME, "IGoodShopService");

        RecommendMetadata metaData = recommendMetadataService.findByParamKey("IGoodShopService");
        if (metaData == null || StringUtils.isEmpty(metaData.getParam_value())) {
              goodShopErrorLogger.error("RecommendMetadata must not be null or value not be empty！");
              throw new RuntimeException("RecommendMetadata must not be null or value not be empty！");
        }
        String json = metaData.getParam_value();
        goodShopWarnLogger.warn("recommendMetadata json:"+json);
        JSONArray jsonObject = JSONArray.parseArray(json);
        List<String> spuIds =  recommendShopFacade.getShopTopList(jsonObject, params);
        PageUtil<String> util = new PageUtil<String>(spuIds);
        if(util.getPageSize()!=pageSize) {
            util.setPageSize(pageSize);
        }
        goodShopWarnLogger.warn("alllist:"+spuIds);
        goodShopInfoLogger.info(userId+"\t"+util.getPage(page));
        List<GoodShopDTO> spus = this.toGoodShopDTO(util.getPage(page));
        map.put("success", true);
        map.put("returnCode", 0);
        map.put("message", "Ok");
        map.put("data", spus);
        return map;
    }

    
    private List<GoodShopDTO> toGoodShopDTO(List<String> shops) {
        List<GoodShopDTO> goodShopList = Lists.newArrayList();
        
        for (String shop : shops) {
            String[] split = shop.split(":");
            long shopId = Long.parseLong(split[0]);
            String prdIds = split[2];
            ShopProfile shopProfile = shopProfileService.findById(shopId);
            if (shopProfile != null) {
                GoodShopDTO goodShopDTO = getGoodShopDTO(shopProfile, prdIds);
                if (goodShopDTO != null) {
                	goodShopList.add(goodShopDTO);
                }
            }
        }
        return goodShopList;
    }

    /**
     * 将ShopProfile类型转化成DTO
     * @param shopProfile
     * @return
     */
    private GoodShopDTO getGoodShopDTO(ShopProfile shopProfile, String prdIds) {
        GoodShopDTO goodShop = null;
        Gson gson = new GsonBuilder().create();
        ShopInfo shop = gson.fromJson(shopProfile.getItems(), ShopInfo.class);
        String[] split = prdIds.split(",");
        goodShopWarnLogger.warn(shopProfile.getShopId() + "店铺中共推荐了【" + split.length + "】条商品数据");
        List<RecProduct> goods = new ArrayList<RecProduct>();
        int flag = 0;
        for (int i = 0; i < split.length; i++) {
            SpuInfoMerchant merchant = merSpuService.findBySpuId(Long.parseLong(split[i]));
            if (merchant != null) {
                RecProduct good = new RecProduct();
                good.setGoodsId(split[i]);
                good.setImgUrl(merchant.getMainImg() + "?channelType=" + HaoHuoConstant.WEISHANG_CHANNELTYPE);
                good.setGoodsUrl(HaoHuoUtil.getWeiShangDetailUrl(merchant.getSpuId() + ""));
                goods.add(good);
                flag = flag + 1;
                goodShopWarnLogger.warn(split[i] + "商品ID在售");
            }
            if (goods.size() >= 5) {
                break;
            }
        }
        goodShopWarnLogger.warn(shopProfile.getShopId() + "店铺中共有【" + flag + "】个在售商品");
        if (flag > 0) {
            goodShop = new GoodShopDTO();
            goodShop.setId(Long.parseLong(shop.getShopId()));
            goodShop.setName(shop.getShopName());
            if (shop.getShopType().equals("个人认证商家") || shop.getShopType().equals("普通商家")) {
                goodShop.setType(1);
            } else if (shop.getShopType().equals("企业商家") || shop.getShopType().equals("虚拟充值")) {
                goodShop.setType(2);
            } else if (shop.getShopType().equals("金牌认证商家")) {
                goodShop.setType(3);
            }
            goodShop.setLogoUrl(StringUtils.trimToEmpty(shop.getLogoPath()));
            goodShop.setOnSale(CollectionUtils.isNotEmpty(shop.getGoods()) ? shop.getGoods().size() : 0);
            goodShop.setShopUrl(HaoHuoUtil.getGoodShopDetailUrl(shop.getShopId()));

            BaseInfo baseInfo = shop.getBaseInfo();
            if (null != baseInfo) {
                goodShop.setSold(baseInfo.getTotalOrders());
                goodShop.setLikes(baseInfo.getShopThumbTotal());
            }
            goodShop.setProducts(goods);
        }
        return goodShop;
    }

}

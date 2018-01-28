package com.qbao.recommend.business.shop.cmp.factory;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.qbao.recommend.business.shop.cmp.service.buy.IShopBuyService;
import com.qbao.recommend.business.shop.cmp.service.emergency.IEmergencyDataService;
import com.qbao.recommend.business.shop.cmp.service.icf.IShopICFService;
import com.qbao.recommend.business.shop.cmp.service.intervention.IManualInterventionService;
import com.qbao.recommend.business.shop.cmp.service.prd.IShopPrdService;
import com.qbao.recommend.business.shop.cmp.service.view.IShopViewService;
import com.qbao.recommend.business.shop.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;

@Component
public class CommonServiceFactory {
    Logger commonServiceFactoryLogger = LoggerManagerUtil.getLogger(LogNameEnum.shop_facade, Level.WARN);
    /**
     * buy
     */
    @Autowired
    protected IShopBuyService iShopBuyService;
    /**
     * icf
     */
    @Autowired
    protected IShopICFService iShopICFService;

    /**
     * prd
     */
    @Autowired
    protected IShopPrdService iShopPrdService;

    /**
     * view
     */
    @Autowired
    protected IShopViewService iShopViewService;
    
    /**
     * manual
     */
    @Autowired
    protected IManualInterventionService manualInterventionService;
    
    /**
     * emerengy
     */
    @Autowired
    protected IEmergencyDataService emergencyDataService;
    
  
    
    /**
     * 基于ICF店铺相关推荐
     * @param param
     * @param jsonObject
     * @return
     */
    protected List<JSONObject> getShopListByICFType(String param, JSONObject jsonObject){
        if (param.equals(RecommendConstantUtil.SHOP_ICF)){
            commonServiceFactoryLogger.warn("get shop list base on icf");
            return combinedList(iShopICFService.getTopShopByICF(jsonObject), param);
        }
        return Lists.newArrayList();
    }

    /**
     * 基于购买店铺相关推荐
     * @param param
     * @param jsonObject
     * @return
     */
    protected List<JSONObject> getShopListByBuyType(String param, JSONObject jsonObject){
        if(param.equals(RecommendConstantUtil.SHOP_BUY)){
            commonServiceFactoryLogger.warn("get shop list base on buy!");
            return combinedList(iShopBuyService.getTopShopByBuy(jsonObject), param);
        }
        return Lists.newArrayList();
    }


    /**
     * 基于个性化产品相关店铺推荐
     * @param type
     * @param jsonObject
     * @return
     */
    protected List<JSONObject>getShopListByPrdType(String type,JSONObject jsonObject){
        if (type.equals(RecommendConstantUtil.SHOP_PRD)){
            commonServiceFactoryLogger.warn("get spuId list base on ICF!");
            return combinedList(iShopPrdService.getTopShopByPrd(jsonObject), type);
        }
        return Lists.newArrayList();
    }

    /**
     * 基于浏览相关店铺推荐
     * @param param
     * @param jsonObject
     * @return
     */
    protected List<JSONObject>getShopListByViewType(String param,JSONObject jsonObject){
        
        if(param.equals(RecommendConstantUtil.SHOP_VIEW)){
            commonServiceFactoryLogger.warn("get shop list base on hot!");
            return combinedList(iShopViewService.getTopSpuByView(jsonObject), param);
        }
        return Lists.newArrayList();
    }
    
    /**
     * 给返回的产品加上每种算法类型
     * @param list
     * @param type
     * @return
     */
    private List<JSONObject>combinedList(List<String>list,String type){
        List<JSONObject>jsonList=null;
        if (list!=null) {
            jsonList=Lists.newArrayList();
            for(String shop:list){
                JSONObject json=new JSONObject();
                json.put(RecommendConstantUtil.COM_SHOP, shop);
                json.put(RecommendConstantUtil.COM_SHOP_TYPE, type);
                jsonList.add(json);
            }
            return jsonList;
        }
        return Lists.newArrayList();
    }
}

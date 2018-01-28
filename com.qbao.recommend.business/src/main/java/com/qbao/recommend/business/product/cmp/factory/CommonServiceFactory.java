package com.qbao.recommend.business.product.cmp.factory;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.qbao.recommend.business.product.cmp.service.buy.IBuyBySimilSpuService;
import com.qbao.recommend.business.product.cmp.service.buy.IBuySpuByDirectoryService;
import com.qbao.recommend.business.product.cmp.service.buy.IBuySpuByDoleDistrService;
import com.qbao.recommend.business.product.cmp.service.buy.IHotBuySpuService;
import com.qbao.recommend.business.product.cmp.service.emergency.IEmergencyDataService;
import com.qbao.recommend.business.product.cmp.service.intervention.IManualInterventionSpuService;
import com.qbao.recommend.business.product.cmp.service.knowledge.IUserDisimilrSpuService;
import com.qbao.recommend.business.product.cmp.service.personalized.service.ICFSpuService;
import com.qbao.recommend.business.product.cmp.service.personalized.service.IFPGSpuService;
import com.qbao.recommend.business.product.cmp.service.view.IClickByRealtimeSpuService;
import com.qbao.recommend.business.product.cmp.service.view.IClickBySimilSpuService;
import com.qbao.recommend.business.product.cmp.service.view.IClickSpuByDirectoryService;
import com.qbao.recommend.business.product.cmp.service.view.IHotClickSpuService;
import com.qbao.recommend.business.product.cmp.service.view.ILookAgainSpuService;
import com.qbao.recommend.business.product.cmp.service.view.ILookBuySpuService;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.respositoy.mysql.service.ILookAgainAndBuyService;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;

@Component
public class CommonServiceFactory {
    Logger commonServiceFactoryLogger = LoggerManagerUtil.getLogger(LogNameEnum.spu_facade, Level.WARN);
    /**
     * buy
     */
    @Autowired
    protected IHotBuySpuService hotBuySpuService;

//    @Autowired
//    protected IBuyBySimilSpuService buyBySimilSpuService;

    @Autowired
    protected IBuySpuByDirectoryService buySpuByDirectoryService;

    @Autowired
    protected IBuySpuByDoleDistrService buySpuByDoleDistrService;
    /**
     * knowledge
     */
    @Autowired
    protected IUserDisimilrSpuService iUserDisimilrSpuService;

    /**
     * personalized
     */
   
    @Autowired
    protected ICFSpuService icfSpuService;
 
    @Autowired
    protected IFPGSpuService ifgpSpuService;

    /**
     * view
     */
    @Autowired
    protected IHotClickSpuService hotViewSpuService;
    
    @Autowired
    protected IClickBySimilSpuService hotClickBySimilSpuService;
    
//    @Autowired
//    protected IClickSpuByDirectoryService hotClickSpuByDirectoryService;
    
    @Autowired
    protected ILookAgainSpuService lookAgainSpuService;
    
    @Autowired
    protected ILookBuySpuService lookBuySpuService;
    
    @Autowired
    protected IClickByRealtimeSpuService clickByRealtimeSpuService;
    /**
     * manual
     */
    @Autowired
    protected IManualInterventionSpuService manualInterventionService;
    
    /**
     * emerengy
     */
    @Autowired
    protected IEmergencyDataService emergencyDataService;
    
  
    
    /**
     * 基于知识相关推荐
     * @param param
     * @param jsonObject
     * @return
     */
    protected List<JSONObject> getSpuListByDisType(String param, JSONObject jsonObject){
        if (param.equals(RecommendConstantUtil.USER_DIS)){
            commonServiceFactoryLogger.warn("get spuId list base on user dis_similar");
            return combinedList(iUserDisimilrSpuService.getUserSimilarSpuTop(jsonObject), param);
        }
        return Lists.newArrayList();
    }

    /**
     * 基于购买相关推荐
     * @param param
     * @param jsonObject
     * @return
     */
    protected List<JSONObject> getSpuListByBuyType(String param, JSONObject jsonObject){
        if(param.equals(RecommendConstantUtil.HOT_BUY)){
            commonServiceFactoryLogger.warn("get spuId list base on hot buy!");
            return combinedList(hotBuySpuService.getHotBuyTopSpu(jsonObject), param);
        }
        if(param.equals(RecommendConstantUtil.HOT_BUY_DIRECTORY)){
            commonServiceFactoryLogger.warn("get spuId list base on buy of directory!");
            return combinedList(buySpuByDirectoryService.getBuyDirectoryTopSpu(jsonObject), param);
        }
        if (param.equals(RecommendConstantUtil.HOT_BUY_DOLE_DIST)) {
            commonServiceFactoryLogger.warn("get spuId list base on distribution!");
            return combinedList(buySpuByDoleDistrService.getBuySpuByDoleDistribution(jsonObject), param);
        }
        return Lists.newArrayList();
    }


    /**
     * 基于个性化相关推荐
     * @param type
     * @param jsonObject
     * @return
     */
    protected List<JSONObject>getSpuListByPersonalizedType(String type,JSONObject jsonObject){
        //基于ICF算法
        if (type.equals(RecommendConstantUtil.ICF_SPU)){
            commonServiceFactoryLogger.warn("get spuId list base on ICF!");
            return combinedList(icfSpuService.getTopSpuByCF(jsonObject), type);
        }
        //基于FPG算法
        if (type.equals(RecommendConstantUtil.FPG_SPU)){
            commonServiceFactoryLogger.warn("get spuId list base on FPG!");
            return combinedList(ifgpSpuService.getTopSpuByFPG(jsonObject), type);
        }
        return Lists.newArrayList();
    }

    /**
     * 基于浏览相关推荐
     * @param param
     * @param jsonObject
     * @return
     */
    protected List<JSONObject>getSpuListByViewType(String param,JSONObject jsonObject){
        
        if(param.equals(RecommendConstantUtil.CLICK_SPU)){
            commonServiceFactoryLogger.warn("get spuId list base on hot click!");
            return combinedList(hotViewSpuService.getHotViewTopSpu(jsonObject), param);
        }
        if(param.equals(RecommendConstantUtil.CLICK_SIM_SPU)){
            commonServiceFactoryLogger.warn("get spuId list base on click of similarity!");
            return combinedList(hotClickBySimilSpuService.getClickSimilTopSpu(jsonObject), param);
        }
        if (param.equals(RecommendConstantUtil.CLICK_AGAIN_SPU)) {
           commonServiceFactoryLogger.warn("get spuId list base on lookagain!");
           return combinedList(lookAgainSpuService.getLookAgainTopSpu(jsonObject), param);
        }
        if (param.equals(RecommendConstantUtil.CLICK_BUY_SPU)) {
            commonServiceFactoryLogger.warn("get spuId list base on lookbuy!");
            return combinedList(lookBuySpuService.getLookBuyTopSpu(jsonObject), param);
        }
        if(param.equals(RecommendConstantUtil.CLICK_REALTIME_SPU)){
            commonServiceFactoryLogger.warn("get spuId list base on realtime!");
            return combinedList(clickByRealtimeSpuService.getClickByRealtimeTopSpu(jsonObject), param);
        }
        return Lists.newArrayList();
    }
    
    /**
     * 给返回的产品加上每种算法类型
     * @param list
     * @param type
     * @return
     */
    private List<JSONObject>combinedList(List<Long>list,String type){
        List<JSONObject>jsonList=null;
        if (list!=null) {
            jsonList=Lists.newArrayList();
            for(Long spuId:list){
                JSONObject json=new JSONObject();
                json.put(RecommendConstantUtil.COM_SPU_ID, spuId);
                json.put(RecommendConstantUtil.COM_SPU_TYPE, type);
                jsonList.add(json);
            }
            return jsonList;
        }
        return Lists.newArrayList();
    }
}

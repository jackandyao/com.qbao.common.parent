package com.qbao.recommend.business.shop.cmp;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.qbao.recommend.alarm.facade.AlaramServiceFacotryFacade;
import com.qbao.recommend.alarm.util.MessageConstanUtil;
import com.qbao.recommend.business.shop.cmp.handler.factory.ShopHandlerFactory;
import com.qbao.recommend.business.shop.cmp.service.buy.facade.ShopBuyServiceFacade;
import com.qbao.recommend.business.shop.cmp.service.emergency.IEmergencyDataService;
import com.qbao.recommend.business.shop.cmp.service.icf.facade.ShopICFServiceFacade;
import com.qbao.recommend.business.shop.cmp.service.intervention.IManualInterventionService;
import com.qbao.recommend.business.shop.cmp.service.prd.facade.ShopPrdServiceFacade;
import com.qbao.recommend.business.shop.cmp.service.view.facade.ShopViewServiceFacade;
import com.qbao.recommend.business.shop.cmp.strategy.context.DataCompletionStrategyContext;
import com.qbao.recommend.business.shop.cmp.strategy.factory.ShopStrategyFactory;
import com.qbao.recommend.business.shop.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;

/**
 * Created by THink on 2016/7/8.
 * 贾红平
 * 封装推荐对外的最终服务接口
 */
@Component
public class RecommendShopFacade {

    Logger shopFacadeWarnLogger = LoggerManagerUtil.getLogger(LogNameEnum.goodstaf, Level.WARN);

    @Autowired
    private ShopBuyServiceFacade shopBuyServiceFacade;

    @Autowired
    private ShopViewServiceFacade shopViewServiceFacade;

    @Autowired
    private ShopICFServiceFacade shopICFServiceFacade;

    @Autowired
    private ShopPrdServiceFacade shopPrdServiceFacade;

    @Autowired
    private ShopHandlerFactory shopHandlerFactory;

    @Autowired
    private IEmergencyDataService emergencyDataService;
    
    @Autowired
    private ShopStrategyFactory shopStrategyFactory;

    @Autowired
    private DataCompletionStrategyContext dataCompletionStrategyContext;

    @Autowired
    private IManualInterventionService manualInterventionService;

    public List<String> getShopTopList(JSONArray jsonArray, Map<String, Object> param) {
        // 用户账号
        Long userid =0L;
        if(param.containsKey(RecommendConstantUtil.USER_ID)){
            userid=Long.parseLong(param.get(RecommendConstantUtil.USER_ID).toString());
        }else{
            param.put(RecommendConstantUtil.USER_ID, userid);
        }
        // 用户所属角色
        String role = getUserRoleByUserId(userid);
        List<String> alllist = Lists.newLinkedList();

        List<JSONObject> jsonList = Lists.newLinkedList();
        // 如果是匿名用户
        if (role.equals(RecommendConstantUtil.ANOYOUMS_USER)) {
            jsonList = getShopTopBaseNoLogin(jsonArray, param);
        }
        // 如果是登录用户
        if (role.equals(RecommendConstantUtil.LOGIN_USER)) {
            jsonList = getShopTopBaseLogin(jsonArray, param);
        }

        // 调用数据急救策略
        if (jsonList == null || jsonList.size() == 0) {
            JSONObject messageJson = new JSONObject();
            shopFacadeWarnLogger.warn("the result is empty,use emergency data!");
            messageJson.put(MessageConstanUtil.ALARM_CLASS_NAME, param.get(MessageConstanUtil.ALARM_CLASS_NAME));
            messageJson.put(MessageConstanUtil.ALARM_SPU_ID, param.get(RecommendConstantUtil.SPU_ID));
            messageJson.put(MessageConstanUtil.ALARM_TYPE, MessageConstanUtil.MAIL_ERROR);
            messageJson.put(MessageConstanUtil.ALARM_USERID, param.get(RecommendConstantUtil.USER_ID));
            Exception e = new Exception("the result is empty,use emergency data!");
            messageJson.put(MessageConstanUtil.ALARM_EXCEPTION, e);
            AlaramServiceFacotryFacade.sendAlaramMessageByMail(messageJson);
            alllist = emergencyDataService.getEmergencyDataList(alllist);
            return alllist;
        }

        return this.getHandlerList(jsonArray, jsonList);
    }

 
    @SuppressWarnings({ "unchecked" })
    private List<String> getHandlerList(JSONArray jsonArray,List<JSONObject> jsonList){
      //获取handler,completion,strategy配置
        for (Object o : jsonArray) {
            JSONObject json = JSON.parseObject(o.toString());
            if(json.containsKey(RecommendConstantUtil.DATA_COMPLETE)){//补全策略
                //后期扩展
            }else if(json.containsKey(RecommendConstantUtil.DATA_EMERGENCY)){
                //后期扩展
            }else if(json.containsKey(RecommendConstantUtil.DATA_SHUFFLE)){
                JSONObject shuffleObject = json.getJSONObject(RecommendConstantUtil.DATA_SHUFFLE);
                Map<String,Object> map= JSON.toJavaObject(shuffleObject, Map.class);
                map.put(RecommendConstantUtil.SHUFFLE_DATA, jsonList);
                shopHandlerFactory.executeHandleChain(RecommendConstantUtil.SHUFFLE_HANDLER, map);
            }else if(json.containsKey(RecommendConstantUtil.DATA_HANDLER)){
                String handler = json.getString(RecommendConstantUtil.DATA_HANDLER);
                shopHandlerFactory.executeHandleChain(handler, jsonList);
            }
        }
        List<String> llist = null;
        if (jsonList != null) {
            llist = Lists.newLinkedList();
            for (JSONObject jo : jsonList) {
                llist.add(jo.getString(RecommendConstantUtil.COM_SHOP));
            }
            return llist;
        }
        return Lists.newLinkedList();
    }

    /**
     * 区分调用封装接口
     * 
     * @param param
     * @return
     */
    private List<JSONObject> getShopList(JSONArray jsonObject, Map<String, Object> param) {
        List<JSONObject> allList = null;
        if (param != null) {
            allList = Lists.newLinkedList();
            for (Object o : jsonObject) {
                JSONObject json = JSON.parseObject(o.toString());
                // 遍历JSON
                Set<Map.Entry<String, Object>> entries = json.entrySet();
                for (Map.Entry<String, Object> entry : entries) {
                    String key = entry.getKey();
                    Object value = json.get(key);
                    try {
                        JSONArray jsonArray = JSONArray.parseArray(value.toString());
                       
                        // 针对 view
                        if (key.equals(RecommendConstantUtil.FACADE_SHOP_VIEW)) {
                            allList.addAll(shopViewServiceFacade.getShopTopBaseViewFacade(jsonArray, param));
                        }
                        // 针对 buy
                        if (key.equals(RecommendConstantUtil.FACADE_SHOP_BUY)) {
                            allList.addAll(shopBuyServiceFacade.getShopListBaseBuyFacade(jsonArray, param));
                        }
                        // 针对 icf
                        if (key.equals(RecommendConstantUtil.FACADE_SHOP_ICF)) {
                            allList.addAll(shopICFServiceFacade.getShopListBaseICFFacade(jsonArray, param));
                        }
                        // 针对 prd
                        if (key.equals(RecommendConstantUtil.FACADE_SHOP_PRD)) {
                            allList.addAll(shopPrdServiceFacade.getShopListBasePrdFacade(jsonArray, param));
                        }
                    }catch(Exception e){
                        
                    }

                }
            }
        }
        return allList;
    }

    /**
     * 根据用户-获取当前用户所属角色
     * 
     * @param userId
     * @return
     */
    private String getUserRoleByUserId(Long userId) {

        // 登录用户
        if (userId > 0) {
            return RecommendConstantUtil.LOGIN_USER;
        }
        // 非登录用户
        else {
            return RecommendConstantUtil.ANOYOUMS_USER;
        }

    }

    /**
     * 匿名用户
     * 
     * @param jsonObject
     * @param param
     * @return
     */
    private List<JSONObject> getShopTopBaseNoLogin(JSONArray jsonObject, Map<String, Object> param) {
        shopFacadeWarnLogger.warn("this user is anonymous user!");
        return getShopList(jsonObject, param);
    }

    /**
     * 登录用户
     * 
     * @param jsonObject
     * @param param
     * @return
     */
    private List<JSONObject> getShopTopBaseLogin(JSONArray jsonObject, Map<String, Object> param) {
        shopFacadeWarnLogger.warn("this user is logined user!");
        return getShopList(jsonObject, param);
    }
}

package com.qbao.recommend.business.product.cmp;

import java.util.LinkedList;
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
import com.qbao.recommend.business.product.cmp.handler.factory.SpuHandlerFactory;
import com.qbao.recommend.business.product.cmp.service.buy.facade.SpuBuyServiceFacade;
import com.qbao.recommend.business.product.cmp.service.emergency.IEmergencyDataService;
import com.qbao.recommend.business.product.cmp.service.intervention.IManualInterventionSpuService;
import com.qbao.recommend.business.product.cmp.service.knowledge.facade.UserDisServiceFacade;
import com.qbao.recommend.business.product.cmp.service.personalized.facade.SpuPersonalServiceFacade;
import com.qbao.recommend.business.product.cmp.service.view.facade.SpuViewServiceFacade;
import com.qbao.recommend.business.product.cmp.strategy.context.DataCompletionStrategyContext;
import com.qbao.recommend.business.product.cmp.strategy.factory.SpuStrategyFactory;
import com.qbao.recommend.business.product.cmp.util.JSONParseUtil;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;

/**
 * Created by THink on 2016/7/8.
 * 贾红平
 * 封装推荐对外的最终服务接口
 */
@Component
public class RecommendSpuFacade {

    Logger spuFacadeWarnLogger = LoggerManagerUtil.getLogger(LogNameEnum.spu_facade, Level.WARN);

    @Autowired
    private SpuBuyServiceFacade spuBuyServiceFacade;

    @Autowired
    private SpuViewServiceFacade spuViewServiceFacade;

    @Autowired
    private SpuPersonalServiceFacade spuPersonalServiceFacade;

    @Autowired
    private UserDisServiceFacade userDisServiceFacade;

    @Autowired
    private SpuHandlerFactory spuHandlerFactory;

    @Autowired
    private IEmergencyDataService emergencyDataService;
    
    @Autowired
    private SpuStrategyFactory spuStrategyFactory;

    @Autowired
    private DataCompletionStrategyContext dataCompletionStrategyContext;

    @Autowired
    private IManualInterventionSpuService manualInterventionService;

    public List<Long> getSpuTopList(JSONArray jsonArray, Map<String, Object> param) {
        // 用户账号
        Long userid =0L;
        if(param.containsKey(RecommendConstantUtil.USER_ID)){
            userid=Long.parseLong(param.get(RecommendConstantUtil.USER_ID).toString());
        }else{
            param.put(RecommendConstantUtil.USER_ID, userid);
        }
        // 用户所属角色
        String role = getUserRoleByUserId(userid);
        List<Long> alllist = new LinkedList<Long>();

        List<JSONObject> jsonList = new LinkedList<JSONObject>();
        // 如果是匿名用户
        if (role.equals(RecommendConstantUtil.ANOYOUMS_USER)) {
            jsonList = getSpuTopBaseNoLogin(jsonArray, param);
        }
        // 如果是登录用户
        if (role.equals(RecommendConstantUtil.LOGIN_USER)) {
            jsonList = getSpuTopBaseLogin(jsonArray, param);
        }

        // 调用数据急救策略
        if (jsonList == null || jsonList.size() == 0) {
            JSONObject messageJson = new JSONObject();
            spuFacadeWarnLogger.warn("the result is empty,use emergency data!");
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

 
    @SuppressWarnings({ "unused", "unchecked" })
    private List<Long> getHandlerList(JSONArray jsonArray,List<JSONObject> jsonList){
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
                spuHandlerFactory.executeHandleChain(RecommendConstantUtil.SHUFFLE_HANDLER, map);
            }else if(json.containsKey(RecommendConstantUtil.DATA_HANDLER)){
                String handler = json.getString(RecommendConstantUtil.DATA_HANDLER);
                spuHandlerFactory.executeHandleChain(handler, jsonList);
            }
        }
        List<Long> llist = null;
        if (jsonList != null) {
            llist = Lists.newLinkedList();
            for (JSONObject jo : jsonList) {
                llist.add(Long.parseLong(jo.getString(RecommendConstantUtil.COM_SPU_ID)));
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
    private List<JSONObject> getSpuList(JSONArray jsonObject, Map<String, Object> param) {
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
                        // 针对 buy
                        if (key.equals(RecommendConstantUtil.FACADE_SPU_BUY)) {
                            allList.addAll(spuBuyServiceFacade.getSpuListBaseBuyFacade(jsonArray, param));
                        }
                        // 针对 view
                        if (key.equals(RecommendConstantUtil.FACADE_SPU_VIEW)) {
                            allList.addAll(spuViewServiceFacade.getSpuTopBaseViewFacade(jsonArray, param));
                        }
                        // 针对 knowledge
                        if (key.equals(RecommendConstantUtil.FACADE_SPU_KNOWLEDGE)) {
                            allList.addAll(userDisServiceFacade.getUserDisSpuTopFacade(jsonArray, param));
                        }
                        // 针对 personalized
                        if (key.equals(RecommendConstantUtil.FACADE_SPU_PERSONALIZED)) {
                            allList.addAll(spuPersonalServiceFacade.getPersonalSpuTopFacade(jsonArray, param));
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
    private List<JSONObject> getSpuTopBaseNoLogin(JSONArray jsonObject, Map<String, Object> param) {
        spuFacadeWarnLogger.warn("this user is anonymous user!");
        return getSpuList(jsonObject, param);
    }

    /**
     * 登录用户
     * 
     * @param jsonObject
     * @param param
     * @return
     */
    private List<JSONObject> getSpuTopBaseLogin(JSONArray jsonObject, Map<String, Object> param) {
        spuFacadeWarnLogger.warn("this user is logined user!");
        return getSpuList(jsonObject, param);
    }
}

package com.qbao.recommend.business.product.cmp.factory;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.qbao.recommend.alarm.util.MessageConstanUtil;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;

/**
 * Created by 贾红平
 * 贾红平
 * 封装各个算法的服务实现
 * 备注: 后期做扩展的话,只需要添加一个对应的服务接口,然后把给服务封装在对应服务面板中即可
 */
@Component
public class SpuServiceFactory extends CommonServiceFactory{
    
    Logger spuServiceFactoryLogger = LoggerManagerUtil.getLogger(LogNameEnum.spu_facade, Level.WARN);
    
    /**
     *
     * @param jsonArray
     * @param map
     * @return
     */
    public List<JSONObject>getSpuLisByService(String type,JSONArray jsonArray, Map<String,Object> map){
        //获取用户ID
        Integer userId=null;
        if (map.containsKey(RecommendConstantUtil.USER_ID)){
            userId=Integer.parseInt(map.get(RecommendConstantUtil.USER_ID).toString());
        }
        //获取查询关键字
        String keyword=null;
        if (map.containsKey(RecommendConstantUtil.SEARCH_KEY_WORD)){
            keyword=map.get(RecommendConstantUtil.SEARCH_KEY_WORD).toString();
        }
        
        String className = null;
        if (map.containsKey(MessageConstanUtil.ALARM_CLASS_NAME)){
            className=map.get(MessageConstanUtil.ALARM_CLASS_NAME).toString();
        }
        List<JSONObject>alllist=null;
        if (jsonArray.size()>0){
            alllist=Lists.newArrayList();
            Iterator<Object> iterator = jsonArray.iterator();
            while(iterator.hasNext()){
                String key = iterator.next().toString();  
                LinkedHashMap<String, String> jsonMap = JSON.parseObject(key, new TypeReference<LinkedHashMap<String, String>>() {
                });
                for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
                   String serviceKey=entry.getKey().toString(); 
                   String serviceJson=entry.getValue().toString();
                   
                   JSONObject jsonObject=JSONObject.parseObject(serviceJson);
                   jsonObject.put(RecommendConstantUtil.USER_ID, userId);
                   jsonObject.put(RecommendConstantUtil.SEARCH_KEY_WORD, keyword);
                   jsonObject.put(MessageConstanUtil.ALARM_CLASS_NAME, className);
                   alllist.addAll(getSpuListByServiceType(type,serviceKey,jsonObject));
                }
            }
            return alllist;
        }
        return Lists.newArrayList();
    }

    /**
     * 封装推荐方法调用
     * @param type
     * @param param
     * @param jsonObject
     * @return
     */
    private List<JSONObject> getSpuListByServiceType(String type,String param, JSONObject jsonObject){
        if (type.equals(RecommendConstantUtil.FACADE_SPU_VIEW)){
            spuServiceFactoryLogger.warn("get spuId list base on view !");
            return getSpuListByViewType(param,jsonObject);
        }
        if (type.equals(RecommendConstantUtil.FACADE_SPU_BUY)){
            spuServiceFactoryLogger.warn("get spuId list base on buy !");
            return getSpuListByBuyType(param,jsonObject);
        }
        if (type.equals(RecommendConstantUtil.FACADE_SPU_KNOWLEDGE)){
            spuServiceFactoryLogger.warn("get spuId list base on knowledge !");
            return getSpuListByDisType(param,jsonObject);
        }
        if (type.equals(RecommendConstantUtil.FACADE_SPU_PERSONALIZED)){
            spuServiceFactoryLogger.warn("get spuId list base on personlaized !");
            return getSpuListByPersonalizedType(param,jsonObject);
        }
        return Lists.newArrayList();
    }
}
    
   

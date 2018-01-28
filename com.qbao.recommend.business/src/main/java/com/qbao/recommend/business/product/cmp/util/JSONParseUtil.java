package com.qbao.recommend.business.product.cmp.util;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by THink on 2016/7/13.
 * 贾红平
 * 解析JSON/JSONArray的工具类
 */
 public class JSONParseUtil {

    private JSONParseUtil(){}

    static class InnerJson{
        public static JSONParseUtil jsonParseUtil=new JSONParseUtil();
    }

    public static JSONParseUtil getJSONParseUtilInstance(){
        return InnerJson.jsonParseUtil;
    }
    
     /**
      * 获取不同数据策略的具体的类型
      * @param jsonArray
      * @param type
      * @return
      */
     public String getShuffleType(JSONArray jsonArray){
         if (jsonArray!=null) {
             for(Object o:jsonArray){
                 JSONObject json=JSON.parseObject(o.toString());               
                 if (json.containsKey(RecommendConstantUtil.DATA_SHUFFLE)) {
                    return json.getString(RecommendConstantUtil.DATA_SHUFFLE);
                 }
             }
        }
        return null;
     }
         
    /**
     * 获取数据急救策略类型    
     * @param jsonArray
     * @param type
     * @return
     */
    public String getEmergenceType(JSONArray jsonArray){
        if (jsonArray!=null) {
            for(Object o:jsonArray){
                JSONObject json=JSON.parseObject(o.toString());           
                if (json.containsKey(RecommendConstantUtil.DATA_EMERGENCY)) {
                   return json.getString(RecommendConstantUtil.DATA_EMERGENCY);
                }
                 
            }
       }
       return null;
    }
    
    /**
     * 获取数据补全策略类型
     * @param jsonArray
     * @param type
     * @return
     */
   public String getCompleteType(JSONArray jsonArray){
       if (jsonArray!=null) {
           for(Object o:jsonArray){
               JSONObject json=JSON.parseObject(o.toString());
               if (json.containsKey(RecommendConstantUtil.DATA_COMPLETE)) {
                  return json.getString(RecommendConstantUtil.DATA_COMPLETE);
               }
           }
      }
      return null;
   }
}

/**
 * 
 */
package com.qbao.recommend.business.product.cmp.handler.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.product.cmp.handler.RecommendHandler;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate$
 * $LastChangedRevision$
 * $LastChangedBy$
 */
@Component(value=RecommendConstantUtil.ANNO_SPU_SHUFF_HANDLE)
public class SpuShuffHandler implements RecommendHandler{

    /* (non-Javadoc)
     * @see com.qbao.recommend.business.product.cmp.handler.RecommendHandler#executeHandler(java.lang.Object)
     */
    @Override
    public <T> void executeHandler(T t) {
       Map<String,Object> map = (Map<String, Object>) t;
       List<JSONObject> data = (List<JSONObject>) map.get(RecommendConstantUtil.SHUFFLE_DATA);
       List<JSONObject> newList = new ArrayList<JSONObject>();
       Map<String,List<JSONObject>> dataMap = this.getMapFromData(data);
       int pageSize = Integer.parseInt(map.get(RecommendConstantUtil.SHUFFLE_PAGESIZE).toString());
       JSONArray pits = new JSONArray();
       if(map.containsKey(RecommendConstantUtil.SHUFFLE_PIT)){
           pits = JSONArray.parseArray(map.get(RecommendConstantUtil.SHUFFLE_PIT).toString()) ;
       }
       newList = this.getShuffList(dataMap, data.size(), pageSize, pits);
       data.clear();
       data.addAll(newList);
    }
    
    
  
    private Map<String,List<JSONObject>> getMapFromData(List<JSONObject> data){
        Map<String,List<JSONObject>> map = new HashMap<String,List<JSONObject>>();
        for(JSONObject jObject:data){
            String spu_type = jObject.getString(RecommendConstantUtil.COM_SPU_TYPE);
            if(map.containsKey(spu_type)){
                map.get(spu_type).add(jObject);
            }else{
                List<JSONObject> list = new ArrayList<JSONObject>();
                list.add(jObject);
                map.put(spu_type, list);
            }
        }
        return map;
    }
    
    
    private List<JSONObject> getShuffList(Map<String,List<JSONObject>>map,int total,int pageSize,JSONArray pits){
        List<JSONObject> shuffList = new ArrayList<JSONObject>();
        int page =this.getPage(total, pageSize);
        for(int p=0;p<page;p++){
            for(int i=0;i<pageSize;i++){
                JSONObject o = this.shuffInsert(map, i, pits);
                if(o==null){
                    break;
                }
//                System.out.println(o.toJSONString());
                shuffList.add(o);
            }
        }
        return shuffList;
    }
    private int getPage(int total,int pageSize){
        if(total%pageSize == 0 ){
            return total/pageSize;
        }else{
            return total/pageSize+1;
        }
    }
    
    private List<Integer> getPits(JSONObject pit){
        List<Integer> pitindexs = new ArrayList<Integer>();
        if(pit.containsKey(RecommendConstantUtil.SHUFFLE_PIT_INDEX)){
            String pitstr = (String) pit.get(RecommendConstantUtil.SHUFFLE_PIT_INDEX);
            String[] pitstrs = pitstr.split(",");
            for(String p:pitstrs){
                pitindexs.add(Integer.parseInt(p));
            }
        }else{
            return pitindexs;
        }
        return pitindexs;
    }
    
    private JSONObject shuffInsert(Map<String, List<JSONObject>> map, int index, JSONArray pits) {
        // 占坑
        for (Object pit : pits) {
            JSONObject p = (JSONObject) pit;
            List<Integer> indexs = this.getPits(p);
            String pitService = p.getString(RecommendConstantUtil.SHUFFLE_PIT_DATA_SERVICE);
            for (int i : indexs) {
                if (i == index) {
                    if (map.containsKey(pitService)) {
                        Iterator<JSONObject> iterator = map.get(pitService).iterator();
                        if (iterator.hasNext()) {
                            JSONObject jo = iterator.next();
                            iterator.remove();
                            return jo;
                        }
                    }
                }
            }
        }

        int keyIndex = (index) % map.keySet().size();
        int keyRealIndex = 0;
        for (String key : map.keySet()) {
            if (keyRealIndex == keyIndex) {
                Iterator<JSONObject> iterator = map.get(key).iterator();
                if (iterator.hasNext()) {
                    JSONObject jo = iterator.next();
                    iterator.remove();
                    return jo;
                }
            }
            keyRealIndex++;
        }

        for (String key : map.keySet()) {
            Iterator<JSONObject> iterator = map.get(key).iterator();
            if (iterator.hasNext()) {
                JSONObject jo = iterator.next();
                iterator.remove();
                return jo;
            }
        }

        return null;

    }
    
    

}

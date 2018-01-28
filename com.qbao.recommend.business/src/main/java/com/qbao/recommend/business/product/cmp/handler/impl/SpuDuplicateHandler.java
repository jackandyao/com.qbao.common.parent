package com.qbao.recommend.business.product.cmp.handler.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.product.cmp.handler.RecommendHandler;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;

/**
 * Created by THink on 2016/7/8.
 * 贾红平
 * 产品去重复:因为是多个结果集混合,防止有重复的推荐结果
 */
@Component(value=RecommendConstantUtil.ANNO_SPU_DUPLICATE_HANDLE)
public class SpuDuplicateHandler implements RecommendHandler {
    /**
     * 产品去重复
     * @param t
     * @param <T>
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> void executeHandler(T t) {
        List<Object> list=(List<Object>) t;
        Iterator<Object> iterator = list.iterator();
        Set<Long> set = new HashSet<Long>();
        while(iterator.hasNext()){
            Object o=iterator.next();
            if(o instanceof JSONObject){
                JSONObject json=(JSONObject) o;
                Long spuId=Long.parseLong(json.getString(RecommendConstantUtil.COM_SPU_ID));
                if(!set.add(spuId)){
                    iterator.remove();
                }
            }else if(o instanceof Long){
                if(!set.add((Long) o)){
                    iterator.remove();
                }
            }
        }
 
    }
   
}

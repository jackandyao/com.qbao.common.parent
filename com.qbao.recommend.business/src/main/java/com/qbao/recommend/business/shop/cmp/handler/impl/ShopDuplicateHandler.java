package com.qbao.recommend.business.shop.cmp.handler.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Sets;
import com.qbao.recommend.business.shop.cmp.handler.RecommendHandler;
import com.qbao.recommend.business.shop.cmp.util.RecommendConstantUtil;

/**
 * Created by THink on 2016/7/8.
 * 贾红平
 * 产品去重复:因为是多个结果集混合,防止有重复的推荐结果
 */
@Component(value=RecommendConstantUtil.ANNO_SHOP_DUPLICATE_HANDLE)
public class ShopDuplicateHandler implements RecommendHandler {
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
        Set<String> set = Sets.newHashSet();
        while(iterator.hasNext()){
            Object o=iterator.next();
            if(o instanceof JSONObject){
                JSONObject json=(JSONObject) o;
                String shop=json.getString(RecommendConstantUtil.COM_SHOP);
                if(!set.add(shop)){
                    iterator.remove();
                }
            }else if(o instanceof String){
                if(!set.add((String) o)){
                    iterator.remove();
                }
            }
        }
 
    }
   
}

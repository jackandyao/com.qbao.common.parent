package com.qbao.recommend.business.product.cmp.service.knowledge.factory;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.product.cmp.factory.SpuServiceFactory;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;

/**
 * Created by THink on 2016/7/8.
 * 贾红平
 */
@Component
public class UserDisServiceFacotry {

    @Autowired
    private SpuServiceFactory spuServiceFactory;

    /**
     *
     * @param <T>
     * @param jsonArray
     * @param map
     * @return
     */
    public  List<JSONObject> getPersonalSpuTop(JSONArray jsonArray,Map<String,Object>map){
        return spuServiceFactory.getSpuLisByService(RecommendConstantUtil.FACADE_SPU_KNOWLEDGE,jsonArray,map);
    }
}

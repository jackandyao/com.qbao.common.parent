package com.qbao.recommend.business.product.cmp.service.personalized.facade;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.product.cmp.service.personalized.factory.SpuPersonalizedServiceFactory;

/**
 * Created by THink on 2016/7/8.
 * 贾红平
 */
@Component
public class SpuPersonalServiceFacade {

    @Autowired
    private SpuPersonalizedServiceFactory spuPersonalizedServiceFactory;

    public List<JSONObject> getPersonalSpuTopFacade(JSONArray param, Map<String,Object>map){
        return spuPersonalizedServiceFactory.getPersonalSpuTop(param,map);
    }
}

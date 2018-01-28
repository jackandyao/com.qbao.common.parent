package com.qbao.recommend.business.shop.cmp.service.prd.facade;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.shop.cmp.service.icf.factory.ShopICFServiceFacotry;

/**
 * Created by THink on 2016/7/8.
 * 贾红平
 */
@Component
public class ShopPrdServiceFacade {

    @Autowired
    private ShopICFServiceFacotry shopICFServiceFacotry;

    public List<JSONObject> getShopListBasePrdFacade(JSONArray param, Map<String,Object>map){
        return shopICFServiceFacotry.getShopListBaseICF(param,map);
    }
}

package com.qbao.recommend.business.shop.cmp.service.icf.facade;

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
 * 封装用户相似度
 */
@Component
public class ShopICFServiceFacade {

    @Autowired
    private ShopICFServiceFacotry shopICFServiceFacotry;

    public List<JSONObject> getShopListBaseICFFacade(JSONArray param, Map<String,Object>map){
        return shopICFServiceFacotry.getShopListBaseICF(param,map);
    }
}

package com.qbao.recommend.business.shop.cmp.service.buy.facade;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.shop.cmp.service.buy.factory.ShopBuyServiceFactory;
/**
 * Created by THink on 2016/7/8.
 * 贾红平
 * 封装所有基于购买推荐的相关服务
 */
@Component
public class ShopBuyServiceFacade {

    private ShopBuyServiceFacade(){}

    @Autowired
    private ShopBuyServiceFactory shopBuyServiceFactory;

    public List<JSONObject> getShopListBaseBuyFacade(JSONArray jsonArray,Map<String, Object>param){
        return shopBuyServiceFactory.getShopListBaseBuy(jsonArray,param);
    }
}

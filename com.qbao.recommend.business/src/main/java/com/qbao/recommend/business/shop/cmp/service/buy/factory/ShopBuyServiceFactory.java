package com.qbao.recommend.business.shop.cmp.service.buy.factory;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.shop.cmp.factory.ShopServiceFactory;
import com.qbao.recommend.business.shop.cmp.util.RecommendConstantUtil;

/**
 * Created by THink on 2016/7/7.
 * 贾红平
 * 根据不同的业务类型 选择不同的实现实例
 */

@Component
public class ShopBuyServiceFactory {

    @Autowired
    private ShopServiceFactory shopServiceFactory;

    /**
     *
      * @param map
     * @return
     */
    public List<JSONObject>getShopListBaseBuy(JSONArray jsonArray,Map<String,Object>map){
       return shopServiceFactory.getShopListByService(RecommendConstantUtil.FACADE_SHOP_BUY,jsonArray,map);
    }

}

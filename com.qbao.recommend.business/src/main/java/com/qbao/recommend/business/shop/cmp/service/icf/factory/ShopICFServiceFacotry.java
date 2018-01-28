package com.qbao.recommend.business.shop.cmp.service.icf.factory;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.business.shop.cmp.factory.ShopServiceFactory;

/**
 * Created by THink on 2016/7/8.
 * 贾红平
 */
@Component
public class ShopICFServiceFacotry {

    @Autowired
    private ShopServiceFactory shopServiceFactory;

    /**
     *
     * @param <T>
     * @param jsonArray
     * @param map
     * @return
     */
    public  List<JSONObject> getShopListBaseICF(JSONArray jsonArray,Map<String,Object>map){
        return shopServiceFactory.getShopListByService(RecommendConstantUtil.FACADE_SPU_KNOWLEDGE,jsonArray,map);
    }
}

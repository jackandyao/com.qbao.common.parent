package com.qbao.recommend.business.shop.cmp.service.view.factory;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.qbao.recommend.business.shop.cmp.factory.ShopServiceFactory;
import com.qbao.recommend.business.shop.cmp.util.RecommendConstantUtil;

/**
 * Created by THink on 2016/7/7.    
 * sjzhangjun
 * 基于产品的浏览推荐店铺
 */
@Component
public class ShopViewServiceFacotory {

    @Autowired
    private ShopServiceFactory shopServiceFactory;
    /**
     *
     * @param jsonArray
     * @param param
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> getShopTopBaseView(JSONArray jsonArray, Map<String, Object>param){
        return (List<T>) shopServiceFactory.getShopListByService(RecommendConstantUtil.FACADE_SHOP_VIEW,jsonArray,param);
    }


}

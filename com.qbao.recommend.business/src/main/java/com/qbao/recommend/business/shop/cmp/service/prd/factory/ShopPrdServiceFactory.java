package com.qbao.recommend.business.shop.cmp.service.prd.factory;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.business.shop.cmp.factory.ShopServiceFactory;

/**
 * Created by THink on 2016/7/8.
 * 贾红平
 * 封装个性化的服务工厂实例
 */
@Component
public class ShopPrdServiceFactory {

    @Autowired
    private ShopServiceFactory shopServiceFactory;

    /**
     * 获取个性化的组合结果集
     * @param param
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> List<T>getShopListBasePrd(JSONArray param, Map<String,Object>map){
        return (List<T>) shopServiceFactory.getShopListByService(RecommendConstantUtil.FACADE_SPU_PERSONALIZED,param,map);

    }


}

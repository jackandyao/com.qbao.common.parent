package com.qbao.recommend.business.product.cmp.service.view.factory;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.qbao.recommend.business.product.cmp.factory.SpuServiceFactory;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;

/**
 * Created by THink on 2016/7/7.    
 * 贾红平
 * 基于产品的浏览推荐
 */
@Component
public class SpuViewServiceFacotory {

    @Autowired
    private SpuServiceFactory spuServiceFactory;
    /**
     *
     * @param jsonArray
     * @param param
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> getSpuTopBaseView(JSONArray jsonArray, Map<String, Object>param){
        return (List<T>) spuServiceFactory.getSpuLisByService(RecommendConstantUtil.FACADE_SPU_VIEW,jsonArray,param);
    }


}

package com.qbao.recommend.business.product.cmp.service.personalized.factory;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.qbao.recommend.business.product.cmp.factory.SpuServiceFactory;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;

/**
 * Created by THink on 2016/7/8.
 * 贾红平
 * 封装个性化的服务工厂实例
 */
@Component
public class SpuPersonalizedServiceFactory {

    @Autowired
    private SpuServiceFactory spuServiceFactory;

    /**
     * 获取个性化的组合结果集
     * @param param
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> List<T>getPersonalSpuTop(JSONArray param, Map<String,Object>map){
        return (List<T>) spuServiceFactory.getSpuLisByService(RecommendConstantUtil.FACADE_SPU_PERSONALIZED,param,map);

    }


}

package com.qbao.recommend.business.product.cmp.service.buy.facotory;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.product.cmp.factory.SpuServiceFactory;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;

/**
 * Created by THink on 2016/7/7.
 * 贾红平
 * 根据不同的业务类型 选择不同的实现实例
 */

@Component
public class SpuBuyServiceFactory {

    @Autowired
    private SpuServiceFactory spuServiceFactory;

    /**
     *
      * @param map
     * @return
     */
    public List<JSONObject>getSpuListBaseBuy(JSONArray jsonArray,Map<String,Object>map){
       return spuServiceFactory.getSpuLisByService(RecommendConstantUtil.FACADE_SPU_BUY,jsonArray,map);
    }

}

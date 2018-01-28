package com.qbao.recommend.business.shop.cmp.service.view.facade;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.shop.cmp.service.view.factory.ShopViewServiceFacotory;

/**
 * Created by THink on 2016/7/8.
 * 贾红平
 */
@Component
public class ShopViewServiceFacade {

    @Autowired
    private ShopViewServiceFacotory shopViewServiceFacotory;

    /**
     *
     * @param param
     * @return
     */
    public List<JSONObject> getShopTopBaseViewFacade(JSONArray jsonArray, Map<String, Object>param){
        return shopViewServiceFacotory.getShopTopBaseView(jsonArray,param);
    }
}

package com.qbao.recommend.business.product.cmp.service.view.facade;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.product.cmp.service.view.factory.SpuViewServiceFacotory;

/**
 * Created by THink on 2016/7/8.
 * 贾红平
 */
@Component
public class SpuViewServiceFacade {

    @Autowired
    private SpuViewServiceFacotory spuViewServiceFacotory;

    /**
     *
     * @param param
     * @return
     */
    public List<JSONObject> getSpuTopBaseViewFacade(JSONArray jsonArray, Map<String, Object>param){
        return spuViewServiceFacotory.getSpuTopBaseView(jsonArray,param);
    }
}

package com.qbao.recommend.business.product.cmp.service.knowledge.facade;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.product.cmp.service.knowledge.factory.UserDisServiceFacotry;

/**
 * Created by THink on 2016/7/8.
 * 贾红平
 * 封装用户相似度
 */
@Component
public class UserDisServiceFacade {

    @Autowired
    private UserDisServiceFacotry userDisServiceFacotry;

    public List<JSONObject> getUserDisSpuTopFacade(JSONArray param, Map<String,Object>map){
        return userDisServiceFacotry.getPersonalSpuTop(param,map);
    }
}

package com.qbao.recommend.business.shop.cmp.service.icf;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by THink on 2016/7/7.
 * 贾红平
 * 基于用户之间的相似度
 */
public interface IShopICFService {

    /**
     * 封装请求参数
     * @param jsonObject
     * @return
     */
    public abstract List<String> getTopShopByICF(JSONObject jsonObject);
}

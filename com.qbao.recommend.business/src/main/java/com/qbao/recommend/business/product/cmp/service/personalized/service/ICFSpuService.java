package com.qbao.recommend.business.product.cmp.service.personalized.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by THink on 2016/7/7.
 * 贾红平
 * 基于产品之间的相似度进行
 */
public interface ICFSpuService {

    /**
     * 封装请求参数
     * @param jsonObject
     * @return
     */
    public abstract List<Long> getTopSpuByCF(JSONObject jsonObject);
}

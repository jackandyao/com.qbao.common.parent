package com.qbao.recommend.business.product.cmp.service.personalized.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by THink on 2016/7/7.
 * 贾红平
 * 基于FPG算法进行产品频繁项集统计
 */
public interface IFPGSpuService {

    /**
     * 封装所有请求参数
     * @param jsonObject
     * @return
     */
    public abstract List<Long> getTopSpuByFPG(JSONObject jsonObject);
}

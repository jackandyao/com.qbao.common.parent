package com.qbao.recommend.business.shop.cmp.service.prd;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by THink on 2016/7/7.
 * 贾红平
 * 推荐个性化产品所在店铺
 */
public interface IShopPrdService {

    /**
     * 封装请求参数
     * @param jsonObject
     * @return
     */
    public abstract List<String> getTopShopByPrd(JSONObject jsonObject);
}

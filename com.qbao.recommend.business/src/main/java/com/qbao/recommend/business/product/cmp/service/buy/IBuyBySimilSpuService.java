package com.qbao.recommend.business.product.cmp.service.buy;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by THink on 2016/7/7.
 * 贾红平
 * 1 获取当前用户已经购买的产品
 * 2 取该产品销量最多的top
 * 3 针对top取相似商品
 */
public interface IBuyBySimilSpuService {


    /**
     * 封装请求参数
     * @param jsonObject
     * @return
     */
    public abstract List<Long> getHotBuySimilTopSpu(JSONObject jsonObject);
}

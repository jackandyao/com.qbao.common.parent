package com.qbao.recommend.business.shop.cmp.service.buy;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by THink on 2016/7/7.
 * 贾红平
 * 获取销量最高的top个商铺,根据销量排序
 */
public interface IShopBuyService {


    /**
     * 封装请求参数
     * @param jsonObject
     * @return
     */
    public abstract List<String> getTopShopByBuy(JSONObject jsonObject);
}

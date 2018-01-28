package com.qbao.recommend.business.product.cmp.service.buy;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by THink on 2016/7/7.
 * 贾红平
 * 获取销量最高的top个商品,根据销量排序
 */
public interface IHotBuySpuService {


    /**
     * 封装请求参数
     * @param jsonObject
     * @return
     */
    public abstract List<Long> getHotBuyTopSpu(JSONObject jsonObject);
}

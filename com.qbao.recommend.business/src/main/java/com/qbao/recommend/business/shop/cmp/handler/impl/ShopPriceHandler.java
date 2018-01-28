package com.qbao.recommend.business.shop.cmp.handler.impl;

import org.springframework.stereotype.Component;

import com.qbao.recommend.business.shop.cmp.handler.RecommendHandler;
import com.qbao.recommend.business.shop.cmp.util.RecommendConstantUtil;


/**
 * Created by THink on 2016/7/8.
 * 贾红平
 * 价格处理器:价格阶段筛选
 */
@Component(value=RecommendConstantUtil.ANNO_SHOP_PRICE_HANDLE)
public class ShopPriceHandler implements RecommendHandler {

    /**
     * 执行价格过滤
     * 1 过滤符合和条件的价格产品 刷子产品和价格过高的产品
     * @param t
     * @param <T>
     */
    @Override
    public <T> void executeHandler(T t) {

    }
}

package com.qbao.recommend.business.shop.cmp.handler.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qbao.recommend.business.shop.cmp.handler.chain.ShopHandlerChain;

/**
 * Created by THink on 2016/7/8.
 * 贾红平
 */
@Component
public class ShopHandlerFactory {

    @Autowired
    ShopHandlerChain shopHandlerChain;

    /**
     * 执行处理器链
     * @param param
     * @param t
     */
    public <T> void executeHandleChain(String param,T t){
      shopHandlerChain.executeHandler(param, t);
    }
}

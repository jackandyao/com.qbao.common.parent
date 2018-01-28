package com.qbao.recommend.business.product.cmp.handler.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.product.cmp.handler.chain.SpuHandlerChain;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;

/**
 * Created by THink on 2016/7/8.
 * 贾红平
 */
@Component
public class SpuHandlerFactory {

    @Autowired
    SpuHandlerChain spuHandlerChain;

    /**
     * 执行处理器链
     * @param param
     * @param t
     */
    public <T> void executeHandleChain(String param,T t){
      spuHandlerChain.executeHandler(param, t);
    }
}

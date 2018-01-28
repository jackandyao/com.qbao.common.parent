package com.qbao.recommend.business.shop.cmp.handler.chain;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.qbao.recommend.business.shop.cmp.handler.RecommendHandler;
import com.qbao.recommend.business.shop.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;

/**
 * Created by THink on 2016/7/7.
 * 贾红平
 * 封装处理器的链子
 */
@Component
public class ShopHandlerChain {

    Logger spuHandlerChainLogger = LoggerManagerUtil.getLogger(LogNameEnum.spu_facade, Level.WARN);

    @Resource(name = RecommendConstantUtil.ANNO_SHOP_DUPLICATE_HANDLE)
    private RecommendHandler shopDuplicateHandler;

    @Resource(name = RecommendConstantUtil.ANNO_SHOP_STATUS_HANDLE)
    private RecommendHandler shopStatusHandler;

    @Resource(name = RecommendConstantUtil.ANNO_SHOP_PRICE_HANDLE)
    private RecommendHandler shopPriceHandler;

    @Resource(name = RecommendConstantUtil.ANNO_SHOP_FILTERBUY_HANDLE)
    private RecommendHandler shopBuyFilterHandler;
    
    /**
     * 执行处理器
     * 
     * @param param
     * @param t
     * @param <T>
     */
    public <T> void executeHandler(String param, T t) {
        if (StringUtils.isNotEmpty(param)) {
            String[] params = param.split(",");
            for (String type : params) {

                // 处理产品下架
                if (type.equals(RecommendConstantUtil.STATUS_HANDLER)) {
                    spuHandlerChainLogger.warn("处理下架商品！");
                    shopStatusHandler.executeHandler(t);
                }
                // 处理产品去重复
                if (type.equals(RecommendConstantUtil.DUPLICATE_HANDLER)) {
                    spuHandlerChainLogger.warn("处理重复商品！");
                    shopDuplicateHandler.executeHandler(t);
                }
                // 处理价格产品
                if (type.equals(RecommendConstantUtil.PRICE_HANDLER)) {
                    spuHandlerChainLogger.warn("处理商品价格！");
                    shopPriceHandler.executeHandler(t);
                }

                // 过滤已购买的商品
                if (type.equals(RecommendConstantUtil.BUYFILTER_HANDLER)) {
                    spuHandlerChainLogger.warn("过滤已购买的商品！");
                    shopBuyFilterHandler.executeHandler(t);
                }
                
            }
        }

    }

}

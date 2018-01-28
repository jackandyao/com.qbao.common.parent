package com.qbao.recommend.business.product.cmp.handler.chain;

import com.qbao.recommend.business.product.cmp.handler.RecommendHandler;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by THink on 2016/7/7.
 * 贾红平
 * 封装处理器的链子
 */
@Component
public class SpuHandlerChain {

    Logger spuHandlerChainLogger = LoggerManagerUtil.getLogger(LogNameEnum.spu_facade, Level.WARN);

    @Resource(name = RecommendConstantUtil.ANNO_SPU_DUPLICATE_HANDLE)
    private RecommendHandler spuDuplicateHandler;

    @Resource(name = RecommendConstantUtil.ANNO_SPU_STATUS_HANDLE)
    private RecommendHandler spuStatusHandler;

    @Resource(name = RecommendConstantUtil.ANNO_SPU_PRICE_HANDLE)
    private RecommendHandler spuPriceHandler;

   @Resource(name = RecommendConstantUtil.ANNO_SPU_FILTERBUY_HANDLE)
    private RecommendHandler spuBuyFilterHandler;

//    @Resource(name = RecommendConstantUtil.ANNO_SPU_EXCLUDE_HANDLER)
//    private RecommendHandler spuExcludeHandler;

    @Resource(name = RecommendConstantUtil.ANNO_SPU_SHUFF_HANDLE)
    private RecommendHandler spuShuffHandler;

    /**
     * 执行处理器
     * 
     * @param param
     * @param t
     * @param <T>
     */
    public <T> void executeHandler(String param, T t) {
        if (param != null) {
            String[] params = param.split(",");
            for (String type : params) {

                // 处理产品下架
                if (type.equals(RecommendConstantUtil.STATUS_HANDLER)) {
                    spuHandlerChainLogger.warn("处理下架商品！");
                    spuStatusHandler.executeHandler(t);
                }
                // 处理产品去重复
                if (type.equals(RecommendConstantUtil.DUPLICATE_HANDLER)) {
                    spuHandlerChainLogger.warn("处理重复商品！");
                    spuDuplicateHandler.executeHandler(t);
                }
                // 处理价格产品
                if (type.equals(RecommendConstantUtil.PRICE_HANDLER)) {
                    spuHandlerChainLogger.warn("处理商品价格！");
                    spuPriceHandler.executeHandler(t);
                }

                // 过滤已购买的商品
                if (type.equals(RecommendConstantUtil.BUYFILTER_HANDLER)) {
                    spuHandlerChainLogger.warn("过滤已购买的商品！");
                    spuBuyFilterHandler.executeHandler(t);
                }

//                // 过滤用户不喜欢的商品
//                if (type.equals(RecommendConstantUtil.EXCLUDE_HANDLER)) {
//                    spuHandlerChainLogger.warn("过滤用户不喜欢的商品！");
//                    spuExcludeHandler.executeHandler(t);
//                }

                //统一的混排handler
                if(type.equals(RecommendConstantUtil.SHUFFLE_HANDLER)){
                    spuHandlerChainLogger.warn("混排处理！");
                    spuShuffHandler.executeHandler(t);
                    
                }
            }
        }

    }

}

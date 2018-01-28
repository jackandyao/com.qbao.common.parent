package com.qbao.recommend.business.product.cmp.strategy.context;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qbao.recommend.business.product.cmp.strategy.IDataCompletionStrategy;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;

/**
 *  补全策略上下文
     * @author 贾红平
     *
     * $LastChangedDate: 2016-09-18 19:24:27 +0800 (Sun, 18 Sep 2016) $
     * $LastChangedRevision: 1047 $
     * $LastChangedBy: shuaizhihu $
 */
@Component
public class DataCompletionStrategyContext {
    
    Logger dataCompletionStrategyContextLogger = LoggerManagerUtil.getLogger(LogNameEnum.spu_facade, Level.WARN);
    
    @Resource(name=RecommendConstantUtil.ANNO_HOT_BUY_STRATEGY)
    private IDataCompletionStrategy hotSpuDataCompletionStrategy;
    @Resource(name=RecommendConstantUtil.ANNO_HOT_VIEW_STRATEGY)
    private IDataCompletionStrategy viewSpuDataCompletionStrategy;
    
    /**
     * 封装数据补全策略
     * @param oldList 原始数据集
     * @param type    补全策略类型标识
     */
    public void executeDataCompletion(List<Long>oldList,String type,int num){
        int realSum=oldList.size();
        if (realSum==num) {
            dataCompletionStrategyContextLogger.warn("num:"+num+"   计算出用户的推荐数据和用户实际需要推荐的数据是一致的,无需使用数据补全策略");
        }
        if (realSum<num) {
            dataCompletionStrategyContextLogger.warn("num:"+num+"   计算出用户的推荐数据小于用户实际需要推荐的数据是不一致的,准备使用数据补全策略");
            if (type.equals(RecommendConstantUtil.HOT_DATA_COMPLETION)) {
                dataCompletionStrategyContextLogger.warn("采用热卖数据补全  需补充："+(num-realSum)+"条");
                hotSpuDataCompletionStrategy.executeDataCompletion(oldList, num-realSum);
           }
           if (type.equals(RecommendConstantUtil.VIEW_DATA_COMPLETION)) {
               dataCompletionStrategyContextLogger.warn("采用浏览数据补全  需补充："+(num-realSum)+"条");
               viewSpuDataCompletionStrategy.executeDataCompletion(oldList, num-realSum);
           }
        }
        
        
       
    }
}

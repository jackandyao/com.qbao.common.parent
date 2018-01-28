package com.qbao.recommend.business.product.cmp.strategy.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.qbao.recommend.business.product.cmp.common.CommonSpuService;
import com.qbao.recommend.business.product.cmp.strategy.IDataCompletionStrategy;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;
/**
 *   通过热卖补充数据
     * @author 贾红平
     * $LastChangedDate: 2016-11-14 15:30:58 +0800 (Mon, 14 Nov 2016) $
     * $LastChangedRevision: 1393 $
     * $LastChangedBy: jiahongping $
 */
@Component(value=RecommendConstantUtil.ANNO_HOT_BUY_STRATEGY)
public class HotSpuDataCompletionStrategy extends CommonSpuService implements IDataCompletionStrategy{
    
  
    @Override
    public void executeDataCompletion(List<Long> oldList,int num) {
        //初始化热卖数据
        initHotSpuList();
        //热卖数据扩大化,减少重复查询验证策略
        for(int i=1;i<num*2;i++){
            oldList.add(hotSpuList.get(i));
        }
        servericeLogger.info("执行数据补全策略-BUYBUY数据完毕:"+StringUtils.join(oldList,","));

        
    }
    
    
    

}

/**
 * 
 */
package com.qbao.recommend.business.product.cmp.strategy.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qbao.recommend.business.product.cmp.strategy.context.DataCompletionStrategyContext;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate$
 * $LastChangedRevision$
 * $LastChangedBy$
 */
@Component
public class SpuStrategyFactory {
    
    @Autowired 
    DataCompletionStrategyContext dataCompletionStrategyContext;
    
    /**
     * 执行补全策略
     * @param param
     * @param list
     * @param num
     */
    public void executeStrategy(String param,List<Long> list,int num){
        String[] types = param.split(",");
        for(String type:types){
            dataCompletionStrategyContext.executeDataCompletion(list, type, num);
        }
    }
}

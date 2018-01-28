package com.qbao.recommend.business.product.cmp.strategy.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qbao.recommend.business.product.cmp.service.view.impl.HotClickSpuService;
import com.qbao.recommend.business.product.cmp.strategy.IDataCompletionStrategy;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.respositoy.mysql.service.IHotSpuService;

@Component(value=RecommendConstantUtil.ANNO_HOT_VIEW_STRATEGY)
public class ViewSpuDataCompletionStrategy implements IDataCompletionStrategy{
    @Autowired
    IHotSpuService hotSpuService;
    
    @Override
    public void executeDataCompletion(List<Long> oldList,int num) {
       List<Long> sList =  hotSpuService.getAllSpuIdFromHotSpuSearch();
       if(sList.size()<num){
           oldList.addAll(sList);
       }else{
           oldList.addAll(sList.subList(0, num));
       }
       System.out.println("执行数据补全策略-HOTVIEW数据完毕:"+StringUtils.join(oldList,","));
    }
    
}

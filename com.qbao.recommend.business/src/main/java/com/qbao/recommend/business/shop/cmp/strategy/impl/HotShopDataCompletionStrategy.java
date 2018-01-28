package com.qbao.recommend.business.shop.cmp.strategy.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qbao.recommend.business.shop.cmp.strategy.IDataCompletionStrategy;
import com.qbao.recommend.business.shop.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.respositoy.mysql.model.RecommendShop;
import com.qbao.recommend.respositoy.mysql.service.IRecommendShopService;

@Component(value=RecommendConstantUtil.ANNO_HOT_SHOP_STRATEGY)
public class HotShopDataCompletionStrategy implements IDataCompletionStrategy{
    @Autowired
    IRecommendShopService recommendShopService;
    
    @Override
    public void executeDataCompletion(List<String> oldList,int num) {
       RecommendShop recshop =  recommendShopService.findByUserId(0);
       List<String> sList = recshop.getShopList();
       Iterator<String> it = sList.iterator();
       while(it.hasNext()) {
    	   String shop = it.next();
    	   int index = shop.indexOf("/");
    	   if(index>=0) {
    		   shop = shop.substring(++index);
    	   }
       }
       if(sList.size()<num){
           oldList.addAll(sList);
       }else{
           oldList.addAll(sList.subList(0, num));
       }
       System.out.println("执行数据补全策略-HOTVIEW数据完毕:"+StringUtils.join(oldList,","));
    }
    
}

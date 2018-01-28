package com.qbao.recommend.business.shop.cmp.service.buy.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.qbao.recommend.alarm.facade.AlaramServiceFacotryFacade;
import com.qbao.recommend.alarm.util.MessageConstanUtil;
import com.qbao.recommend.business.shop.cmp.common.CommonShopService;
import com.qbao.recommend.business.shop.cmp.handler.factory.ShopHandlerFactory;
import com.qbao.recommend.business.shop.cmp.service.buy.IShopBuyService;
import com.qbao.recommend.business.shop.cmp.strategy.factory.ShopStrategyFactory;
import com.qbao.recommend.business.shop.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.respositoy.mysql.model.RecommendShop;
import com.qbao.recommend.respositoy.mysql.service.IRecShopBuyService;

@Service
public class ShopBuyService extends CommonShopService implements IShopBuyService{
   
    @Autowired
    IRecShopBuyService recShopBuyService;
    
    @Autowired
    private ShopHandlerFactory shopHandlerFactory;
    
    @Autowired
    private ShopStrategyFactory shopStrategyFactory;
    
	@Override
    public List<String> getTopShopByBuy(JSONObject jsonObject) {
        List<String> resultList = Lists.newArrayList();
        
        jsonObject.put(MessageConstanUtil.ALARM_CLASS_NAME, jsonObject.get(MessageConstanUtil.ALARM_CLASS_NAME) + ":" + this.getClass().getSimpleName());

        int num = 0;
        if (jsonObject.containsKey(RecommendConstantUtil.SHOW_NUM)) {
            num = jsonObject.getIntValue(RecommendConstantUtil.SHOW_NUM);
        } 
        
        long userId = 0;
        if (jsonObject.containsKey(RecommendConstantUtil.USER_ID)) {
            userId = jsonObject.getLongValue(RecommendConstantUtil.USER_ID);
        }
        try{
            RecommendShop recommentShop = recShopBuyService.findByUserId(userId);
            if(recommentShop != null) resultList = recommentShop.getShopList();
        }catch(Exception e){
            this.servericeLogger.warn("ShopBuyService.getTopShopByBuy error! userId:" + userId);
            jsonObject.put(MessageConstanUtil.ALARM_EXCEPTION, e);
            jsonObject.put(MessageConstanUtil.ALARM_TYPE, MessageConstanUtil.MAIL_ERROR);
            jsonObject.put(MessageConstanUtil.ALARM_USERID, userId);
            AlaramServiceFacotryFacade.sendAlaramMessageByMail(jsonObject);
        }
        // 获取处理方式
        String handlers = "";
        if (jsonObject.containsKey(RecommendConstantUtil.HANDLER)) {
            handlers = jsonObject.getString(RecommendConstantUtil.HANDLER);
        }
        // 获取补全策略
        String completions = "";
        if (jsonObject.containsKey(RecommendConstantUtil.COMPLETION)) {
            completions = jsonObject.getString(RecommendConstantUtil.COMPLETION);
        }
        if (resultList.size() < num&&!StringUtils.isEmpty(completions)) {
            this.servericeLogger.warn("BuySpuByDirectoryService.getBuyDirectoryTopSpu The data is not enough! request_num:" + num + " reality_num:" + resultList.size() + "  Completion strategy:" + completions);
            Exception e = new Exception("BuySpuByDirectoryService.getBuyDirectoryTopSpu The data is not enough! request_num:" + num + " reality_num:" + resultList.size() + "  Completion strategy:" + completions);
            jsonObject.put(MessageConstanUtil.ALARM_EXCEPTION, e);
            jsonObject.put(MessageConstanUtil.ALARM_TYPE, MessageConstanUtil.MAIL_ERROR);
            jsonObject.put(MessageConstanUtil.ALARM_USERID, userId);
            AlaramServiceFacotryFacade.sendAlaramMessageByMail(jsonObject);
            shopStrategyFactory.executeStrategy(completions, resultList, num);
        }
        
        
        shopHandlerFactory.executeHandleChain(handlers, resultList);

        return super.splitShopList(resultList, num);

    }

}

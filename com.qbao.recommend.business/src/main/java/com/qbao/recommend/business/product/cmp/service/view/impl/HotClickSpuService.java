package com.qbao.recommend.business.product.cmp.service.view.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.alarm.facade.AlaramServiceFacotryFacade;
import com.qbao.recommend.alarm.util.MessageConstanUtil;
import com.qbao.recommend.business.product.cmp.common.CommonSpuService;
import com.qbao.recommend.business.product.cmp.handler.factory.SpuHandlerFactory;
import com.qbao.recommend.business.product.cmp.service.view.IHotClickSpuService;
import com.qbao.recommend.business.product.cmp.strategy.factory.SpuStrategyFactory;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.respositoy.mysql.service.IHotSpuService;

/**
 * Created by THink on 2016/7/8.
 * 贾红平
 * 浏览点击最高的商品
 */
@Service
public class HotClickSpuService extends CommonSpuService implements IHotClickSpuService {
    
    @Autowired
    private SpuHandlerFactory spuHandlerFactory;
    
    @Autowired
    private SpuStrategyFactory spuStrategyFactory;
    
    @Autowired
    IHotSpuService hotSpuService;
    
    /**
     *
     * @param jsonObject 返回的数量
     * @return
     */
    @Override
    public List<Long> getHotViewTopSpu(JSONObject jsonObject) {
        List<Long> resultList = new ArrayList<Long> ();
        jsonObject.put(MessageConstanUtil.ALARM_CLASS_NAME, jsonObject.get(MessageConstanUtil.ALARM_CLASS_NAME) + ":" + this.getClass().getSimpleName());
        
        int num =0;
        if(jsonObject.containsKey(RecommendConstantUtil.SHOW_NUM)){
            num = jsonObject.getIntValue(RecommendConstantUtil.SHOW_NUM);
        }
        
        long userId = 0;
        if(jsonObject.containsKey(RecommendConstantUtil.USER_ID)){
            userId = jsonObject.getLongValue(RecommendConstantUtil.USER_ID);
        }
        
        try{
            List<Long> reslutList = hotSpuService.getAllSpuIdFromHotSpuSearch();
        }catch(Exception e){
            this.servericeLogger.warn("HotClickSpuService.getHotViewTopSpu error! ");
            jsonObject.put(MessageConstanUtil.ALARM_EXCEPTION, e);
            jsonObject.put(MessageConstanUtil.ALARM_TYPE, MessageConstanUtil.MAIL_ERROR);
            AlaramServiceFacotryFacade.sendAlaramMessageByMail(jsonObject);
        }
        
        //获取处理方式
        String handlers = "";
        if(jsonObject.containsKey(RecommendConstantUtil.HANDLER)){
            handlers = jsonObject.getString(RecommendConstantUtil.HANDLER);
        }
        //获取补全策略
        String completions = "";
        if(jsonObject.containsKey(RecommendConstantUtil.COMPLETION)){
            completions = jsonObject.getString(RecommendConstantUtil.COMPLETION);
        }
        
        if (resultList.size() < num && !StringUtils.isEmpty(completions)) {
            this.servericeLogger.warn("HotClickSpuService.getHotViewTopSpu The data is not enough! request_num:" + num + " reality_num:" + resultList.size() + "  Completion strategy:" + completions);
            Exception e = new Exception("HotClickSpuService.getHotViewTopSpu The data is not enough! request_num:" + num + " reality_num:" + resultList.size() + "  Completion strategy:" + completions);
            jsonObject.put(MessageConstanUtil.ALARM_EXCEPTION, e);
            jsonObject.put(MessageConstanUtil.ALARM_TYPE, MessageConstanUtil.MAIL_ERROR);
            AlaramServiceFacotryFacade.sendAlaramMessageByMail(jsonObject);
            spuStrategyFactory.executeStrategy(completions, resultList, num);
        }
        
        spuHandlerFactory.executeHandleChain(handlers,resultList);
        
        return super.splitSpuList(resultList,num);

    }


}

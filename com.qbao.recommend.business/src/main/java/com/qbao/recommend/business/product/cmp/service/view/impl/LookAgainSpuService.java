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
import com.qbao.recommend.business.product.cmp.service.view.ILookAgainSpuService;
import com.qbao.recommend.business.product.cmp.strategy.factory.SpuStrategyFactory;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.respositoy.mysql.model.RecommendLookItems;
import com.qbao.recommend.respositoy.mysql.service.IRecLookAgainService;
@Service
public class LookAgainSpuService extends CommonSpuService implements ILookAgainSpuService {
   
    @Autowired
    IRecLookAgainService recLookAgainService;
    
    @Autowired
    private SpuHandlerFactory spuHandlerFactory;
    
    @Autowired
    private SpuStrategyFactory spuStrategyFactory;
    
    
 
	@Override
	public List<Long> getLookAgainTopSpu(JSONObject jsonObject) {
	    List<Long> resultList = new ArrayList<Long> ();
        jsonObject.put(MessageConstanUtil.ALARM_CLASS_NAME, jsonObject.get(MessageConstanUtil.ALARM_CLASS_NAME) + ":" + this.getClass().getSimpleName());
        
        int num =0;
        if(jsonObject.containsKey(RecommendConstantUtil.SHOW_NUM)){
            num = jsonObject.getIntValue(RecommendConstantUtil.SHOW_NUM);
        }
        
        long spuId = 0;
        if(jsonObject.containsKey(RecommendConstantUtil.SPU_ID)){
            spuId = jsonObject.getLongValue(RecommendConstantUtil.SPU_ID);
        }
        
        long userId = 0;
        if(jsonObject.containsKey(RecommendConstantUtil.USER_ID)){
            userId = jsonObject.getLongValue(RecommendConstantUtil.USER_ID);
        }
        
        try{
            RecommendLookItems items = recLookAgainService.findByIdAndType(spuId, 0);
            resultList = items.getSpuIdList();
        }catch(Exception e){
            this.servericeLogger.warn("LookAgainSpuService.getLookAgainTopSpu  error! spuId:" + spuId);
            jsonObject.put(MessageConstanUtil.ALARM_EXCEPTION, e);
            jsonObject.put(MessageConstanUtil.ALARM_TYPE, MessageConstanUtil.MAIL_ERROR);
            jsonObject.put(MessageConstanUtil.ALARM_SPU_ID, spuId);
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
            this.servericeLogger.warn("LookAgainSpuService.getLookAgainTopSpu The data is not enough! request_num:" + num + " reality_num:" + resultList.size() + "  Completion strategy:" + completions);
            Exception e = new Exception("LookAgainSpuService.getLookAgainTopSpu The data is not enough! request_num:" + num + " reality_num:" + resultList.size() + "  Completion strategy:" + completions);
            jsonObject.put(MessageConstanUtil.ALARM_EXCEPTION, e);
            jsonObject.put(MessageConstanUtil.ALARM_TYPE, MessageConstanUtil.MAIL_ERROR);
            AlaramServiceFacotryFacade.sendAlaramMessageByMail(jsonObject);
            spuStrategyFactory.executeStrategy(completions, resultList, num);
        }
        
        spuHandlerFactory.executeHandleChain(handlers,resultList);
        
        return super.splitSpuList(resultList,num);
        
	}
	
}

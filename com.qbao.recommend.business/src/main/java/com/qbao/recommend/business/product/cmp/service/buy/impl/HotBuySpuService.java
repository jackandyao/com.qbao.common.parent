package com.qbao.recommend.business.product.cmp.service.buy.impl;

import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.alarm.facade.AlaramServiceFacotryFacade;
import com.qbao.recommend.alarm.util.MessageConstanUtil;
import com.qbao.recommend.business.product.cmp.common.CommonSpuService;
import com.qbao.recommend.business.product.cmp.handler.factory.SpuHandlerFactory;
import com.qbao.recommend.business.product.cmp.service.buy.IHotBuySpuService;
import com.qbao.recommend.business.product.cmp.strategy.factory.SpuStrategyFactory;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.respositoy.mysql.model.RecommendItems;
import com.qbao.recommend.respositoy.mysql.service.IRecGWJSService;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by THink on 2016/7/13.
 */
@Service
public class HotBuySpuService extends CommonSpuService implements IHotBuySpuService {
    
    @Autowired
    private SpuHandlerFactory spuHandlerFactory;
    
    @Autowired
    private SpuStrategyFactory spuStrategyFactory;
    
  
    
    @Autowired
    private IRecGWJSService recGWJSService;
    
    @Override
    public List<Long> getHotBuyTopSpu(JSONObject jsonObject) {
        jsonObject.put(MessageConstanUtil.ALARM_CLASS_NAME, jsonObject.get(MessageConstanUtil.ALARM_CLASS_NAME) + ":" + this.getClass().getSimpleName());
        List<Long> resultList =new ArrayList<Long>();
        int num =0;
        if(jsonObject.containsKey(RecommendConstantUtil.SHOW_NUM)){
            num = jsonObject.getIntValue(RecommendConstantUtil.SHOW_NUM);
        }
        long userId = 0;
        if(jsonObject.containsKey(RecommendConstantUtil.USER_ID)){
            userId = jsonObject.getLongValue(RecommendConstantUtil.USER_ID);
        }
        /**
         * is_similar is_directory  暂不考虑
         */
        try{
            this.servericeLogger.warn("try to get RecommendItems by user id =[0]");
            RecommendItems recommentItems = recGWJSService.findByUserId(0);
            this.servericeLogger.warn("get to get RecommendItems ="+recommentItems+" by user id =[0]");
            resultList = this.getSpuIdList(recommentItems);
        }catch(Exception e){
            this.servericeLogger.warn("HotBuySpuService.getHotBuyTopSpu error! ");
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
        
        if (resultList.size() < num&&!StringUtils.isEmpty(completions)) {
            this.servericeLogger.warn("HotBuySpuService.getHotBuyTopSpu The data is not enough! request_num:" + num + " reality_num:" + resultList.size() + "  Completion strategy:" + completions);
            Exception e = new Exception("HotBuySpuService.getHotBuyTopSpu The data is not enough! request_num:" + num + " reality_num:" + resultList.size() + "  Completion strategy:" + completions);
            jsonObject.put(MessageConstanUtil.ALARM_EXCEPTION, e);
            jsonObject.put(MessageConstanUtil.ALARM_TYPE, MessageConstanUtil.MAIL_ERROR);
            AlaramServiceFacotryFacade.sendAlaramMessageByMail(jsonObject);
            spuStrategyFactory.executeStrategy(completions, resultList, num);
        }
        
        spuHandlerFactory.executeHandleChain(handlers,resultList);
        
        return super.splitSpuList(resultList,num);
    }
    
    
    public  List<Long> getSpuIdList(RecommendItems items) {
        // 热卖数据
        this.servericeLogger.warn("getSpuIdList  items.spuIds:"+items.getSpuIds());
        List<Long> hotSaleList = new ArrayList<Long>();
        String spuIds = StringUtils.trimToEmpty(StringUtils.substringBetween(items.getSpuIds(), "{", "}"));
        String[] s1 = spuIds.split(",");
        for (int i = 0; i < s1.length; i++) {
            String[] str = StringUtils.trimToEmpty(s1[i]).split(":");
            String id = str[0].substring(1, str[0].length() - 1);
            long spuId = NumberUtils.toLong(id,0);
            // 如果是热卖的数据就直接向热卖的list中添加，否则根据打分向个性化（大于1分）和相异度（小于1分）list中添加
            if (items.getUserId() == 0) {
                hotSaleList.add(spuId);
            } 
            
           
        }

        return hotSaleList;
    }
    
    
    public static void main(String [] args){
       String json="{\"4182550\":\"\",\"4182362\":\"\",\"4189591\":\"\",\"2615714\":\"\",\"4116489\":\"\",\"4134726\":\"\",\"992072\":\"\",\"4182911\":\"\",\"1776413\":\"\",\"4182555\":\"\",\"4193299\":\"\",\"4187812\":\"\",\"2518341\":\"\",\"4182540\":\"\",\"1050511\":\"\",\"4182544\":\"\",\"4112966\":\"\",\"4182948\":\"\",\"4164857\":\"\",\"4182529\":\"\",\"4182354\":\"\",\"1261125\":\"\",\"2596268\":\"\",\"4182952\":\"\",\"4148157\":\"\",\"1743896\":\"\",\"2533811\":\"\",\"4116542\":\"\",\"4153483\":\"\",\"4172363\":\"\",\"4182892\":\"\",\"4156055\":\"\",\"834696\":\"\",\"4190589\":\"\",\"4182551\":\"\",\"960182\":\"\",\"2652980\":\"\",\"4192318\":\"\",\"4164649\":\"\",\"1202798\":\"\",\"4189594\":\"\",\"4183848\":\"\",\"4183755\":\"\",\"4172012\":\"\",\"4171887\":\"\",\"1714053\":\"\",\"4184870\":\"\",\"4182530\":\"\",\"4180420\":\"\",\"2653921\":\"\"}";
       List<Long> hotSaleList = new ArrayList<Long>();
       String spuIds = StringUtils.trimToEmpty(StringUtils.substringBetween(json, "{", "}"));
       String[] s1 = spuIds.split(",");
       for (int i = 0; i < s1.length; i++) {
           String[] str = StringUtils.trimToEmpty(s1[i]).split(":");
           String id = str[0].substring(1, str[0].length() - 1);
           long spuId = NumberUtils.toLong(id,0);
           hotSaleList.add(spuId);
       }
       for(Long id:hotSaleList){
           System.out.println(id);
       }

    }
}

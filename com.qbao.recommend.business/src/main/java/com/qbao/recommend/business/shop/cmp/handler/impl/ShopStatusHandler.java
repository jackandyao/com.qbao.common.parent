package com.qbao.recommend.business.shop.cmp.handler.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.qbao.recommend.business.shop.cmp.common.CommonShopService;
import com.qbao.recommend.business.shop.cmp.handler.RecommendHandler;
import com.qbao.recommend.business.shop.cmp.util.RecommendConstantUtil;

/**
 * Created by THink on 2016/7/8.
 * 贾红平
 * 验证产品是否下架
 */
@Component(value=RecommendConstantUtil.ANNO_SHOP_STATUS_HANDLE)
public class ShopStatusHandler extends CommonShopService implements RecommendHandler {
    @SuppressWarnings("unchecked")
    @Override
    public <T> void executeHandler(T t) {
         try {
            
            List<Object> list=(List<Object>) t;
             Object obj=list.get(0);
             if (obj instanceof String) {
                handleLogger.info("准备进行对集合为String类型的商铺数据集进行上下架状态验证");
                handleLongType((List<String>)t);
             }
             if(obj instanceof JSONObject){
                 handleLogger.info("准备进行对集合为JSON类型的产品数据集进行上下架状态验证");
                 handleJSONType((List<JSONObject>)t);
             }
        } catch (Exception e) {
             
        } 
    }
    
    /**
     * 处理Long类型的数据取重复
     * @param list
     */
    private void handleLongType(List<String>list){
        if (list!=null) {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()){
            	String shopRec = iterator.next();
            	if(StringUtils.isEmpty(shopRec)) {
            		iterator.remove();
            		continue;
            	}
            	String[] shopRecArray = shopRec.split(":");
            	if(shopRecArray.length<3) {
            		iterator.remove();
            		continue;
            	}
            	List<String> spuIdList = Lists.newArrayList();
            	String[] spuIds = shopRecArray[2].split(",");
                for(String spuId : spuIds){
	                if(!isOnSale(Long.valueOf(spuId))){
	                    handleLogger.info("商铺ID:"+shopRecArray[0]+"的产品ID:"+spuId+"的状态是下架,已经被成功过滤掉");
	                } else {
	                	spuIdList.add(spuId);
	                }
                }
                if(spuIdList.size()<3) {
                	iterator.remove();
                	continue;
                }
                shopRecArray[2]=StringUtils.join(spuIdList, ",");
                shopRec = StringUtils.join(shopRecArray, ":");
            }
        }
    }
    
    /**
     * 处理JSON类型的数据取重复
     * @param jlist
     */
    private void handleJSONType(List<JSONObject>jlist){
        if (jlist!=null) {
            Iterator<JSONObject> iterator = jlist.iterator();
            while (iterator.hasNext()){
                JSONObject json=(JSONObject) JSON.parse(iterator.next().toString());
                String shopRec=json.getString(RecommendConstantUtil.COM_SHOP);
                

            	if(StringUtils.isEmpty(shopRec)) {
            		iterator.remove();
            		continue;
            	}
            	String[] shopRecArray = shopRec.split(":");
            	if(shopRecArray.length<3) {
            		iterator.remove();
            		continue;
            	}
            	List<String> spuIdList = Lists.newArrayList();
            	String[] spuIds = shopRecArray[2].split(",");
                for(String spuId : spuIds){
	                if(!isOnSale(Long.valueOf(spuId))){
	                    handleLogger.info("商铺ID:"+shopRecArray[0]+"的产品ID:"+spuId+"的状态是下架,已经被成功过滤掉");
	                } else {
	                	spuIdList.add(spuId);
	                }
                }
                if(spuIdList.size()<3) {
                	iterator.remove();
                	continue;
                }
                shopRecArray[2]=StringUtils.join(spuIdList, ",");
                shopRec = StringUtils.join(shopRecArray, ":");
                json.put(RecommendConstantUtil.COM_SHOP, shopRec);
            
            }
        }
    }
}

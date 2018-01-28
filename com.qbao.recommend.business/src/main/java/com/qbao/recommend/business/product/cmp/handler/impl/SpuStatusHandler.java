package com.qbao.recommend.business.product.cmp.handler.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.product.cmp.common.CommonSpuService;
import com.qbao.recommend.business.product.cmp.handler.RecommendHandler;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;

/**
 * Created by THink on 2016/7/8.
 * 贾红平
 * 验证产品是否下架
 */
@Component(value=RecommendConstantUtil.ANNO_SPU_STATUS_HANDLE)
public class SpuStatusHandler extends CommonSpuService implements RecommendHandler {
    @SuppressWarnings("unchecked")
    @Override
    public <T> void executeHandler(T t) {
         try {
            
            List<Object> list=(List<Object>) t;
             Object obj=list.get(0);
             if (obj instanceof Long) {
                handleLogger.info("准备进行对集合为Long类型的产品数据集进行上下架状态验证");
                handleLongType((List<Long>)t);
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
    private void handleLongType(List<Long>list){
        if (list!=null) {
            Iterator<Long> iterator = list.iterator();
            while (iterator.hasNext()){
                Long spuId=Long.valueOf(iterator.next().toString());
                if(!isOnSale(spuId)){
                    handleLogger.info("产品ID:"+spuId+"的状态是下架");
                    iterator.remove();
                    handleLogger.info("产品ID:"+spuId+"已经被成功过滤掉");
                }
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
                Long spuId=Long.parseLong(json.getString(RecommendConstantUtil.COM_SPU_ID));
                if(!isOnSale(spuId)){
                    handleLogger.info("产品ID:"+spuId+"的状态是下架");
                    iterator.remove();
                    handleLogger.info("产品ID:"+spuId+"已经被成功过滤掉");
                }
            }
        }
    }
}

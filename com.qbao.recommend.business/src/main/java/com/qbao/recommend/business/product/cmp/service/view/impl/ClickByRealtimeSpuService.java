/**
 * 
 */
package com.qbao.recommend.business.product.cmp.service.view.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.qbao.dc.redis.model.UserItemsBean;
import com.qbao.recommend.alarm.facade.AlaramServiceFacotryFacade;
import com.qbao.recommend.alarm.util.MessageConstanUtil;
import com.qbao.recommend.business.product.cmp.common.CommonSpuService;
import com.qbao.recommend.business.product.cmp.handler.factory.SpuHandlerFactory;
import com.qbao.recommend.business.product.cmp.service.view.IClickByRealtimeSpuService;
import com.qbao.recommend.business.product.cmp.strategy.factory.SpuStrategyFactory;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.respositoy.redis.IRedisService;
import com.qbao.recommend.respositoy.redis.common.RedisModel;
import com.qbao.recommend.respositoy.redis.factory.RedisModelFactory;
import com.qbao.recommend.respositoy.redis.model.GoodsItems;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate$
 * $LastChangedRevision$
 * $LastChangedBy$
 */
@Service
public class ClickByRealtimeSpuService extends CommonSpuService implements IClickByRealtimeSpuService{
     
    @Autowired
    IRedisService  redisService;
    
    @Autowired
    private SpuHandlerFactory spuHandlerFactory;
    
    @Autowired
    private SpuStrategyFactory spuStrategyFactory;
   
    /* (non-Javadoc)
     * @see com.qbao.recommend.business.product.cmp.service.view.IClickByRealtimeSpuService#getClickByRealtimeTopSpu(com.alibaba.fastjson.JSONObject)
     */
    @Override
    public List<Long> getClickByRealtimeTopSpu(JSONObject jsonObject) {
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
        
        try {
            UserItemsBean bean = this.getUserRecommedItemsFromRedis(userId);
            List<GoodsItems> goodsItemsList = bean.getGoodsItems();
            for (GoodsItems gi : goodsItemsList) {
                // 过滤非实时和非必购好货
                if (gi.getScore() < 0.9 || gi.getType() != 1)
                    continue;
                String goodsId = gi.getGoodsId();
                resultList.add(Long.parseLong(goodsId));
            }
        }catch(Exception e){
            this.servericeLogger.warn("ClickByRealtimeSpuService.getClickByRealtimeTopSpu  error! userId:" + userId);
            jsonObject.put(MessageConstanUtil.ALARM_EXCEPTION, e);
            jsonObject.put(MessageConstanUtil.ALARM_TYPE, MessageConstanUtil.MAIL_ERROR);
            jsonObject.put(MessageConstanUtil.ALARM_USERID, userId);
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
            this.servericeLogger.warn("ClickByRealtimeSpuService.getClickByRealtimeTopSpu The data is not enough! request_num:" + num + " reality_num:" + resultList.size() + "  Completion strategy:" + completions);
            Exception e = new Exception("ClickByRealtimeSpuService.getClickByRealtimeTopSpu The data is not enough! request_num:" + num + " reality_num:" + resultList.size() + "  Completion strategy:" + completions);
            jsonObject.put(MessageConstanUtil.ALARM_EXCEPTION, e);
            jsonObject.put(MessageConstanUtil.ALARM_TYPE, MessageConstanUtil.MAIL_ERROR);
            jsonObject.put(MessageConstanUtil.ALARM_USERID, userId);
            AlaramServiceFacotryFacade.sendAlaramMessageByMail(jsonObject);
            spuStrategyFactory.executeStrategy(completions, resultList, num);
        }
        
        spuHandlerFactory.executeHandleChain(handlers,resultList);
        
        Map<Long,List<Long>> resultMap = new HashMap<Long,List<Long>>();
        resultMap.put(userId, resultList);
        spuHandlerFactory.executeHandleChain(RecommendConstantUtil.BUYFILTER_HANDLER, resultMap);
        
        return super.splitSpuList(resultList,num);
    }
    
    
    private UserItemsBean getUserRecommedItemsFromRedis(long userId) {
        RedisModel<UserItemsBean> queryModel = (RedisModel<UserItemsBean>) RedisModelFactory.getQueryModel(userId+"", UserItemsBean.class);
        try {
            queryModel = (RedisModel<UserItemsBean>) redisService.find(queryModel);
            if (queryModel != null && queryModel.getValue() != null)
                return queryModel.getValue();
        } catch (Exception ex) {
            throw new RuntimeException("get the realtime recommend data from redis for " + userId);
        }
        return null;
    }

}

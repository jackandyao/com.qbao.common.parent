/**
 * 
 */
package com.qbao.recommend.business.shop.cmp.handler.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.qbao.recommend.business.shop.cmp.handler.RecommendHandler;
import com.qbao.recommend.business.shop.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.respositoy.mysql.model.UserProfile;
import com.qbao.recommend.respositoy.mysql.service.IUserProfileService;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate$
 * $LastChangedRevision$
 * $LastChangedBy$
 */
@Component(value=RecommendConstantUtil.ANNO_SHOP_FILTERBUY_HANDLE)
public class ShopFilterBuyHandler implements RecommendHandler{

    @Autowired
    IUserProfileService userProfileService;
    /* (non-Javadoc)
     * @see com.qbao.recommend.business.product.cmp.handler.RecommendHandler#executeHandler(java.lang.Object)
     */
    @Override
    public <T> void executeHandler(T t) {
        @SuppressWarnings("unchecked")
        Map<Long,List<String>> listMap =(Map<Long,List<String>>) t;
        for(Long uid:listMap.keySet()){
            UserProfile userProfile = userProfileService.findById(uid);
            if(userProfile == null){
                return;
            }
            List<Long> buyInfos = userProfile.fetchBuyGoodsIds();
            Iterator<String> iterator = listMap.get(uid).iterator();
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
	                if(buyInfos.contains(Long.valueOf(spuId))){
	                    handleLogger.info("商铺ID:"+shopRecArray[0]+"的产品ID:"+spuId+"的状态是已购买商品,已经被成功过滤掉");
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

}

/**
 * 
 */
package com.qbao.recommend.business.product.cmp.handler.impl;

import com.qbao.recommend.business.product.cmp.handler.RecommendHandler;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.respositoy.mysql.model.UserProfile;
import com.qbao.recommend.respositoy.mysql.service.IUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate$
 * $LastChangedRevision$
 * $LastChangedBy$
 */
@Component(value=RecommendConstantUtil.ANNO_SPU_FILTERBUY_HANDLE)
public class SpuFilterBuyHandler implements RecommendHandler{

    @Autowired
    IUserProfileService userProfileService;
    /* (non-Javadoc)
     * @see com.qbao.recommend.business.product.cmp.handler.RecommendHandler#executeHandler(java.lang.Object)
     */
    @Override
    public <T> void executeHandler(T t) {
        @SuppressWarnings("unchecked")
        Map<Long,List<Long>> listMap =(Map<Long,List<Long>>) t;
        for(Long uid:listMap.keySet()){
            UserProfile userProfile = userProfileService.findById(uid);
            if(userProfile == null){
                return;
            }
            List<Long> buyInfos = userProfile.fetchBuyGoodsIds();
            Iterator<Long> iterator = listMap.get(uid).iterator();
            while (iterator.hasNext()){
                long spuId = iterator.next();
                if(buyInfos.contains(spuId)){
                    handleLogger.info("产品ID:"+spuId+" 已经被购买！");
                    iterator.remove();
                    handleLogger.info("产品ID:"+spuId+" 已经被成功过滤掉！");
                }
            }  
        }
    }

}

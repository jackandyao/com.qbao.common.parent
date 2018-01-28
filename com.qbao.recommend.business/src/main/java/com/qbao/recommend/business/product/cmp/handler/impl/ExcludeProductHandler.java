package com.qbao.recommend.business.product.cmp.handler.impl;
import com.qbao.recommend.business.product.cmp.handler.RecommendHandler;
import com.qbao.recommend.business.product.cmp.service.exclude.IExcludeProductService;
import org.apache.commons.collections.CollectionUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author wangping
 * @createTime 下午6:51
 * $$LastChangedDate: 2016-12-22 18:32:37 +0800 (Thu, 22 Dec 2016) $$
 * $$LastChangedRevision: 1529 $$
 * $$LastChangedBy: wangping $$
 */
//@Component(value= RecommendConstantUtil.EXCLUDE_HANDLER)
public class ExcludeProductHandler implements RecommendHandler {

//    @Autowired
    IExcludeProductService excludeProductService;


    @Override
    public <T> void executeHandler(T t) {
        Map<Long,List<Long>> listMap =(Map<Long,List<Long>>) t;
        for(Long uid:listMap.keySet()){
            List<Long> excludeProductIds  = excludeProductService.calExcludeProductIds(uid);
            if(CollectionUtils.isEmpty(excludeProductIds)){
                return;
            }
            Iterator<Long> iterator = listMap.get(uid).iterator();
            while (iterator.hasNext()){
                long spuId = iterator.next();
                if(excludeProductIds.contains(spuId)){
                    iterator.remove();
                    handleLogger.info("用户 ["+uid+"], 不喜欢该 产品ID ["+spuId+"], 该产品被过滤 ");
                }
            }
        }
    }



}


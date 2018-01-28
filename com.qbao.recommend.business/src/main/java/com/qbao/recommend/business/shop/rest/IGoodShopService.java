/**
 * 
 */
package com.qbao.recommend.business.shop.rest;

import java.util.Map;

/**
 * @author sjzhangjun
 *
 * $LastChangedDate$
 * $LastChangedRevision$
 * $LastChangedBy$
 */
public interface IGoodShopService {
    /**
     * 数据助手 好店接口
     * @param p
     * @return
     */
    Map<String,Object> getGoodShops( long userId, int page,int pageSize);
    
}

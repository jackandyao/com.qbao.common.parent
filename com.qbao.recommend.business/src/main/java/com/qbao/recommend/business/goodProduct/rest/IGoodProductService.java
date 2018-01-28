/**
 * 
 */
package com.qbao.recommend.business.goodProduct.rest;

import java.util.Map;

/**
 * @author sjzhangjun
 *
 * $LastChangedDate$
 * $LastChangedRevision$
 * $LastChangedBy$
 */
public interface IGoodProductService {
    /**
     * 有好货v1.0接口
     * @return
     */
    Map<String,Object> getGoodProduct( long goodsId);

    Map<String,Object> getGoodsLikes( long goodsId, int pageSize);

    Map<String,Object> getGoodsKPI( long goodsId);

    /**
     * 有好货 分类接口
     * @return
     */
    Map<String,Object> getGoodsClasses();

    /**
     * 好货列表接口
     */
    Map<String,Object> getGoodsList(long cid,String kw,int page,int size);


}

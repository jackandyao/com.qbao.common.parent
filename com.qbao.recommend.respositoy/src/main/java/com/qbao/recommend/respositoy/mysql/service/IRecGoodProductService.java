/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.RecGoodProduct;

import java.util.List;

/**
 * @author zhangjun
 */
public interface IRecGoodProductService{
	public RecGoodProduct findBySpuId(long spuId);

	/**
	 * 根据spuId 的dir Id 获取该类目的TOPN
	 * @param spuId
	 * @param limit
     * @return
     */
	public List<RecGoodProduct> findTopNSpuByDirId(long spuId ,int limit);
}

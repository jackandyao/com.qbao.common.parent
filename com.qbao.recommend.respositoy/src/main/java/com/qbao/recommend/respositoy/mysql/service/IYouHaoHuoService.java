/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.RecommendItems;

/**
 * @author zhangjun
 */
public interface IYouHaoHuoService{
	public RecommendItems findById(long id);
}

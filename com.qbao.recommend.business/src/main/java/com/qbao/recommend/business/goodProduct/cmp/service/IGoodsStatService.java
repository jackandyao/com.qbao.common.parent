package com.qbao.recommend.business.goodProduct.cmp.service;

import com.qbao.recommend.respositoy.mysql.model.RecGoodProduct;

public interface IGoodsStatService {

	public RecGoodProduct getGoodsStatBySpuId(long spuId);


}

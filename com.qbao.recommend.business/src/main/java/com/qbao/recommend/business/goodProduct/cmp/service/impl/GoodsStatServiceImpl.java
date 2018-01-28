package com.qbao.recommend.business.goodProduct.cmp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qbao.recommend.business.goodProduct.cmp.service.IGoodsStatService;
import com.qbao.recommend.respositoy.mysql.model.RecGoodProduct;
import com.qbao.recommend.respositoy.mysql.service.IRecGoodProductService;

@Service
public class GoodsStatServiceImpl implements IGoodsStatService{

	@Autowired
	IRecGoodProductService iRecGoodProductService;
	
	@Override
	public RecGoodProduct getGoodsStatBySpuId(long spuId) {
		return iRecGoodProductService.findBySpuId(spuId);
	}

	
}

package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.HotSpuSearch;

import java.util.List;

public interface IHotSpuService {

	//微商热销spuId集合
	List<Long> findAllSpuIdofHotSpuMerchant();
	//宝购热销baogouId集合
	List<Long> findAllBaogouIdofHotSpuBaogou();
	
	List<Long> getAllSpuIdFromHotSpuSearch();

	List<HotSpuSearch> getALLHotSpuSearch();
}

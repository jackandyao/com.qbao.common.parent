package com.qbao.recommend.respositoy.mysql.service;


import java.util.List;

import com.qbao.recommend.respositoy.mysql.model.SpuInfoMerchant;

public interface IMerMiddleDataService {
	
	public List<String> findIllegalitySpuList();
	public List<String> findIllegalityImgList();
	public List<String> findIllegalityDirSpuList(String dirId);
	public List<SpuInfoMerchant> findTagKeyDirectoryList();
	public SpuInfoMerchant findBySpuId(Long spuId);
	public SpuInfoMerchant findBySpuIdIgnoreStatus(Long spuId);
	public List<SpuInfoMerchant> findByPage(int offset, int limit);
}
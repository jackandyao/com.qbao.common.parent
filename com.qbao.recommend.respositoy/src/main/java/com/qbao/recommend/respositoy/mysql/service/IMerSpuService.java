package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.SpuInfoMerchant;

import java.util.List;



/**
 * 微商服务接口
 * @author	yuandongrui
 * @date 	2016年6月21日
 */
public interface IMerSpuService{
	/**
	 * 根据supId查询微商在售商品的实体
	 * @param spuId
	 * @return
	 */
	public SpuInfoMerchant findBySpuId(long spuId);

	/**
	 * 根据supId查询微商商品的实体
	 * @param spuId
	 * @return
	 */
	public SpuInfoMerchant findBySpuIdIgnoreStatus(long spuId);
	
	/**
	 * 查询微商所有在售的商品
	 * @return
	 */
	public List<Long> findSellingAll();
	
	/**
	 * 根居userId分页查询在售的商品列表
	 * @param userId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<SpuInfoMerchant> findSellingByUserIdLimit(long userId,int page,int pageSize);
}

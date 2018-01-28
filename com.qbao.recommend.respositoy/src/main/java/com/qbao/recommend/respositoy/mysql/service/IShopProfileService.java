package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.ShopProfile;

/**
 * @author	yuandongrui
 * @date 	2016年6月29日
 */
public interface IShopProfileService{
    /**
     * 根据商品id获取对应的详细信息
     * @param pId
     * @return
     */
    public ShopProfile findById(long shopId);
}

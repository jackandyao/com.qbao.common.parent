package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.LoginBlacklist;

/**
 * @author	yuandongrui
 * @date 	2016年6月29日
 */
public interface ILoginBlacklistService{
    /**
     * 根据商品id获取对应的详细信息
     * @param pId
     * @return
     */
    public LoginBlacklist findByUserName(String userName);
}

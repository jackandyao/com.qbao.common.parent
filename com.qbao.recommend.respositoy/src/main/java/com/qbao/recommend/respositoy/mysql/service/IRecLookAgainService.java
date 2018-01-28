package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.RecommendItems;
import com.qbao.recommend.respositoy.mysql.model.RecommendLookItems;

/**
 * @author	yuandongrui
 * @date 	2016年6月29日
 */
public interface IRecLookAgainService{

    /**
     * 
     * @param id   'spuId baogouId',
     * @param type  '0:merchant 1:baogou',
     * @return
     */
    public RecommendLookItems findByIdAndType(long id, int type);
}

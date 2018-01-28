package com.qbao.recommend.respositoy.mysql.service;

/**
 * Created by shuaizhihu on 2016/11/18.
 */
public interface IMerchantGoodStatDayService {

    public long findOrderNumBySpuId(long  spuId,String startDate,String endDate);
}

package com.qbao.recommend.respositoy.mysql.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by shuaizhihu on 2016/11/18.
 */
@Component
public interface MerchantGoodsStatDayDao {

    @Select("select sum(order_num) from light_merchant_goods_stat_day where goods_id = #{spuId} and stat_date >= #{startDate} and stat_date <= #{endDate}")
    public  Long getOrderNum( @Param("spuId") long spuId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
}

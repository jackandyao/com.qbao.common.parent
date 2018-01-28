package com.qbao.recommend.respositoy.mysql.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.ShopProfile;

/**
 * @author	yuandongrui
 * @date 	2016年6月28日
 */
@Component
public interface ShopProfileDao {
	@Select("select * from ${tableName} where shop_id = #{shopId}  limit 0,1")
	@ResultMap("ShopProfileMap")
	public ShopProfile findById(@Param("tableName") String tableName,@Param("shopId") long shopId);
}

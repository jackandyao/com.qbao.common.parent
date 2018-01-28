package com.qbao.recommend.respositoy.mysql.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.ProductProfile;

/**
 * @author	yuandongrui
 * @date 	2016年6月28日
 */
@Component
public interface MerProductProfileDao {
    
	@Select("select * from ${tableName} where pid = #{pid}  limit 0,1")
	@ResultMap("ProductProfileMap")
	public ProductProfile findById(@Param("tableName") String tableName,@Param("pid") long pid);
}

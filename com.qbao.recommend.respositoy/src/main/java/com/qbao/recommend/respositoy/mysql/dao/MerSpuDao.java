package com.qbao.recommend.respositoy.mysql.dao;

import com.qbao.recommend.respositoy.mysql.model.SpuInfoMerchant;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MerSpuDao {
	
	@Select("select * FROM ${tableName} where spu_id = #{spuId} and publish_status=1 and audit_status in(2,4) limit 0,1")
	@ResultMap("MerSpuMap")
	public SpuInfoMerchant findBySpuId(@Param("tableName") String tableName,@Param("spuId") long spuId);

	@Select("select * FROM ${tableName} where spu_id = #{spuId}  limit 0,1")
	@ResultMap("MerSpuMap")
	public SpuInfoMerchant findBySpuIdIgnoreStatus(@Param("tableName") String tableName,@Param("spuId") long spuId);

	@Select("select spu_id FROM ${tableName} where publish_status=1 and audit_status in(2,4)")
	public List<Long> findSellingAll(@Param("tableName") String tableName);
	
	
	@Select("select * from ${tableName} where  publish_status=1 and audit_status in (2,4) and user_id = #{userId} limit #{start},#{rows}")
	@ResultMap("MerSpuMap")
	public List<SpuInfoMerchant> findSellingByUserIdLimit(@Param("tableName")String tableName,@Param("userId")long userId,@Param("start") int start,@Param("rows") int rows);
	
	@Select("select count(1) from ${tableName} where  publish_status=1 and audit_status in (2,4) and user_id = #{userId}")
	public int findSellingByUserIdCount(@Param("tableName")String tableName,@Param("userId")long userId);



}

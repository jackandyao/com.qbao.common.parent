package com.qbao.recommend.respositoy.mysql.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.SpuInfoBaogou;



/**
 * 数据表qbaochou.bc_product操作接口
 * @author shuaizhihu
 * @Date 2016-04-12
 *
 */
@Component
public interface BcProductDao {
	
	@Select("select count(1) from ${tableName} ")
	public int getTotal(@Param("tableName") String tableName);
	
	@Select("select * from ${tableName} limit #{start},#{rows}")
	@ResultMap("BcProductMap")
	public List<SpuInfoBaogou> findByLimit(@Param("tableName") String tableName,@Param("start") int start,@Param("rows") int rows);
	
	@Select("select * from ${tableName} where state = 2 limit #{start},#{rows}")
	@ResultMap("BcProductMap")
	public List<SpuInfoBaogou> findSellingByLimit(@Param("tableName") String tableName,@Param("start") int start,@Param("rows") int rows);
	
	@Select("select count(1) from ${tableName} where state = 2")
	public int getSellingTotal(@Param("tableName") String tableName);
	
	@Select("select spu_id from ${tableName} where state = 2")
	public List<Long> findSellingAll(@Param("tableName")String tableName);
	
	@Select("select * from ${tableName} where spu_id = #{spuId} and state = 2 limit 0,1 ")
	@ResultMap("BcProductMap")
	public SpuInfoBaogou findBySpuId(@Param("tableName") String tableName,@Param("spuId") long spuId);
	
	@Select("select * from ${tableName} where id = #{id} and state = 2 limit 0,1 ")
	@ResultMap("BcProductMap")
	public SpuInfoBaogou findSellingById(@Param("tableName") String tableName,@Param("id") long id);
	
	@Select("select * from ${tableName} where id = #{id}  limit 0,1 ")
	@ResultMap("BcProductMap")
	public SpuInfoBaogou findById(@Param("tableName") String tableName,@Param("id") long id);
}

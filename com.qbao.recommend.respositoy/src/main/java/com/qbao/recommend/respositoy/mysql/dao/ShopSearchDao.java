package com.qbao.recommend.respositoy.mysql.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.ShopSearch;



/**
 * 操作user_rec.hot_spu_baogou user_rec.hot_spu_merchant 接口
 * @author shuaizhihu
 * @Date 2016-04-28
 *
 */
@Component
public interface ShopSearchDao {
	
	@Select("select * from ${tableName} group by spu_id order by cid,sid limit #{start},#{rows} ")
	@ResultMap("ShopSearchMap")
	public List<ShopSearch> findHotSpuSearch(@Param("tableName") String tableName,@Param("start") int start, @Param("rows") int rows);
	
	@Select("select * from ${tableName} limit #{start},#{rows}")
	@ResultMap("ShopSearchMap")
	public List<ShopSearch> findListByLimit(@Param("tableName") String tableName,@Param("start") int start, @Param("rows") int rows);
	
	
}


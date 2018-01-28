package com.qbao.recommend.respositoy.mysql.dao;

import com.qbao.recommend.respositoy.mysql.model.HotSpuSearch;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HotSpuDao {
	
	@Select("select spu_id from ${HOT_SPU_MERCHANT}")
	List<Long> getAllSpuIdfromHotSpuMerchant(@Param("HOT_SPU_MERCHANT") String HOT_SPU_MERCHANT);
	
	@Select("select baogou_id from ${HOT_SPU_BAOGOU}")
	List<Long> getAllBaogouIdfromHotSpuBaogou(@Param("HOT_SPU_BAOGOU") String HOT_SPU_BAOGOU);
	
	@Select("select goods_id from ${HOT_SPU_SEARCH} limit 0,200")
	List<Long> getAllSpuIdFromHotSpuSearch(@Param("HOT_SPU_SEARCH") String HOT_SPU_SEARCH);

	@Select("select * from ${HOT_SPU_SEARCH} limit 0,300")
	@ResultMap("HotSpuSearchMap")
	List<HotSpuSearch> getAllHotSpuSearch(@Param("HOT_SPU_SEARCH") String HOT_SPU_SEARCH);
}

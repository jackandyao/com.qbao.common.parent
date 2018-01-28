package com.qbao.recommend.respositoy.mysql.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.RecGoodProduct;

import java.util.List;

/**
 * 数据表rec_goodproduct推荐结果操作接口
 * @author zhangjun
 * @Date 2016-10-23
 *
 */
@Component
public interface RecGoodProductDao {
	
	@Select("select * from ${tableName} where spu_id = #{spuId} limit 0,1")
	@ResultMap("RecGoodProductMap")
	public RecGoodProduct findBySpuId(@Param("tableName") String tableName,@Param("spuId") long spuId);

	@Select("select * from ${tableName} where spu_id != #{spuId} and dir_id = ( select  dir_id FROM ${tableName} where spu_id = #{spuId} )  ORDER BY sell_num desc limit #{limit} ")
	@ResultMap("RecGoodProductMap")
	public List<RecGoodProduct> findTopNSpuByDirId(@Param("tableName") String tableName,@Param("spuId") long spuId,@Param("limit") int limit);
}

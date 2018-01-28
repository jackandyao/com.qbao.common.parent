package com.qbao.recommend.respositoy.mysql.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.RecommendItems;



/**
 * 数据表recommend推荐结果操作接口
 * @author zhangjun
 * @Date 2016-04-12
 *
 */
@Component
public interface RecommendItemsDao {
	
	@Select("select * from ${tableName} where user_id = #{id}  limit 0,1 ")
	@ResultMap("RecommendItemsMap")
	public RecommendItems findById(@Param("tableName") String tableName,@Param("id") long id);
	
	/**
	 * TODO 扩展宝购,微商和雷拍
	 * @param tableName
	 * @param id
	 * @param type
	 * @return
	 */
	@Select("select * from ${tableName} where user_id = #{id} and type = #{type}  limit 0,1 ")
    @ResultMap("RecommendItemsMap")
    public RecommendItems findByIdAndType(@Param("tableName") String tableName,@Param("id") long id,@Param("type") int type);
	
}

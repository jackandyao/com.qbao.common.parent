package com.qbao.recommend.respositoy.mysql.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.RecommendTweetItems;



/**
 * 数据表recommend推荐结果操作接口
 * @author zhangjun
 * @Date 2016-04-12
 *
 */
@Component
public interface RecommendTweetItemsDao {
	
	@Select("select * from ${tableName} where user_id = #{id}  limit 0,1 ")
	@ResultMap("RecommendTweetItemsMap")
	public RecommendTweetItems findById(@Param("tableName") String tableName,@Param("id") long id);
}

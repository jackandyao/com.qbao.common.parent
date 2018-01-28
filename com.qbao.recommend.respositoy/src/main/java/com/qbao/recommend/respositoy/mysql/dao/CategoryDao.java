package com.qbao.recommend.respositoy.mysql.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.Category;



/**
 * 数据表category宝约主题查询接口
 * @author zhangjun
 * @Date 2016-11-18
 *
 */
@Component
public interface CategoryDao {
	
	@Select("select * from ${tableName}")
	@ResultMap("CategoryMap")
	public List<Category> findAll(@Param("tableName") String tableName);


	@Select("select * from ${tableName} where id = #{id}")
	@ResultMap("CategoryMap")
	public Category getCategoryById(@Param("tableName")String category, @Param("id")long id);
}

package com.qbao.recommend.respositoy.mysql.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;



/**
 * 数据表youpiao操作接口
 * @author zhangjun
 * @Date 2016-11-23
 */
@Component
public interface YouPiaoDao {
	
	@Select("select film_name from ${tableName}")
	public List<String> findAllFileName(@Param("tableName") String tableName);
	
	@Select("select title from ${tableName}")
	public List<String> findAllShowTitle(@Param("tableName") String tableName);
}

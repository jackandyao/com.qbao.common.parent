package com.qbao.recommend.respositoy.mysql.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.BYKeyword;



/**
 * 数据表BYKeyword推荐结果操作接口
 * @author zhangjun
 * @Date 2016-07-21
 *
 */
@Component
public interface BYKeywordDao {
	
	@Select("select * from ${tableName}")
	@ResultMap("BYKeywordMap")
	public List<BYKeyword> findAll(@Param("tableName") String tableName);
}

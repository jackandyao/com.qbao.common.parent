package com.qbao.recommend.respositoy.mysql.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.RecAgentLook;

/**
 * @author	yuandongrui
 * @date 	2016年6月30日
 */
@Component
public interface RecAgentLookDao {
	@Select("select * from ${tableName} where task_id = #{id}  limit 0,1 ")
	@ResultMap("RecAgentLookMap")
	public RecAgentLook findByUserId(@Param("tableName") String tableName,@Param("id") long id);
}

package com.qbao.recommend.respositoy.mysql.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.AgentView;

/**
 * @author	yuandongrui
 * @date 	2016年7月11日
 */
@Component
public interface AgentViewDao {
	@Select("select * from ${tableName} where user_id = #{userId}  limit 0,1 ")
	@ResultMap("AgentViewMap")
	public AgentView findByUserId(@Param("tableName") String tableName,@Param("userId") long userId);
}

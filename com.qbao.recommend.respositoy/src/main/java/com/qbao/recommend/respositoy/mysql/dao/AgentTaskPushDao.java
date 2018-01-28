package com.qbao.recommend.respositoy.mysql.dao;

import com.qbao.recommend.respositoy.mysql.model.AgentTaskPush;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author	yuandongrui
 * @date 	2016年7月11日
 */
@Component
public interface AgentTaskPushDao {
	@Select("select * from ${tableName} where id = #{id}  and status = 1 limit 0,1 ")
	@ResultMap("AgentTaskPushMap")
	public AgentTaskPush findById(@Param("tableName") String tableName, @Param("id") long id);
	

    @Select("select * from ${tableName} where user_id = #{userId} and status = 1 ")
    @ResultMap("AgentTaskPushMap")
    public List<AgentTaskPush> findByUserId(@Param("tableName") String tableName, @Param("userId") long userId);
}

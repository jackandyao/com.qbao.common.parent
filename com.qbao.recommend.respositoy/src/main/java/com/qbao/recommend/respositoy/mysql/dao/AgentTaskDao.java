package com.qbao.recommend.respositoy.mysql.dao;

import com.qbao.recommend.respositoy.mysql.model.AgentTask;
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
public interface AgentTaskDao {
	@Select("select * from ${tableName} where id = #{id}  and status = 4 limit 0,1 ")
	@ResultMap("AgentTaskMap")
	public AgentTask findById(@Param("tableName") String tableName,@Param("id") long id);
	
    @Select("select * from ${tableName} where and status = 4 order by rmb_subsidy desc  limit #{limit}")
    @ResultMap("AgentTaskMap")
    public List<AgentTask> findTasksOrderByMargins(@Param("tableName") String tableName, @Param("limit") int limit);


    @Select("select * from ${tableName} where id = #{id}  and  task_type = #{taskType}  and status = 4 limit 0,1 ")
    @ResultMap("AgentTaskMap")
    public AgentTask findByIdAndTaskType(@Param("tableName") String tableName,@Param("id") long id,@Param("taskType") int taskType);

//
        @Select("select * from ${tableName} where id = #{id}  and status = 4  and task_type != #{taskType} limit 0,1 ")
        @ResultMap("AgentTaskMap")
        public AgentTask findByIdAndNotEqualTaskType(@Param("tableName") String tableName,@Param("id") long id,@Param("taskTypes") int taskType);

    /**
     * <foreach collection="list" item="employeeId" index="index"
     open="(" close=")" separator=",">
     #{employeeId}
     </foreach>
     */


    @Select("select * from ${tableName} where id = #{id}  and status = 4  and task_type not in (3,4,5) limit 0,1 ")
    @ResultMap("AgentTaskMap")
    public AgentTask findRcommendTaskById(@Param("tableName") String tableName,@Param("id") long id);
}

/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import com.qbao.recommend.respositoy.mysql.model.TaskActivity;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-13 22:24:14 +0800 (Tue, 13 Sep 2016) $
 * $LastChangedRevision: 1016 $
 * $LastChangedBy: wangping $
 */
@Component
public interface TaskActivityDao {

    @Select("select * from ${tableName} where id = #{id} and status = 1  limit 0,1")
    @ResultMap("TaskActivityMap")
    public TaskActivity findById(@Param("tableName") String tableName, @Param("id") long id);

    @Select("select * from ${tableName} where status =1 order by margins desc  limit #{limit}")
    @ResultMap("TaskActivityMap")
    public List<TaskActivity> findTasksOrderByMargins(@Param("tableName") String tableName, @Param("limit") int limit);

    @Select("select * from ${tableName} where status =1 ")
    @ResultMap("TaskActivityMap")
    public List<TaskActivity> findAllTaskActivities(@Param("tableName") String tableName);

    @Select("select * from ${tableName} where status =1 and margins < #{margins}  order by margins desc  limit #{limit}")
    @ResultMap("TaskActivityMap")
    public List<TaskActivity> findTasksLessMargins(@Param("tableName") String tableName,  @Param("margins") long margins, @Param("limit") int limit);

}

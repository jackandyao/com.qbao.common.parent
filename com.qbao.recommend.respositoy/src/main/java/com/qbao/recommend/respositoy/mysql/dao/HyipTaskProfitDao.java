package com.qbao.recommend.respositoy.mysql.dao;

import com.qbao.recommend.respositoy.mysql.model.HyipTaskProfit;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author wangping
 * @createTime 上午11:32
 * $$LastChangedDate: 2016-11-03 14:07:14 +0800 (Thu, 03 Nov 2016) $$
 * $$LastChangedRevision: 1374 $$
 * $$LastChangedBy: wangping $$
 */
@Component
public interface HyipTaskProfitDao {

    @Select("select * from ${tableName} where task_id = #{taskId}  limit 0,1 ")
    @ResultMap("HyipTaskProfitMap")
    public HyipTaskProfit findByTaskId(@Param("tableName") String tableName,@Param("taskId") long taskId);
}

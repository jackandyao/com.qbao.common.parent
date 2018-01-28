/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.dao;

import com.qbao.recommend.respositoy.mysql.model.HyipTask;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-10-24 18:06:27 +0800 (Mon, 24 Oct 2016) $
 * $LastChangedRevision: 1291 $
 * $LastChangedBy: wangping $
 */
@Component
public interface HyipTaskDao {

    @Select("select * from ${tableName} where id = #{id} and active_flag = 1  limit 0,1")
    @ResultMap("HyipTaskMap")
    public HyipTask findById(@Param("tableName") String tableName, @Param("id") long id);

    @Select("select * from ${tableName} where active_flag =1 and adsType = #{adsType} and is_recommend_task =0 and is_order_task = 0 order by margins desc  limit #{limit}")
    @ResultMap("HyipTaskMap")
    public List<HyipTask> findTasksOrderByMargins(@Param("tableName") String tableName, @Param("limit") int limit, @Param("adsType") int adsType);

    @Select("select * from ${tableName} where active_flag =1 and is_recommend_task =0 and is_order_task = 0 and adsType = #{adsType} ")
    @ResultMap("HyipTaskMap")
    public List<HyipTask> findAllByAdsType(@Param("tableName") String tableName, @Param("adsType") int adsType);

    @Select("select * from ${tableName} where active_flag =1 and ads_type = #{adsType} and is_recommend_task =0 and is_order_task = 0  and margins < #{margins} and total_reward > 10000 order by margins desc  limit #{limit}")
    @ResultMap("HyipTaskMap")
    public List<HyipTask> findTasksLessMargins(@Param("tableName") String tableName, @Param("margins") long margins, @Param("limit") int limit, @Param("adsType") int adsType);

}

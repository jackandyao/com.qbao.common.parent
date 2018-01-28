/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import com.qbao.recommend.respositoy.mysql.model.UserScoreLevel;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-12 17:54:59 +0800 (Mon, 12 Sep 2016) $
 * $LastChangedRevision: 1008 $
 * $LastChangedBy: wangping $
 */
@Component
public interface UserScoreLevelDao {

    @Select("select * from ${tableName} where user_id = #{userId}  limit 0,1")
    @ResultMap("UserScoreLevelMap")
    public UserScoreLevel findById(@Param("tableName") String tableName, @Param("userId") long userId);

}

/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.LoginBlacklist;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
@Component
public interface LoginBlacklistDao {
    @Select("select * from ${tableName} where username = #{userName} and status = 0  limit 0,1")
    @ResultMap("LoginBlacklistMap")
    public LoginBlacklist findByUserName(@Param("tableName") String tableName, @Param("userName") String userName);
}

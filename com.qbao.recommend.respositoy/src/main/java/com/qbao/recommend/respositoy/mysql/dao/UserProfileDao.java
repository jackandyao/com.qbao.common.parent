/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.UserProfile;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */

@Component
public interface UserProfileDao {
//    @Cacheable("userProfileCache") 
    @Select("select * from ${tableName} where user_id = #{userId}  limit 0,1")
    @ResultMap("UserProfileMap")
    public UserProfile findById(@Param("tableName") String tableName, @Param("userId") long userId);
}

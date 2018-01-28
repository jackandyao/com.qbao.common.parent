package com.qbao.recommend.respositoy.mysql.dao;

import com.qbao.recommend.respositoy.mysql.model.UserExcludeProductJson;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Component;

/**
 * @author wangping
 * @createTime 上午11:12
 * $$LastChangedDate: 2016-11-09 19:59:02 +0800 (Wed, 09 Nov 2016) $$
 * $$LastChangedRevision: 1377 $$
 * $$LastChangedBy: wangping $$
 */


@Component
public interface UserExcludeProductJsonDao {

    @Select("select * from ${tableName} where user_id = #{userId}  limit 0,1")
    @ResultMap("UserExcludeProductJsonMap")
    public UserExcludeProductJson findByUserId(@Param("tableName") String tableName, @Param("userId") long userId);

    @Insert("INSERT INTO ${tableName}(user_id,json) VALUES(#{userId},#{json})")
    public void insert(@Param("tableName") String tableName, @Param("userId") long userId,  @Param("json") String json);

    @Delete("delete from  ${tableName} where user_id = #{userId}")
    public void delete(@Param("tableName") String tableName, @Param("userId") long userId);

    @Update("update ${tableName} set json = #{json} where user_id = #{userId}")
    public void update(@Param("tableName") String tableName, @Param("userId") long userId,  @Param("json") String json);
}

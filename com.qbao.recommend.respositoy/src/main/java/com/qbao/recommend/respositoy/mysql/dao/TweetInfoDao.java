package com.qbao.recommend.respositoy.mysql.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.TweetInfo;

@Component
public interface TweetInfoDao {

    @Select("select * from ${tableName}")
    @ResultMap("TweetInfoMap")
    List<TweetInfo> getTweetInfoList(@Param("tableName") String tableName);

    @Select("select * from ${tableName} where status = #{status}")
    @ResultMap("TweetInfoMap")
    List<TweetInfo> getTweetInfoListByStatus(@Param("tableName") String tableName, @Param("status") int status);

    @Select("select * from ${tableName} where sn = #{sn} limit 0,1")
    @ResultMap("TweetInfoMap")
    TweetInfo getTweetInfoBySn(@Param("tableName") String tableName, @Param("sm") String sn);

    @Select("select * from ${tableName} where id = #{id} and status = 1 limit 0,1")
    @ResultMap("TweetInfoMap")
    TweetInfo getTweetInfoById(@Param("tableName") String tableName, @Param("id") long id);

}

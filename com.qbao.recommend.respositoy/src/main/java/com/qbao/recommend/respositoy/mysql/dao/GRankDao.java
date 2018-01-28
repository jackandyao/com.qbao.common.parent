package com.qbao.recommend.respositoy.mysql.dao;

import com.qbao.recommend.respositoy.mysql.model.GRank;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


/**
 * @author wangping
 * @createTime 下午4:51
 * $$LastChangedDate: 2016-10-24 19:45:46 +0800 (Mon, 24 Oct 2016) $$
 * $$LastChangedRevision: 1292 $$
 * $$LastChangedBy: wangping $$
 */

@Component
public interface GRankDao {
    @Select("select * from ${tableName} where id = #{id}  limit 0,1 ")
    @ResultMap("GRankMap")
    public GRank findById(@Param("tableName") String tableName,@Param("id") long id);
}

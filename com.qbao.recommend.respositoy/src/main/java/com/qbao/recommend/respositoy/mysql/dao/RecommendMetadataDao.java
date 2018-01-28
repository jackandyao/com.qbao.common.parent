package com.qbao.recommend.respositoy.mysql.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.qbao.recommend.respositoy.mysql.model.RecommendMetadata;

public interface RecommendMetadataDao {
    @Select("select * from ${tableName} where param_key = #{key}  limit 0,1 ")
    @ResultMap("RecommendMetadataMap")
    public RecommendMetadata findByParamKey(@Param("tableName") String tableName,@Param("key") String key);
}

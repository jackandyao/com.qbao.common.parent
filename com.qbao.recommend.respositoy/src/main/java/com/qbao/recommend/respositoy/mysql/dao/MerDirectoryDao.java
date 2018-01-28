package com.qbao.recommend.respositoy.mysql.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.MerDirectory;



/**
 * 数据表mer_directory推荐结果操作接口
 * @author zhangjun
 * @Date 2016-10-25
 *
 */
@Component
public interface MerDirectoryDao {
	
	@Select("select a.*,b.dir_name main_dir_name from ${tableName} a,${tableName} b where a.dir_id=#{dirId} and a.main_dir_id=b.dir_id  limit 0,1")
	@ResultMap("MerDirectoryMap")
	public MerDirectory findByDirId(@Param("tableName") String tableName,@Param("dirId") String dirId);
}

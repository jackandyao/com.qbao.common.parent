package com.qbao.recommend.respositoy.mysql.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.QbikeCluster;
import com.qbao.recommend.respositoy.mysql.model.QbikeClusterCenter;
import com.qbao.recommend.respositoy.mysql.model.QbikeClusterRegion;
import com.qbao.recommend.respositoy.mysql.model.QbikeFlow;


/**
 * 数据表Qbike区域调度结果操作接口
 * @author sjzhangjun
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (星期一, 05 九月 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: $
 */
@Component
public interface QbikeDao {
	
	@Select("select * from ${tableName} where seq_id = (select max(seq_id) from ${tableName})")
	@ResultMap("QbikeClusterMap")
	public List<QbikeCluster> findQbikeCluster(@Param("tableName") String tableName);
	
	@Select("select * from ${tableName} where seq_id = (select max(seq_id) from ${tableName})")
	@ResultMap("QbikeClusterCenterMap")
	public List<QbikeClusterCenter> findQbikeClusterCenter(@Param("tableName") String tableName);
	
	@Select("select * from ${tableName} where seq_id = (select max(seq_id) from ${tableName})")
	@ResultMap("QbikeClusterRegionMap")
	public List<QbikeClusterRegion> findQbikeClusterRegion(@Param("tableName") String tableName);
	
	@Select("select * from ${tableName} where seq_id = (select max(seq_id) from ${tableName})")
	@ResultMap("QbikeUserClusterMap")
	public List<QbikeCluster> findQbikeUserCluster(@Param("tableName") String tableName);
	
	@Select("select * from ${tableName} where seq_id = (select max(seq_id) from ${tableName})")
	@ResultMap("QbikeUserClusterCenterMap")
	public List<QbikeClusterCenter> findQbikeUserClusterCenter(@Param("tableName") String tableName);
	
	@Select("select * from ${tableName} where seq_id = (select max(seq_id) from ${tableName})")
	@ResultMap("QbikeUserClusterRegionMap")
	public List<QbikeClusterRegion> findQbikeUserClusterRegion(@Param("tableName") String tableName);
	
	@Select("select * from ${tableName} where seq_id = (select max(seq_id) from ${tableName})")
	@ResultMap("QbikeUserClusterRegionMap")
	public List<QbikeFlow> findQbikeFlow(@Param("tableName") String tableName);
}

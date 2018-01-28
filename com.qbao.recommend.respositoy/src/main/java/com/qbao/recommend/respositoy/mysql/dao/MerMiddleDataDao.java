package com.qbao.recommend.respositoy.mysql.dao;

import com.qbao.recommend.respositoy.mysql.model.SpuInfoMerchant;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface MerMiddleDataDao {
	
	@Select(" select spu_id from ${tableName}  where is_audited <> 1 or advertorial is null or detail_desc is null or sell_count_aggregated=0 ")
	public List<String> findIllegalitySpuList(@Param("tableName") String tableName);
	
	@Select(" select spu_id from ${tableName} where width*height < 40000 ")
	public List<String> findIllegalityImgList(@Param("tableName") String tableName);
	
	@Select(" select spu_id from ${tableName}  where dir_id = ${dirId} ")
	public List<String> findIllegalityDirSpuList(@Param("tableName") String tableName, @Param("dirId") String dirId);
	
	@Select("select t.spu_id,s.tag_key_directory from ${MER_MIDDLE_DATA_TABLE} t inner join ${SEARCH_TAG_DIRECTORY_TABLE} s on t.dir_id=s.tag_key")
	@ResultMap("MerMiddleDataMap")
	public List<SpuInfoMerchant> findTagKeyDirectoryList(@Param("MER_MIDDLE_DATA_TABLE") String MER_MIDDLE_DATA_TABLE,@Param("SEARCH_TAG_DIRECTORY_TABLE") String SEARCH_TAG_DIRECTORY_TABLE);

	@Select(" select * from ${tableName}  where spu_id = ${spuId}  limit 0,1 ")
	@ResultMap("MerMiddleDataMap")
	public SpuInfoMerchant findBySpuIdIgnoreStatus(@Param("tableName") String tableName, @Param("spuId") long spuId);

	@Select(" select * from ${tableName}  where spu_id = ${spuId} and publish_status=1 and audit_status in(2,4) limit 0,1 ")
	@ResultMap("MerMiddleDataMap")
	public SpuInfoMerchant findBySpuId(@Param("tableName") String tableName, @Param("spuId") long spuId);


	@Select(" select * from ${tableName} limit #{offset},#{limit} ")
	@ResultMap("MerMiddleDataMap")
	public List<SpuInfoMerchant> findByPage(@Param("tableName") String tableName, @Param("offset") long offset, @Param("limit") long limit);

}
 
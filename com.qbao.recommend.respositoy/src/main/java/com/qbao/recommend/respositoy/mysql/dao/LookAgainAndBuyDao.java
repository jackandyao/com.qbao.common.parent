package com.qbao.recommend.respositoy.mysql.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;



@Component
public interface LookAgainAndBuyDao {
	
    @Deprecated
	@Select(" select spu_ids from ${tableName}  where user_id = ${id} and type = ${type} limit 1 ")
	public String findLookItemsByIdAndType(@Param("tableName") String tableName, @Param("id") long id, @Param("type") int type );
	
}
 
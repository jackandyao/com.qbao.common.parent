/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.HyipTransferHand;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
@Component
public interface HyipTransferHandDao {
    @Select("select * from ${tableName} where user_id = #{userId} and type != 0  limit 0,1")
    @ResultMap("HyipTransferHandMap")
    public HyipTransferHand findByUserId(@Param("tableName") String tableName, @Param("userId") long userId);

    /**
     * @param tableName
     * @param userName
     * @return
     */
    @Select("select * from ${tableName} where user_name = #{userName} and type = 1  limit 0,1")
    @ResultMap("HyipTransferHandMap")
    public HyipTransferHand findByUserName(@Param("tableName") String tableName, @Param("userName") String userName);
}

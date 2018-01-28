/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.QbdcKeywordDeptReal;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
@Component
public interface QbdcKeywordDeptRealDao {
    @ResultMap("QbdcKeywordDeptRealMap")
    @Select("select * from ${tableName} where status = 1")
    public List<QbdcKeywordDeptReal> findKeyWordDeptRealAll(@Param("tableName")String tableName);
}

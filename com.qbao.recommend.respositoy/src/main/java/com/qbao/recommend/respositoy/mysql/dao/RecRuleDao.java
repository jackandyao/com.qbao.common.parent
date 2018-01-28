package com.qbao.recommend.respositoy.mysql.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.RecRule;

/**
 * @author	yuandongrui
 * @date 	2016年6月21日
 */
@Component
public interface RecRuleDao {
	@Select("select * from ${tableName} where rule_name = #{ruleName}  limit 0,1 ")
	@ResultMap("RecRuleMap")
	public RecRule findByRuleName(@Param("tableName") String tableName,@Param("ruleName") String ruleName);
	
	@Select("select * from ${tableName}")
	@ResultMap("RecRuleMap")
	public List<RecRule> findAll(@Param("tableName") String tableName);
}

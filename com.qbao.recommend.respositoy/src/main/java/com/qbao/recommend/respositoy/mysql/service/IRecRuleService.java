package com.qbao.recommend.respositoy.mysql.service;

import java.util.List;

import com.qbao.recommend.respositoy.mysql.model.RecRule;



/**
 * @author	yuandongrui
 * @param <T>
 * @date 	2016年6月21日
 */
public interface IRecRuleService{
	/**
	 * 根据规则名称查询规则
	 * @param ruleName
	 * @return
	 */
	public RecRule findByRuleName(String ruleName);
	
	public List<RecRule> findAll();
}

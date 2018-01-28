package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;

/**
 * 规则实体类
 * @author	yuandongrui
 * @date 	2016年6月22日
 */
public class RecRule implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1055986659388149271L;
	private int id;
	private String ruleName;
	private String ruleValue;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getRuleValue() {
		return ruleValue;
	}
	public void setRuleValue(String ruleValue) {
		this.ruleValue = ruleValue;
	}
	
}

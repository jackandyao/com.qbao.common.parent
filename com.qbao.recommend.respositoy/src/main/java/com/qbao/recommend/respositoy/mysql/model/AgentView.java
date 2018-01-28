package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author	yuandongrui
 * @date 	2016年7月11日
 */
public class AgentView implements Serializable{
	private long id;
	private long userId;
	private String items;
	private Date dt;
	private Date updateTime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public Date getDt() {
		return dt;
	}
	public void setDt(Date dt) {
		this.dt = dt;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}

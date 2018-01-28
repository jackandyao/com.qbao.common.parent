package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class UserViewBuy implements Serializable{

	/**
     * 
     */
    private static final long serialVersionUID = -7141936575993616151L;
    private long userId;
	private String items;
	private Date actionTime;
	private int type;
	
	
	public UserViewBuy() {
		super();
	}
	
	public UserViewBuy(long userId, String items, Date actionTime, int type) {
		super();
		this.userId = userId;
		this.items = items;
		this.actionTime = actionTime;
		this.type = type;
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
	public Date getActionTime() {
		return actionTime;
	}
	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(ToStringStyle.MULTI_LINE_STYLE);
    }
	
	
}

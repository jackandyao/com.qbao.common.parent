package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;

/**
 * @author	yuandongrui
 * @date 	2016年7月11日
 */
public class RecAgentLook implements Serializable {
	/**
     * 
     */
    private static final long serialVersionUID = 4161416518355961385L;
    private long taskId;
	private String taskIds;
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public String getTaskIds() {
		return taskIds;
	}
	public void setTaskIds(String taskIds) {
		this.taskIds = taskIds;
	}
	
}

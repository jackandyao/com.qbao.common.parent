package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;

/**
 * @author yuandongrui
 * @date 2016年7月11日
 */
public class RecAgentGuess implements Serializable {
    private static final long serialVersionUID = "$Id: RecAgentGuess.java 1016 2016-09-13 14:24:14Z wangping $".hashCode();
    private long userId;
    private String taskIds;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(String taskIds) {
        this.taskIds = taskIds;
    }

    @Override
    public String toString() {
        return "RecAgentGuess [userId=" + userId + ", taskIds=" + taskIds + "]";
    }
}

package com.qbao.recommend.respositoy.mysql.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * @author wangping
 * @createTime 下午2:46
 * $$LastChangedDate: 2016-12-05 18:59:08 +0800 (Mon, 05 Dec 2016) $$
 * $$LastChangedRevision: 1512 $$
 * $$LastChangedBy: wangping $$
 */
public class AgentTaskPush implements Serializable {

    private static final long serialVersionUID = "$Id: AgentTaskPush.java 1512 2016-12-05 10:59:08Z wangping $".hashCode();
    private Long id;
    private Long taskId;
    private Long userId;
    private int status;
    private String taskName;
        /*
   `id` bigint(20) NOT NULL COMMENT '主键id',
  `task_id` bigint(20) NOT NULL COMMENT '推送的任务id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '状态 0未生效  1生效',
  `task_name` varchar(32) NOT NULL DEFAULT '' COMMENT '任务名称',
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof AgentTaskPush))
            return false;

        AgentTaskPush that = (AgentTaskPush) o;

        return new EqualsBuilder()
                .append(getStatus(), that.getStatus())
                .append(getId(), that.getId())
                .append(getTaskId(), that.getTaskId())
                .append(getUserId(), that.getUserId())
                .append(getTaskName(), that.getTaskName())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(getTaskId())
                .append(getUserId())
                .append(getStatus())
                .append(getTaskName())
                .toHashCode();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AgentTaskPush{");
        sb.append("id=").append(id);
        sb.append(", taskId=").append(taskId);
        sb.append(", userId=").append(userId);
        sb.append(", status=").append(status);
        sb.append(", taskName='").append(taskName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

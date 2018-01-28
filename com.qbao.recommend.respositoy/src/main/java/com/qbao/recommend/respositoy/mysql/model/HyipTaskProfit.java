package com.qbao.recommend.respositoy.mysql.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author wangping
 * @createTime 上午11:19
 * $$LastChangedDate: 2016-11-03 14:07:14 +0800 (Thu, 03 Nov 2016) $$
 * $$LastChangedRevision: 1374 $$
 * $$LastChangedBy: wangping $$
 */
public class HyipTaskProfit implements Serializable {

    private static final long serialVersionUID = "$Id: HyipTaskProfit.java 1374 2016-11-03 06:07:14Z wangping $".hashCode();
    private long id;
    private int status;
    private int type;
    private int isReceived;
    private long receivedSendNum;
    private int isCommpleted;
    private long completedSendNum;
    private int isSettled;
    private long settledSendNum;
    private int days;
    private long taskId;
    private int isValid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIsReceived() {
        return isReceived;
    }

    public void setIsReceived(int isReceived) {
        this.isReceived = isReceived;
    }

    public long getReceivedSendNum() {
        return receivedSendNum;
    }

    public void setReceivedSendNum(long receivedSendNum) {
        this.receivedSendNum = receivedSendNum;
    }

    public int getIsCommpleted() {
        return isCommpleted;
    }

    public void setIsCommpleted(int isCommpleted) {
        this.isCommpleted = isCommpleted;
    }

    public long getCompletedSendNum() {
        return completedSendNum;
    }

    public void setCompletedSendNum(long completedSendNum) {
        this.completedSendNum = completedSendNum;
    }

    public int getIsSettled() {
        return isSettled;
    }

    public void setIsSettled(int isSettled) {
        this.isSettled = isSettled;
    }

    public long getSettledSendNum() {
        return settledSendNum;
    }

    public void setSettledSendNum(long settledSendNum) {
        this.settledSendNum = settledSendNum;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof HyipTaskProfit))
            return false;

        HyipTaskProfit that = (HyipTaskProfit) o;

        return new EqualsBuilder()
                .append(getId(), that.getId())
                .append(getStatus(), that.getStatus())
                .append(getType(), that.getType())
                .append(getIsReceived(), that.getIsReceived())
                .append(getReceivedSendNum(), that.getReceivedSendNum())
                .append(getIsCommpleted(), that.getIsCommpleted())
                .append(getCompletedSendNum(), that.getCompletedSendNum())
                .append(getIsSettled(), that.getIsSettled())
                .append(getSettledSendNum(), that.getSettledSendNum())
                .append(getDays(), that.getDays())
                .append(getTaskId(), that.getTaskId())
                .append(getIsValid(), that.getIsValid())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(getStatus())
                .append(getType())
                .append(getIsReceived())
                .append(getReceivedSendNum())
                .append(getIsCommpleted())
                .append(getCompletedSendNum())
                .append(getIsSettled())
                .append(getSettledSendNum())
                .append(getDays())
                .append(getTaskId())
                .append(getIsValid())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("status", status)
                .append("type", type)
                .append("isReceived", isReceived)
                .append("receivedSendNum", receivedSendNum)
                .append("isCommpleted", isCommpleted)
                .append("completedSendNum", completedSendNum)
                .append("isSettled", isSettled)
                .append("settledSendNum", settledSendNum)
                .append("days", days)
                .append("taskId", taskId)
                .append("isValid", isValid)
                .toString();
    }
}

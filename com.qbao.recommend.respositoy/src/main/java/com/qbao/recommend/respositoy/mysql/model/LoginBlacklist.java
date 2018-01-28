/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-10-12 18:37:40 +0800 (Wed, 12 Oct 2016) $
 * $LastChangedRevision: 1276 $
 * $LastChangedBy: shuaizhihu $
 */
public class LoginBlacklist implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -8152179097707967267L;
    private int id;
    private String userName;
    private Date createTime;
    private String lockReason;
    private String unlockReason;
    private int status;
    private Date operateTime;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     * the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     * the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     * the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the lockReason
     */
    public String getLockReason() {
        return lockReason;
    }

    /**
     * @param lockReason
     * the lockReason to set
     */
    public void setLockReason(String lockReason) {
        this.lockReason = lockReason;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status
     * the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the operateTime
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * @param operateTime
     * the operateTime to set
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * @return the unlockReason
     */
    public String getUnlockReason() {
        return unlockReason;
    }

    /**
     * @param unlockReason
     * the unlockReason to set
     */
    public void setUnlockReason(String unlockReason) {
        this.unlockReason = unlockReason;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "LoginBlacklist [id=" + id + ", userName=" + userName + ", createTime=" + createTime + ", lockReason=" + lockReason + ", unlockReason=" + unlockReason + ", status=" + status + ", operateTime=" + operateTime + "]";
    }

}
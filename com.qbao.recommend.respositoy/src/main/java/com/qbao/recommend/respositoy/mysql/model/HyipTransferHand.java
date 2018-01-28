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
public class HyipTransferHand implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -5181538896061895045L;
    private long id;
    private long userId;
    private String userName;
    private int type;
    private String content;
    private Date createTime;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id
     * the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the userId
     */
    public long getUserId() {
        return userId;
    }

    /**
     * @param userId
     * the userId to set
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type
     * the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     * the content to set
     */
    public void setContent(String content) {
        this.content = content;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "HyipTransferHand [id=" + id + ", userId=" + userId + ", userName=" + userName + ", type=" + type + ", content=" + content + ", createTime=" + createTime + "]";
    }

}

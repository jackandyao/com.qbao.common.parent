/**
 * 
 */
package com.qbao.recommend.respositoy.redis.model.goods.bc;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
public class BcProductStatus implements Serializable {

    private static final long serialVersionUID = "${Id}".hashCode();

    private long id;
    private Date createTime = new Date();
    private Date updateTime = new Date();

    /**
     * @param id
     * @param status
     */
    public BcProductStatus(long id) {
        super();
        this.id = id;
    }
    public BcProductStatus() {
    }

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
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime the updateTime to set
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    
    @Override
    public String toString() {
        return "BcProduct [id=" + id + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
    }

}

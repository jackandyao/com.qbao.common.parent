/**
 * 
 */
package com.qbao.recommend.respositoy.redis.model.goods.mer;

import java.io.Serializable;
import java.util.Date;

import com.qbao.recommend.respositoy.redis.model.ItemDTO;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
public class MerProductStatus implements Serializable {

    private static final long serialVersionUID = "${Id}".hashCode();
    private long id;
    private ItemDTO dto;
    private Date createTime = new Date();
    private Date updateTime = new Date();

    /**
     * @param id
     * @param status
     */
    public MerProductStatus(long id, ItemDTO dto) {
        this.id = id;
        this.dto = dto;
    }

    public MerProductStatus() {

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
     * @return the updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     * the updateTime to set
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public ItemDTO getDto() {
        return dto;
    }

    /**
     * @param dto
     * the dto to set
     */
    public void setDto(ItemDTO dto) {
        this.dto = dto;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MerProductStatus [dto=" + dto + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
    }

}

/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
public class QbdcKeywordDeptReal implements Serializable {

    private static final long serialVersionUID = "${id}".hashCode();

    private Long id; // pk

    private Long deptId; // 科室ID

    private String keyWord;// 科室关键字

    private Date createTime;

    private Date modifyTime;
    
    private int type;
    
    private int weight;
    
    private int status;

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
     * @return the modifyTime
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime
     * the modifyTime to set
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight
     * the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyword) {
        this.keyWord = keyword;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "QbdcKeywordDeptReal [id=" + id + ", deptId=" + deptId + ", keyWord=" + keyWord + ", createTime=" + createTime + ", modifyTime=" + modifyTime + ", type=" + type + ", weight=" + weight + ", status=" + status + "]";
    }

}
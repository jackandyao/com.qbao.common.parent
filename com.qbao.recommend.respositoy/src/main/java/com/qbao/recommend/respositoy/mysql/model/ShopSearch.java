/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate: 2016-10-12 18:37:40 +0800 (Wed, 12 Oct 2016) $
 * $LastChangedRevision: 1276 $
 * $LastChangedBy: shuaizhihu $
 */
public class ShopSearch implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 7050935612620259222L;
    private long id;
    private long userId;
    private long spuId;
    private long cid;
    private long sid;
    private int isBaogou;
    private Date dt;
    
    
    public int getIsBaogou() {

        return isBaogou;
    }
    public void setIsBaogou(int isBaogou) {
        this.isBaogou = isBaogou;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public long getSpuId() {
        return spuId;
    }
    public void setSpuId(long spuId) {
        this.spuId = spuId;
    }
    public long getCid() {
        return cid;
    }
    public void setCid(long cid) {
        this.cid = cid;
    }
    public long getSid() {
        return sid;
    }
    public void setSid(long sid) {
        this.sid = sid;
    }
    public Date getDt() {
        return dt;
    }
    public void setDt(Date dt) {
        this.dt = dt;
    }
}

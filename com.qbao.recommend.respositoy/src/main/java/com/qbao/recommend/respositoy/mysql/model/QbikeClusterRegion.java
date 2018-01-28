package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;

/**
 * @author sjzhangjun
 * @createTime 下午4:53
 * $$LastChangedDate: 2016-10-27 21:31:15 +0800 (星期四, 27 十月 2016) $$
 * $$LastChangedRevision: 1336 $$
 * $$LastChangedBy:  $$
 */
public class QbikeClusterRegion implements Serializable {
    private static final long serialVersionUID = "$Id$".hashCode();
    private long id;
    private int clusterId;
    private String points;
    private long seqId;
    private String updateTime;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getClusterId() {
		return clusterId;
	}
	public void setClusterId(int clusterId) {
		this.clusterId = clusterId;
	}
	public String getPoints() {
		return points;
	}
	public void setPoints(String points) {
		this.points = points;
	}
	public long getSeqId() {
		return seqId;
	}
	public void setSeqId(long seqId) {
		this.seqId = seqId;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
    
    
}

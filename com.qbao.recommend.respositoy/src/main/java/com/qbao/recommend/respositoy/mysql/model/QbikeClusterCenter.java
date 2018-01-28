package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;

/**
 * @author sjzhangjun
 * @createTime 下午4:53
 * $$LastChangedDate: 2016-10-27 21:31:15 +0800 (星期四, 27 十月 2016) $$
 * $$LastChangedRevision: 1336 $$
 * $$LastChangedBy:  $$
 */
public class QbikeClusterCenter implements Serializable {
    private static final long serialVersionUID = "$Id$".hashCode();
    private long id;
    private int clusterId;
    private double longitude;
    private double latitude;
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
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
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

package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;

/**
 * @author sjzhangjun
 * @createTime 下午4:53
 * $$LastChangedDate: 2016-10-27 21:31:15 +0800 (星期四, 27 十月 2016) $$
 * $$LastChangedRevision: 1336 $$
 * $$LastChangedBy:  $$
 */
public class QbikeCluster implements Serializable {
    private static final long serialVersionUID = "$Id$".hashCode();
    private long id;
    private Integer clusterId;
    private Integer fClusterId;
    private double longitude;
    private double latitude;
    private long seqId;
    private String updateTime;
    private String city;
    private String putCityId;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getClusterId() {
		return clusterId;
	}
	public void setClusterId(Integer clusterId) {
		this.clusterId = clusterId;
	}
	public Integer getfClusterId() {
		return fClusterId;
	}
	public void setfClusterId(Integer fClusterId) {
		this.fClusterId = fClusterId;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPutCityId() {
		return putCityId;
	}
	public void setPutCityId(String putCityId) {
		this.putCityId = putCityId;
	}
    
}

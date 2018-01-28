/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service;

import java.util.List;

import com.qbao.recommend.respositoy.mysql.model.QbikeCluster;
import com.qbao.recommend.respositoy.mysql.model.QbikeClusterCenter;
import com.qbao.recommend.respositoy.mysql.model.QbikeClusterRegion;
import com.qbao.recommend.respositoy.mysql.model.QbikeFlow;

/**
 * @author zhangjun
 */
public interface IQbikeService{
	public List<QbikeCluster> findQbikeCluster();
	public List<QbikeClusterCenter> findQbikeClusterCenter();
	public List<QbikeClusterRegion> findQbikeClusterRegion();
	public List<QbikeCluster> findQbikeUserCluster();
	public List<QbikeClusterCenter> findQbikeUserClusterCenter();
	public List<QbikeClusterRegion> findQbikeUserClusterRegion();
	public List<QbikeFlow> findQbikeFlow();
}

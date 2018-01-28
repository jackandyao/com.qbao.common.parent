package com.qbao.recommend.business.qbike.cmp.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.qbao.recommend.business.qbike.cmp.service.IQbikeClusterService;
import com.qbao.recommend.respositoy.mysql.model.QbikeCluster;
import com.qbao.recommend.respositoy.mysql.model.QbikeClusterCenter;
import com.qbao.recommend.respositoy.mysql.model.QbikeClusterRegion;
import com.qbao.recommend.respositoy.mysql.model.QbikeFlow;
import com.qbao.recommend.respositoy.mysql.service.IQbikeService;

@Service
public class QbikeClusterService implements IQbikeClusterService {

	@Autowired
	IQbikeService qbikeService;
	
	@Override
	public String getQbikeClusterInfo() {
		List<QbikeCluster> qbikeClusterList = qbikeService.findQbikeCluster();
		List<QbikeClusterCenter> qbikeClusterCenterList = qbikeService.findQbikeClusterCenter();
		List<QbikeClusterRegion> qbikeClusterRegionList = qbikeService.findQbikeClusterRegion();
		List<QbikeCluster> qbikeUserClusterList = qbikeService.findQbikeUserCluster();
		List<QbikeClusterCenter> qbikeUserClusterCenterList = qbikeService.findQbikeUserClusterCenter();
		List<QbikeClusterRegion> qbikeUserClusterRegionList = qbikeService.findQbikeUserClusterRegion();
		List<QbikeFlow> qbikeFlowList = qbikeService.findQbikeFlow();
		
		Map<String,Object> map = Maps.newHashMap();
		
		List<Map<String,Object>> qbikeClusterJsonList = Lists.newArrayList();
		for(QbikeCluster qbikeCluster : qbikeClusterList){
			Map<String,Object> qbikeEachCluster = Maps.newHashMap();
			qbikeEachCluster.put("clusterId", qbikeCluster.getClusterId());
			qbikeEachCluster.put("latitude", qbikeCluster.getLatitude());
			qbikeEachCluster.put("longitude", qbikeCluster.getLongitude());
			qbikeEachCluster.put("city", qbikeCluster.getCity());
			qbikeEachCluster.put("putCityId", qbikeCluster.getPutCityId());
			qbikeEachCluster.put("type", 1);
			qbikeClusterJsonList.add(qbikeEachCluster);
			
			if(qbikeCluster.getfClusterId() != null){
				qbikeEachCluster = Maps.newHashMap();
				qbikeEachCluster.put("clusterId", qbikeCluster.getfClusterId());
				qbikeEachCluster.put("latitude", qbikeCluster.getLatitude());
				qbikeEachCluster.put("longitude", qbikeCluster.getLongitude());
				qbikeEachCluster.put("type", 2);
				qbikeClusterJsonList.add(qbikeEachCluster);
			}
		}
		map.put("qbikeCluster", qbikeClusterJsonList);
		
		List<Map<String,Object>> qbikeClusterCenterJsonList = Lists.newArrayList();
		for(QbikeClusterCenter qbikeClusterCenter : qbikeClusterCenterList){
			Map<String,Object> qbikeEachClusterCenter = Maps.newHashMap();
			qbikeEachClusterCenter.put("clusterId", qbikeClusterCenter.getClusterId());
			qbikeEachClusterCenter.put("latitude", qbikeClusterCenter.getLatitude());
			qbikeEachClusterCenter.put("longitude", qbikeClusterCenter.getLongitude());
			qbikeClusterCenterJsonList.add(qbikeEachClusterCenter);
			
		}
		map.put("qbikeClusterCenter", qbikeClusterCenterJsonList);
		
		List<Map<String,Object>> qbikeClusterRegionJsonList = Lists.newArrayList();
		for(QbikeClusterRegion qbikeClusterRegion : qbikeClusterRegionList){
			Map<String,Object> qbikeEachClusterRegion = Maps.newHashMap();
			qbikeEachClusterRegion.put("clusterId", qbikeClusterRegion.getClusterId());
			qbikeEachClusterRegion.put("points", qbikeClusterRegion.getPoints());
			qbikeClusterRegionJsonList.add(qbikeEachClusterRegion);
			
		}
		map.put("qbikeClusterRegion", qbikeClusterRegionJsonList);
		
		
		List<Map<String,Object>> userClusterJsonList = Lists.newArrayList();
		for(QbikeCluster userCluster : qbikeUserClusterList){
			Map<String,Object> userEachCluster = Maps.newHashMap();
			userEachCluster.put("clusterId", userCluster.getClusterId());
			userEachCluster.put("latitude", userCluster.getLatitude());
			userEachCluster.put("longitude", userCluster.getLongitude());
			userEachCluster.put("type", 2);
			userClusterJsonList.add(userEachCluster);
			
			if(userCluster.getfClusterId() != null){
				userEachCluster = Maps.newHashMap();
				userEachCluster.put("clusterId", userCluster.getfClusterId());
				userEachCluster.put("latitude", userCluster.getLatitude());
				userEachCluster.put("longitude", userCluster.getLongitude());
				userEachCluster.put("type", 1);
				userClusterJsonList.add(userEachCluster);
			}
		}
		map.put("userCluster", userClusterJsonList);
		
		List<Map<String,Object>> userClusterCenterJsonList = Lists.newArrayList();
		for(QbikeClusterCenter userClusterCenter : qbikeUserClusterCenterList){
			Map<String,Object> userEachClusterCenter = Maps.newHashMap();
			userEachClusterCenter.put("clusterId", userClusterCenter.getClusterId());
			userEachClusterCenter.put("latitude", userClusterCenter.getLatitude());
			userEachClusterCenter.put("longitude", userClusterCenter.getLongitude());
			userClusterCenterJsonList.add(userEachClusterCenter);
			
		}
		map.put("userClusterCenter", userClusterCenterJsonList);
		
		List<Map<String,Object>> userClusterRegionJsonList = Lists.newArrayList();
		for(QbikeClusterRegion userClusterRegion : qbikeUserClusterRegionList){
			Map<String,Object> userEachClusterRegion = Maps.newHashMap();
			userEachClusterRegion.put("clusterId", userClusterRegion.getClusterId());
			userEachClusterRegion.put("points", userClusterRegion.getPoints());
			userClusterRegionJsonList.add(userEachClusterRegion);
			
		}
		map.put("userClusterRegion", userClusterRegionJsonList);
		
		List<Map<String,Object>> qbikeFlowJsonList = Lists.newArrayList();
		for(QbikeFlow qbikeFlow : qbikeFlowList){
			Map<String,Object> qbikeEachFlow = Maps.newHashMap();
			qbikeEachFlow.put("fromClusterId", qbikeFlow.getFromClusterId());
			qbikeEachFlow.put("toClusterId", qbikeFlow.getToClusterId());
			qbikeEachFlow.put("flowCounts", qbikeFlow.getFlowCounts());
			qbikeFlowJsonList.add(qbikeEachFlow);
			
		}
		map.put("qbikeFlow", qbikeFlowJsonList);
		
		return JSON.toJSONString(map);
	}

}

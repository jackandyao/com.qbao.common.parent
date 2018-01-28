package com.qbao.recommend.business.qbike.rest.impl;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.qbao.recommend.business.qbike.cmp.service.IQbikeClusterService;
import com.qbao.recommend.business.qbike.rest.IQbikeService;

@Path("qbike")
public class QbikeService implements IQbikeService{

	@Autowired
    IQbikeClusterService qbikeClusterService;
	
	@GET
	@Override
	@Path("/clusterinfo")
	@Produces(ContentType.APPLICATION_JSON_UTF_8)
	public Map<String, Object> getQbikeClusterInfo() {
		Map<String, Object> map = new HashMap<String, Object>();
		String json = qbikeClusterService.getQbikeClusterInfo();
		if(json!=null){
			map.put("status", 200);
			map.put("message", "success");
			map.put("data", json);
		} else {
			map.put("status", -1);
			map.put("message", "fail");
		}
		
		return map;
	}
	
}

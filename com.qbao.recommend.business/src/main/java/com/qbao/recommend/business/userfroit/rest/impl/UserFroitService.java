package com.qbao.recommend.business.userfroit.rest.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.qbao.recommend.business.userfroit.rest.IUserFroitService;

@Path("task")
public class UserFroitService implements IUserFroitService{

	@GET
	@Override
	@Path("/userFroit")
	@Produces(ContentType.APPLICATION_JSON_UTF_8)
	public Map<String, Object> getUserFroit(@QueryParam("userId")long userId, @QueryParam("joinFee")long joinFee, @QueryParam("days")int days) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", 0);
		map.put("message", "success");
//		map.put("froit", (random.nextInt(10)+35)/100.0d);
//		1=<joinFee<2000	0.000210623
//				2000=<joinFee<10000	0.000794212
//				10000=<joinFee<40000	0.000876808
//						10000=<joinFee<50000	0.000880105
//						50000=<joinFee<100000	0.000899585
//						100000=<joinFee<200000	0.000954626
//						200000=<joinFee	0.000970185
		double perDayFroit = 0.0d;
		if(joinFee<2000) perDayFroit = 0.000210623;
		else if(joinFee<10000) perDayFroit = 0.000794212;
		else if(joinFee<40000) perDayFroit = 0.000876808;
		else if(joinFee<50000) perDayFroit = 0.000880105;
		else if(joinFee<100000) perDayFroit = 0.000899585;
		else if(joinFee<200000) perDayFroit = 0.000954626;
		else perDayFroit = 0.000970185;
		map.put("froit", perDayFroit*365);
		return map;
	}

}

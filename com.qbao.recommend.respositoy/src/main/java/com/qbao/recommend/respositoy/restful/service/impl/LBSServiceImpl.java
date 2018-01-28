package com.qbao.recommend.respositoy.restful.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;
import com.qbao.recommend.respositoy.restful.entities.User;
import com.qbao.recommend.respositoy.restful.service.ILBSService;
import com.qbao.recommend.respositoy.restful.util.ConstantUtil;
import com.qbao.recommend.util.http.HttpClientUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author linhanye
 *
 *         $LastChangedDate: 2016-11-15 18:38:46 +0800 (周一, 19 九月 2016) $
 *         $LastChangedRevision: 1071 $ $LastChangedBy: linhanye $
 */

@Service("lBSServiceImpl")
public class LBSServiceImpl implements ILBSService {
	private static DecimalFormat df = new DecimalFormat("0.00");
	@Value("${lbs.ak}")
	private String ak;

	@Value("${lbs.secretKey}")
	private String secretKey;

	@Value("${lbs.url}")
	private String url;



	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qbao.recommend.respositoy.mysql.service.IHyipTaskService#
	 * findTasksOrderByMargins(int, int)
	 */
	@Override
	@RedisCache(expire = 60 * 2, clazz = User.class, cacheType = CacheType.LIST)
	public List<User> queryUsersNearby(Map p) throws IOException {
		p.put("ak", ak);
		p.put("secretKey", secretKey);
		p.put("sign", HttpClientUtils.sign(p));

		String json = HttpClientUtils.doPost(JSONObject.toJSONString(p), url + ConstantUtil.LBS_NEARBY_URL);
		JSONObject object = JSONObject.parseObject(json);
		if ("ok".equalsIgnoreCase(object.getString("info")) || 0 == object.getIntValue("status")) {
			JSONArray list = object.getJSONArray("result");
			List<User> userList = new ArrayList<>();
			for (Object d : list) {
				User user = new User();
				user.setId(((JSONObject) d).getLong("user_id"));
				user.setName(((JSONObject) d).getString("name"));
				user.setDistance(Double.valueOf(df.format(((JSONObject) d).getDouble("distance"))));
				userList.add(user);
			}
			return userList;
		}
		return null;
	}
}

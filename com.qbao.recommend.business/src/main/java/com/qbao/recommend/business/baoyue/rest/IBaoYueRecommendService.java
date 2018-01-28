package com.qbao.recommend.business.baoyue.rest;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author wangping
 * @createTime 上午10:32
 * $$LastChangedDate: 2016-11-25 15:23:56 +0800 (Fri, 25 Nov 2016) $$
 * $$LastChangedRevision: 1491 $$
 * $$LastChangedBy: wangping $$
 */
public interface IBaoYueRecommendService {


    JSONObject setup();

    Map<String, Object> recommend(long themeId, String theme ,double lat, double lon, long range, int limit);

}

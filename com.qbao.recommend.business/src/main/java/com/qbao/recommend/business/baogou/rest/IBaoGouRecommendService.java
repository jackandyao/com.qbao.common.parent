package com.qbao.recommend.business.baogou.rest;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author wangping
 * @createTime 下午2:22
 * $$LastChangedDate: 2016-11-21 13:57:50 +0800 (Mon, 21 Nov 2016) $$
 * $$LastChangedRevision: 1421 $$
 * $$LastChangedBy: wangping $$
 */
public interface IBaoGouRecommendService {

    Map<String, Object> fetchTopViewSpu(int limit);

    Map<String, Object> fetchHaoHuoIndex(long baoGouId);

    Map<String, Object> batchFetchHaoHuoIndex(String baoGouIds);

    JSONObject setup();

    Map<String,Object>  fetchGoodsSaleNum(long spuId,String startDate,String endDate);
}

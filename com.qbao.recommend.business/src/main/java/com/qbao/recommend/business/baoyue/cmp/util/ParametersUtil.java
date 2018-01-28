package com.qbao.recommend.business.baoyue.cmp.util;

import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.alarm.util.MessageConstanUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangping
 * @createTime 上午11:46
 * $$LastChangedDate: 2016-11-25 15:33:07 +0800 (Fri, 25 Nov 2016) $$
 * $$LastChangedRevision: 1492 $$
 * $$LastChangedBy: wangping $$
 */
public class ParametersUtil {

    public static Map<String, Object> wrap( String serviceName,long themeId ,String title , double lat, double lon,long range, int limit) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(MessageConstanUtil.ALARM_CLASS_NAME, serviceName);
        params.put(BaoYueConstantUtil.THEME_ID, themeId);
        params.put(BaoYueConstantUtil.TITLE, title);
        params.put(BaoYueConstantUtil.LAT, lat);
        params.put(BaoYueConstantUtil.LON, lon);
        params.put(BaoYueConstantUtil.RANGE, range);
        params.put(BaoYueConstantUtil.LIMIT, limit);
        return params;
    }

    public static Object getParameter(Map<String, Object> params, String key, Object defaultValue) {
        return params.containsKey(key) ? params.get(key) : defaultValue;
    }

    public static Object getParameter( JSONObject context , String key, Object defaultValue) {
       return context.containsKey(key) ?  context.get(key) : defaultValue;
    }

    public static Object getParameter(Map<String, Object> params, String key) {
        return params.get(key);
    }
}
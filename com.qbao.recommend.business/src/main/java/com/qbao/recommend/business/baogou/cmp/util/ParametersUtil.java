package com.qbao.recommend.business.baogou.cmp.util;

import com.qbao.recommend.alarm.util.MessageConstanUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangping
 * @createTime 下午3:01
 * $$LastChangedDate: 2016-11-15 18:34:23 +0800 (Tue, 15 Nov 2016) $$
 * $$LastChangedRevision: 1398 $$
 * $$LastChangedBy: wangping $$
 */
public class ParametersUtil {
    public static Map<String, Object> wrap(String serviceName, int limit) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(MessageConstanUtil.ALARM_CLASS_NAME, serviceName);
        params.put(BaoGouConstantUtil.LIMIT, limit);
        return params;
    }

    public static Object getParameter(Map<String, Object> params, String key, Object defaultValue) {
        return params.containsKey(key) ? params.get(key) : defaultValue;
    }

    public static Object getParameter(Map<String, Object> params, String key) {
        return params.get(key);
    }
}

/**
 * 
 */
package com.qbao.recommend.business.tweet.cmp.util;

import java.util.HashMap;
import java.util.Map;
import com.qbao.recommend.alarm.util.MessageConstanUtil;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-27 19:29:01 +0800 (Tue, 27 Sep 2016) $
 * $LastChangedRevision: 1180 $
 * $LastChangedBy: wangping $
 */
public class ParametersUtil {

    public static Map<String, Object> wrap(long userId, String serviceName, String devType, int dlSize, int total) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(TweetConstantUtil.USER_ID, userId);
        params.put(TweetConstantUtil.TOTAL_SIZE, total);
        params.put(TweetConstantUtil.DL_SIZE, dlSize);
        params.put(TweetConstantUtil.DEV_TYPE, devType);
        params.put(MessageConstanUtil.ALARM_CLASS_NAME, serviceName);
        return params;
    }

    public static Object getParameter(Map<String, Object> params, String key, Object defaultValue) {
        return params.containsKey(key) ? params.get(key) : defaultValue;
    }

    public static Object getParameter(Map<String, Object> params, String key) {
        return params.get(key);
    }
}

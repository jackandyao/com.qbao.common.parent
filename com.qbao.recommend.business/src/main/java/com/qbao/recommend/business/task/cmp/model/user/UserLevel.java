/**
 * 
 */
package com.qbao.recommend.business.task.cmp.model.user;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-13 22:24:14 +0800 (Tue, 13 Sep 2016) $
 * $LastChangedRevision: 1016 $
 * $LastChangedBy: wangping $
 */
public enum UserLevel {
    P_LV1("p_lv1"), P_LV2("p_lv2"), P_LV3("p_lv3"), P_LV4("p_lv4"), P_LV5("p_lv5"), P_LV6("p_lv6"), P_LV7("p_lv7"), UNKNOW("");
    private String value;

    private UserLevel(String value) {
        this.value = value;
    }

    static HashMap<String, UserLevel> maps = new HashMap<>();
    static {
        for (UserLevel item : UserLevel.values()) {
            maps.put(StringUtils.upperCase(item.value), item);
        }
    }

    public static UserLevel asUserLevel(String value) {
        return maps.get(StringUtils.upperCase(StringUtils.trimToEmpty(value)));
    }

}

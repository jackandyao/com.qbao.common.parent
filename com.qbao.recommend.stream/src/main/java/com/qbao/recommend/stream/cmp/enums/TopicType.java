/**
 * 
 */
package com.qbao.recommend.stream.cmp.enums;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
public enum TopicType {

    NGIX_WEB("ngix_web"), MONITOR_BC_PRODUCT_STATUS_TOPIC("monitor_bc_product_status_topic"), MONITOR_MER_SPU_STATUS_TOPIC("monitor_mer_spu_status_topic");
    
    private String value;
    private TopicType(String value) {
        this.value = value;
    }

    private static HashMap<String, TopicType> maps = new HashMap<>();
    static {
        for (TopicType topic : TopicType.values()) {
            maps.put(StringUtils.upperCase(topic.value), topic);
        }
    }

    public static TopicType asTopicType(String value) {
        return maps.get(StringUtils.upperCase(value));
    }
}

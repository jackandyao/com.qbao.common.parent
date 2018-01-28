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
public enum BinLogOperationType {
    INSERT("insert"), UPDATE("update"), DELETE("delete");
  
    private String value;

    private BinLogOperationType(String value) {
        this.value = value;
    }

    private static HashMap<String, BinLogOperationType> maps = new HashMap<>();
    static {
        for (BinLogOperationType type : BinLogOperationType.values()) {
            maps.put(StringUtils.upperCase(type.value), type);
        }
    }

    public static BinLogOperationType asBinLogOperationType(String value) {
        return maps.get(StringUtils.upperCase(value));
    }

}

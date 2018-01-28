/**
 * 
 */
package com.qbao.recommend.stream.cmp.enums;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;


/**
 *   日志平台来源类型
     * @author 贾红平
     *
     * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
     * $LastChangedRevision: 896 $
     * $LastChangedBy: jiahongping $
 */
public enum PlatformType {
     
    WEB("web"), BINLOG("binlog");

    private String value;

    private PlatformType(String value) {
        this.value = value;
    }

    private static HashMap<String, PlatformType> maps = new HashMap<>();
    static {
        for (PlatformType paltform : PlatformType.values()) {
            maps.put(StringUtils.upperCase(paltform.value), paltform);
        }
    }

    public static void main(String[] args) {
        System.out.println(PlatformType.asPlatformType("Binlog"));
    }

    public static PlatformType asPlatformType(String value) {
        return maps.get(StringUtils.upperCase(value));
    }
}

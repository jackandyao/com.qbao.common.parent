/**
 * 
 */
package com.qbao.recommend.stream.cmp.enums;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

/**
 *   数据业务来源类型
     * @author 贾红平
     * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
     * $LastChangedRevision: 896 $
     * $LastChangedBy: jiahongping $
 */
public enum SourceType {
    
    BAO_GOU("baogu"), MERCHANT("merchant"),MER_SPU("mer_spu"), BC_PRODUCT("bc_product"), CSC_CART_DETAIL("cscCartDetail"), FAVORITE("favorite");

    private String value;

    private SourceType(String value) {
        this.value = value;
    }

    private static HashMap<String, SourceType> maps = new HashMap<>();
    
    static {
        for (SourceType paltform : SourceType.values()) {
            maps.put(StringUtils.upperCase(paltform.value), paltform);
        }
    }

    public static void main(String[] args) {
        System.out.println(PlatformType.asPlatformType("Binlog"));
    }

    public static SourceType asSourceType(String value) {
        return maps.get(StringUtils.upperCase(value));
    }
}

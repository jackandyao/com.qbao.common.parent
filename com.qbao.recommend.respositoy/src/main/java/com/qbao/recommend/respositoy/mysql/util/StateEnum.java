package com.qbao.recommend.respositoy.mysql.util;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;

/**
 * @author wangping
 * @createTime 下午1:39
 * $$LastChangedDate: 2016-11-10 14:50:12 +0800 (Thu, 10 Nov 2016) $$
 * $$LastChangedRevision: 1378 $$
 * $$LastChangedBy: wangping $$
 */
public enum StateEnum {
    推文已存在("DUPLICATE"), 提交成功("SUCCESS"),推文池不存在该推文("NOT_EXIST"),提交失败("FAIL");
    static HashMap<String, StateEnum> maps = new HashMap<>();

    static {
        for (StateEnum item : StateEnum.values()) {
            maps.put(StringUtils.upperCase(item.value), item);
        }
    }

    private String value;

    private StateEnum(String value) {
        this.value = value;
    }

    public static StateEnum asStateEnum(String value) {
        return maps.get(StringUtils.upperCase(StringUtils.trimToEmpty(value)));
    }
}

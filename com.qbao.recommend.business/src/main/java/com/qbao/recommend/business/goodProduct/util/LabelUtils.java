package com.qbao.recommend.business.goodProduct.util;

import org.apache.commons.lang.StringUtils;

/**
 * @author wangping
 * @createTime 下午3:46
 * $$LastChangedDate: 2016-10-28 16:23:42 +0800 (Fri, 28 Oct 2016) $$
 * $$LastChangedRevision: 1345 $$
 * $$LastChangedBy: wangping $$
 */
public class LabelUtils {

    public static String formatLabel(String label){
        label = StringUtils.trimToEmpty(label);
        if(StringUtils.length(label) > 10){
            label = StringUtils.substring(label,0,7)+"...";
        }
        return label;
    }
}

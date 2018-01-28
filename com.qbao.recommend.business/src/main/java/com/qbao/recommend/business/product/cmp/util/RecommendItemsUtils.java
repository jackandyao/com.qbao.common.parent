/**
 * 
 */
package com.qbao.recommend.business.product.cmp.util;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.google.common.collect.Lists;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-06 17:26:00 +0800 (Tue, 06 Sep 2016) $
 * $LastChangedRevision: 906 $
 * $LastChangedBy: jiahongping $
 */
public class RecommendItemsUtils {

    public static List<Long> decodeRecommendItems(com.qbao.recommend.respositoy.mysql.model.RecommendItems item) {
        List<Long> result = Lists.newArrayList();
        if (null != item) {
            String[] spuIdPair = StringUtils.trimToEmpty(item.getSpuIds()).split(",");
            for (String pair : spuIdPair) {
                String[] spuIdAndScore = StringUtils.trim(pair).split(":");
                if (null != spuIdAndScore) {
                    result.add(NumberUtils.createLong(spuIdAndScore[0]));
                }
            }
        }
        return result;
    }

}

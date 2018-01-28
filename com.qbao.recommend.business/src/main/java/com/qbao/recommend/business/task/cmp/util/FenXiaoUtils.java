/**
 * 
 */
package com.qbao.recommend.business.task.cmp.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-13 22:24:14 +0800 (Tue, 13 Sep 2016) $
 * $LastChangedRevision: 1016 $
 * $LastChangedBy: wangping $
 */
public class FenXiaoUtils {

    private static Logger logger = Logger.getLogger(FenXiaoUtils.class);

    public static <T> void appendElements(List<T> base, List<T> candidates, int appendSize) {
        int size = 0;
        for (int index = 0; index < candidates.size(); index++) {
            T candidate = candidates.get(index);
            if (!base.contains(candidate) && size < appendSize) {
                base.add(candidate);
                logger.info("add [" + candidate + "] to base collection");
                size++;
            }
        }
    }

    public static <T> void delAgentIds(List<T> base, Collection<T> delIds) {
        for (T id : delIds) {
            if (base.contains(id)) {
                logger.info("del  [" + id + "] from  base collection");
                base.remove(id);
            }
        }
    }

    public static <T>List<T> subList(List<T> base, int startIndx, int length) {
        List<T> result = new ArrayList<T>();
        for (int i = startIndx; i < length; i++) {
            result.add(base.get(i));
        }
        return result;
    }
}
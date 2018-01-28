/**
 * 
 */
package com.qbao.recommend.business.distribution.cmp.util;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.qbao.recommend.respositoy.mysql.model.RecAgentLook;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-08-12 15:02:24 +0800 (星期五, 12 八月 2016) $
 * $LastChangedRevision: 532 $
 * $LastChangedBy: wangping $
 */
public class RecAgentLookUtils {


    public static ArrayList<Long> parseTasks(RecAgentLook recAgentLook) {
        ArrayList<Long> result = new ArrayList<>();
        if (null == recAgentLook || StringUtils.isBlank(recAgentLook.getTaskIds()))
            return result;
        String[] taskIds = StringUtils.split(recAgentLook.getTaskIds(), ConstantUtils.DELIMIT_COMM);
        for (String taskId : taskIds) {
            result.add(NumberUtils.createLong(taskId));
        }
        return result;
    }
}

/**
 * 
 */
package com.qbao.recommend.business.task.cmp.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import com.qbao.recommend.respositoy.mysql.model.RecAgentGuess;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-13 22:24:14 +0800 (Tue, 13 Sep 2016) $
 * $LastChangedRevision: 1016 $
 * $LastChangedBy: wangping $
 */
public class RecAgentGuessUtils {

    public static List<Long> parseTasks(RecAgentGuess recAgentGuess) {
        List<Long> result = new ArrayList<Long>();
        if (null == recAgentGuess || StringUtils.isBlank(recAgentGuess.getTaskIds()))
            return result;
        String[] taskIds = StringUtils.split(recAgentGuess.getTaskIds(), ConstantUtils.DELIMIT_COMM);
        for (String taskId : taskIds) {
            result.add(NumberUtils.createLong(taskId));
        }
        return result;
    }

}

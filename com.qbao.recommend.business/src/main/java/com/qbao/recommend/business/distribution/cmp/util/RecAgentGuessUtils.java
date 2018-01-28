/**
 * 
 */
package com.qbao.recommend.business.distribution.cmp.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.qbao.recommend.respositoy.mysql.model.RecAgentGuess;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-08-12 15:02:24 +0800 (星期五, 12 八月 2016) $
 * $LastChangedRevision: 532 $
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

/**
 * 
 */
package com.qbao.recommend.business.task.cmp.service;

import java.util.Map;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-12-05 18:53:02 +0800 (Mon, 05 Dec 2016) $
 * $LastChangedRevision: 1510 $
 * $LastChangedBy: wangping $
 */
public interface ITaskRecSerivce {
    public Map<String, Object> recommend(long userId,int  limit);
}

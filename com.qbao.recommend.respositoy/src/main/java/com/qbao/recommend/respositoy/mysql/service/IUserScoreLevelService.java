/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.UserScoreLevel;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-12 17:54:59 +0800 (Mon, 12 Sep 2016) $
 * $LastChangedRevision: 1008 $
 * $LastChangedBy: wangping $
 */
public interface IUserScoreLevelService {
    public UserScoreLevel findById(long userId);
}

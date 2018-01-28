/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.RecommendTweetItems;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-28 01:38:22 +0800 (Wed, 28 Sep 2016) $
 * $LastChangedRevision: 1187 $
 * $LastChangedBy: wangping $
 */
public interface IRecTweetTRService {

    RecommendTweetItems findByUserId(long userId);

}

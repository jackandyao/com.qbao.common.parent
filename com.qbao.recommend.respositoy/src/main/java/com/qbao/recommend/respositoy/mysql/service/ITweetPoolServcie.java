/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.TweetInfo;
import com.qbao.recommend.respositoy.mysql.model.TweetOwnerWapper;
import com.qbao.recommend.respositoy.mysql.util.StateEnum;

import java.util.List;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2017-01-12 15:31:24 +0800 (Thu, 12 Jan 2017) $
 * $LastChangedRevision: 1542 $
 * $LastChangedBy: wangping $
 */
public interface ITweetPoolServcie {

    public TweetInfo getTweetInfoById(long id);

    public StateEnum tweetNotify(long tweetId,int state);

    public List<TweetInfo> getAllValidTwettInfos();

    public TweetOwnerWapper getAllValidTwettInfoOwner();
}

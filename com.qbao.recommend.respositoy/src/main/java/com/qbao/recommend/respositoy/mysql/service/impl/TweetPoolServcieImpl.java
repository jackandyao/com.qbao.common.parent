/**
 *
 */
package com.qbao.recommend.respositoy.mysql.service.impl;

import com.qbao.recommend.respositoy.mysql.dao.TweetsPoolDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.TweetInfo;
import com.qbao.recommend.respositoy.mysql.model.TweetOwnerWapper;
import com.qbao.recommend.respositoy.mysql.service.ITweetPoolServcie;
import com.qbao.recommend.respositoy.mysql.util.StateEnum;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2017-01-13 23:40:32 +0800 (Fri, 13 Jan 2017) $
 * $LastChangedRevision: 1547 $
 * $LastChangedBy: wangping $
 */
@Service("tweetPoolServcieImpl")
public class TweetPoolServcieImpl implements ITweetPoolServcie {

    @Value("${tweetinfo.datasource.key}")
    private String DATASOURCE_KEY;

    @Value("${SIGN_TWEETS_POOL}")
    private String tableName;

    @Autowired
    private TweetsPoolDao tweetsPoolDao;

    @Override
    @RedisCache(expire = 60 * 2, clazz = TweetInfo.class, cacheType = CacheType.OBJECT)
    public TweetInfo getTweetInfoById(long id) {
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        return tweetsPoolDao.getTweetInfoById(tableName, id);
    }

    @Override
    public StateEnum tweetNotify(long id, int state) {
        StateEnum result = StateEnum.提交失败;
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        TweetInfo tweeInfo = tweetsPoolDao.getTweetInfoIngoreState(tableName, id);

        if (null == tweeInfo) {
            result = StateEnum.推文池不存在该推文;
        }else {
            try {
                tweetsPoolDao.insertTweet(id, state);
                result = StateEnum.提交成功;
            } catch (Exception ex) {
                result = StateEnum.推文已存在;
            }
        }
        return result;
    }

    @Override
    @RedisCache(expire = 60 * 2, clazz = TweetInfo.class, cacheType = CacheType.LIST)
    public List<TweetInfo> getAllValidTwettInfos() {
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
       return  tweetsPoolDao.getTweetInfoListByStatus(tableName, 1);
    }

    @Override
    @RedisCache(expire = 60 * 10, clazz = TweetOwnerWapper.class, cacheType = CacheType.OBJECT)
    public TweetOwnerWapper getAllValidTwettInfoOwner( ) {
        TweetOwnerWapper wapper  = new TweetOwnerWapper();
        Map<Long,Set<Long>> mapping = new HashMap<>();
        List<TweetInfo>  tweetInfos = getAllValidTwettInfos();
        for (TweetInfo tweetInfo : tweetInfos) {
            Long ownerID =tweetInfo.getBusinessId();
            if (null != ownerID && 0!=ownerID) {
                if (!mapping.containsKey(ownerID)) {
                    mapping.put(ownerID, new HashSet<Long>());
                }
                mapping.get(ownerID).add(tweetInfo.getId());
            }
        }
        wapper.setOwenrMapping(mapping);
        return wapper;
    }

}

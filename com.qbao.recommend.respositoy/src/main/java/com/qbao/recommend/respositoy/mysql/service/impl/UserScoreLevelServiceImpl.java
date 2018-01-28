/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.qbao.recommend.respositoy.mysql.dao.UserScoreLevelDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.UserScoreLevel;
import com.qbao.recommend.respositoy.mysql.service.IUserScoreLevelService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-18 11:49:02 +0800 (Sun, 18 Sep 2016) $
 * $LastChangedRevision: 1038 $
 * $LastChangedBy: shuaizhihu $
 */
@Service
public class UserScoreLevelServiceImpl implements IUserScoreLevelService {

    @Value("${recommend.datasource.key}")
    private String dataSourceKey;

    @Value("${USER_SCORE_LEVEL}")
    private String tableName;

    @Autowired
    private UserScoreLevelDao userScoreLevelDao;

    @Override
    @RedisCache(expire = 60 * 10, clazz = UserScoreLevel.class, cacheType = CacheType.OBJECT)
    public UserScoreLevel findById(long userId) {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        return userScoreLevelDao.findById(tableName, userId);
    }

}

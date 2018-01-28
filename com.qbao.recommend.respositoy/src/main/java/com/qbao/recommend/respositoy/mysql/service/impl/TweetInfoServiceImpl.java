package com.qbao.recommend.respositoy.mysql.service.impl;

import com.qbao.recommend.respositoy.mysql.dao.TweetInfoDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.TweetInfo;
import com.qbao.recommend.respositoy.mysql.service.ITweetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;
import java.util.List;

@Service("tweetInfoServiceImpl")
public class TweetInfoServiceImpl implements ITweetInfoService {

    @Value("${tweetinfo.datasource.key}")
    private String DATASOURCE_KEY;

    @Value("${TWEETINFO}")
    private String tableName;

    @Autowired
    private TweetInfoDao tweetInfoDao;

    @Override
    @RedisCache(expire = 60 * 60, clazz = TweetInfo.class, cacheType = CacheType.LIST)
    public List<TweetInfo> getTweetInfoList() {
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        return tweetInfoDao.getTweetInfoList(tableName);
    }

    @Override
   @RedisCache(expire = 60 * 60, clazz = TweetInfo.class, cacheType = CacheType.LIST)
    public List<TweetInfo> getTweetInfoListByStatus(int status) {
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        return tweetInfoDao.getTweetInfoListByStatus(tableName, status);
    }

    @Override
    @RedisCache(expire = 60 * 60, clazz = TweetInfo.class, cacheType = CacheType.OBJECT)
    public TweetInfo getTweetInfoBySn(String sn) {
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        return tweetInfoDao.getTweetInfoBySn(tableName, sn);
    }

    @Override
    @RedisCache(expire = 10 * 60, clazz = TweetInfo.class, cacheType = CacheType.OBJECT)
    public TweetInfo getTweetInfoById(long id) {
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        return tweetInfoDao.getTweetInfoById(tableName, id);
    }

}

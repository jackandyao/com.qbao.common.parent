/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.UserProfileDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.ShopSearch;
import com.qbao.recommend.respositoy.mysql.model.UserProfile;
import com.qbao.recommend.respositoy.mysql.service.IUserProfileService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-19 18:38:46 +0800 (Mon, 19 Sep 2016) $
 * $LastChangedRevision: 1071 $
 * $LastChangedBy: shuaizhihu $
 */
@Service
public class UserProfileServiceImpl implements IUserProfileService {

    @Value("${merchant_middle.datasource.key}")
    private String dataSoureKey;

    @Value("${USERPROFILE}")
    private String tableName;

    @Autowired
    UserProfileDao userProfileDao;

    @Override
    @RedisCache(expire=60*60,clazz=UserProfile.class,cacheType=CacheType.OBJECT)
    public UserProfile findById(long userId) {
        MultipleDataSource.setDataSourceKey(dataSoureKey);
        return userProfileDao.findById(tableName, userId);
    }

}

/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.LoginBlacklistDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.LoginBlacklist;
import com.qbao.recommend.respositoy.mysql.service.ILoginBlacklistService;
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
public class LoginBlacklistServiceImpl implements ILoginBlacklistService {
    @Value("${user.blacklist.datasource.key}")
    private String dataSourceKey;
    
    @Value("${LOGIN_BLACKLIST}")
    private String tableName;
    
    @Autowired
    LoginBlacklistDao loginBlacklistDao;
    
    @Override
    @RedisCache(expire = 60 * 2, clazz = LoginBlacklist.class, cacheType = CacheType.OBJECT)
    public LoginBlacklist findByUserName(String userName) {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        return loginBlacklistDao.findByUserName(tableName, userName);
    }

}

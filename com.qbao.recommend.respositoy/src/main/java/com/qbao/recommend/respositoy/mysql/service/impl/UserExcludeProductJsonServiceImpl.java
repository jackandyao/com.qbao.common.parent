package com.qbao.recommend.respositoy.mysql.service.impl;
import com.qbao.recommend.respositoy.mysql.dao.UserExcludeProductJsonDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.UserExcludeProductJson;
import com.qbao.recommend.respositoy.mysql.service.IUserExcludeProductJsonService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author wangping
 * @createTime 上午11:53
 * $$LastChangedDate: 2016-11-09 19:59:02 +0800 (Wed, 09 Nov 2016) $$
 * $$LastChangedRevision: 1377 $$
 * $$LastChangedBy: wangping $$
 */
@Service("userExcludeProductJsonServiceImpl")
public class UserExcludeProductJsonServiceImpl implements IUserExcludeProductJsonService {

    @Value("${recommend.datasource.key}")
    private String dataSourceKey;

    @Value("${USER_EXCLUDE_PRODUCT}")
    private String tableName;

    @Autowired
    private UserExcludeProductJsonDao dao;

    @Override
    @RedisCache(expire=60*60,clazz=UserExcludeProductJson.class,cacheType= CacheType.OBJECT)
    public UserExcludeProductJson findByUserId(long userId) {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        UserExcludeProductJson  obj = dao.findByUserId(tableName, userId);
        if(null == obj){
            obj = new UserExcludeProductJson();
            obj.setUserId(userId);
            obj.setJson("");
        }
        return obj;
    }

    @Override
    public void delete(long userId) {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        dao.delete(tableName, userId);
    }

    @Override
    public void insert(long userId, String json) {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        dao.insert(tableName, userId,json);
    }

    @Override
    public void update(long userId, String json) {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        dao.update(tableName, userId,json);
    }
}

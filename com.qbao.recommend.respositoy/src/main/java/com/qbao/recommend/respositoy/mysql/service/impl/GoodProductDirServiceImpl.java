package com.qbao.recommend.respositoy.mysql.service.impl;

import com.qbao.recommend.respositoy.mysql.dao.GoodProductDirDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.GoodProductDir;
import com.qbao.recommend.respositoy.mysql.model.QbdcKeywordDeptReal;
import com.qbao.recommend.respositoy.mysql.service.IGoodProductDirService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shuaizhihu on 2016/11/22.
 */

@Service
public class GoodProductDirServiceImpl implements IGoodProductDirService {

    @Value("${recommend.datasource.key}")
    private String datasource_key;

    @Autowired
    GoodProductDirDao goodProductDirDao;

    @Override
    @RedisCache(expire = 60 *1, clazz = GoodProductDir.class, cacheType = CacheType.LIST)
    public List<GoodProductDir> findList() {
        MultipleDataSource.setDataSourceKey(datasource_key);
        return goodProductDirDao.findList();
    }

    @Override
    @RedisCache(expire = 60 *1, clazz = GoodProductDir.class, cacheType = CacheType.OBJECT)
    public GoodProductDir findById(long id) {
        MultipleDataSource.setDataSourceKey(datasource_key);
        return goodProductDirDao.findById(id);
    }
}

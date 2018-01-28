package com.qbao.recommend.respositoy.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.RecommendMetadataDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.RecommendMetadata;
import com.qbao.recommend.respositoy.mysql.service.IRecommendMetadataService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;
@Service
public class RecommendMetadataServiceImpl implements IRecommendMetadataService {

    @Value("${recommend.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${RECOMMEND_METDATA}")
    private String RECOMMEND_METDATA_TABLE_NAME;
    
    @Autowired
    private RecommendMetadataDao recommendMetadataDao;
    @Override
//    @RedisCache(expire=60*10,clazz=RecommendMetadata.class,cacheType=CacheType.OBJECT)
    public RecommendMetadata findByParamKey(String key) {
        System.out.println("key:"+DATASOURCE_KEY);
        System.out.println("tablename:"+RECOMMEND_METDATA_TABLE_NAME);
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        return recommendMetadataDao.findByParamKey(RECOMMEND_METDATA_TABLE_NAME,key);
    }

}

package com.qbao.recommend.respositoy.mysql.service.impl;

import com.qbao.recommend.respositoy.mysql.dao.GRankDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.GRank;
import com.qbao.recommend.respositoy.mysql.service.IGRankThumbService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author wangping
 * @createTime 上午11:00
 * $$LastChangedDate: 2016-10-25 14:40:08 +0800 (Tue, 25 Oct 2016) $$
 * $$LastChangedRevision: 1300 $$
 * $$LastChangedBy: wangping $$
 */

@Service("gRankThumbServiceImpl")
public class GRankThumbServiceImpl implements IGRankThumbService {

    @Value("${recommend.datasource.key}")
    private String datasourceKey;

    @Value("${GRANK_THUMB}")
    private String dataTableName;

    @Autowired
    private GRankDao dao;

    @Override
    @RedisCache(expire = 60 * 60, clazz = GRank.class, cacheType = CacheType.OBJECT)
    public GRank findBySpuId(long spuId) {
        MultipleDataSource.setDataSourceKey(datasourceKey);
        return dao.findById(dataTableName, spuId);
    }
}

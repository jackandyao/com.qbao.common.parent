package com.qbao.recommend.respositoy.mysql.service.impl;

import com.qbao.recommend.respositoy.mysql.dao.GRankDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.GRank;
import com.qbao.recommend.respositoy.mysql.service.IGRankService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author wangping
 * @createTime 下午5:11
 * $$LastChangedDate: 2016-10-25 11:45:24 +0800 (Tue, 25 Oct 2016) $$
 * $$LastChangedRevision: 1296 $$
 * $$LastChangedBy: wangping $$
 */
@Service("gRankServiceImpl")
public class GRankServiceImpl implements IGRankService {
    @Value("${recommend.datasource.key}")
    private String datasourceKey;

    @Value("${GRANK}")
    private String dataTableName;

    @Autowired
    private GRankDao gRankDao;

    @Override
    @RedisCache(expire = 60 * 60, clazz = GRank.class, cacheType = CacheType.OBJECT)
    public GRank findBySpuId(long spuId) {
        MultipleDataSource.setDataSourceKey(datasourceKey);
        return gRankDao.findById(dataTableName, spuId);
    }
}

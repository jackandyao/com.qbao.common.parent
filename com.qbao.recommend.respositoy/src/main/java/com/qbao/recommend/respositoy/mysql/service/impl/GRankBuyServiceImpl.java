package com.qbao.recommend.respositoy.mysql.service.impl;

import com.qbao.recommend.respositoy.mysql.dao.GRankDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.GRank;
import com.qbao.recommend.respositoy.mysql.service.IGRankBuyService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author wangping
 * @createTime 下午5:40
 * $$LastChangedDate: 2016-10-27 18:12:26 +0800 (Thu, 27 Oct 2016) $$
 * $$LastChangedRevision: 1328 $$
 * $$LastChangedBy: wangping $$
 */
@Service("gRankBuyServiceImpl")
public class GRankBuyServiceImpl implements IGRankBuyService {
    @Value("${recommend.datasource.key}")
    private String datasourceKey;

    @Value("${GRANK_BUY}")
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

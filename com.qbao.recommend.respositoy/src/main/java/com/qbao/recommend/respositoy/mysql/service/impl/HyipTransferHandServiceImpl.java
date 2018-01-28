/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.HyipTransferHandDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.HyipTask;
import com.qbao.recommend.respositoy.mysql.model.HyipTransferHand;
import com.qbao.recommend.respositoy.mysql.service.IHyipTransferHandService;
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
public class HyipTransferHandServiceImpl implements IHyipTransferHandService {
    @Value("${shop.blacklist.datasource.key}")
    private String dataSourceKey;

    @Value("${HYIP_TRANSFER_HAND}")
    private String tableName;

    @Autowired
    HyipTransferHandDao hyipTransferHandDao;

    @Override
    @RedisCache(expire = 60 * 2, clazz = HyipTransferHand.class, cacheType = CacheType.OBJECT)
    public HyipTransferHand findByUserId(long userId) {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        return hyipTransferHandDao.findByUserId(tableName, userId);
    }

    @Override
    @RedisCache(expire = 60 * 2, clazz = HyipTransferHand.class, cacheType = CacheType.OBJECT)
    public HyipTransferHand findByUserName(String userName) {
        MultipleDataSource.setDataSourceKey(dataSourceKey);
        return hyipTransferHandDao.findByUserName(tableName, userName);
    }

}

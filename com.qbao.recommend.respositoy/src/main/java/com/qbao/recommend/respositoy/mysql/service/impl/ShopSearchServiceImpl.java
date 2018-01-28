/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.ShopSearchDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.ShopProfile;
import com.qbao.recommend.respositoy.mysql.model.ShopSearch;
import com.qbao.recommend.respositoy.mysql.service.IShopSearchService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;



/**
 * @author shuaizhihu
 *
 * $LastChangedDate: 2016-09-19 18:38:46 +0800 (Mon, 19 Sep 2016) $
 * $LastChangedRevision: 1071 $
 * $LastChangedBy: shuaizhihu $
 */
@Service
public class ShopSearchServiceImpl implements IShopSearchService{
    
    @Value("${merchant_middle.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${SHOP_SEARCH}")
    private String DATATABLE_NAME;
    
    @Autowired
    ShopSearchDao shopSearchDao;

    /* (non-Javadoc)
     * @see com.qbao.dc.mysql.service.IShopSearchService#findList(int, int)
     */
    @Override
    @RedisCache(expire=60*60,clazz=ShopSearch.class,cacheType=CacheType.LIST)
    public List<ShopSearch> findList(int page, int pageSize) {
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        int start = (page - 1)*pageSize;
        int rows =pageSize;
       return  shopSearchDao.findListByLimit(DATATABLE_NAME, start, rows);
    }

}

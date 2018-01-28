/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.BcProductDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.ProductProfile;
import com.qbao.recommend.respositoy.mysql.model.SpuInfoBaogou;
import com.qbao.recommend.respositoy.mysql.page.Page;
import com.qbao.recommend.respositoy.mysql.service.IBcProductService;
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
public class BcProductServiceImpl implements IBcProductService{
    
    @Value("${qbaochou.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${BC_PRODUCT}")
    private String DATATABLE_NAME;
    
    @Autowired
    BcProductDao bcProductDao;

    /* (non-Javadoc)
     * @see com.qbao.dc.mysql.service.IBcProductService#findByLimit(int, int)
     */
    @Override
    @RedisCache(expire = 60 * 2, clazz = SpuInfoBaogou.class, cacheType = CacheType.LIST)
    public List<SpuInfoBaogou> findByLimit(int page, int pageSize) {
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        int start = (page-1)*pageSize;
        int rows = pageSize;
        return  bcProductDao.findByLimit(DATATABLE_NAME, start, rows);
    }

    @Override
//    @RedisCache(expire = 60 * 2, clazz = Page<SpuInfoBaogou>.class, cacheType = CacheType.LIST)
    public Page<SpuInfoBaogou> findBcProductSellingPage(int pageIndex, int pageSize) {
    	MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		int start = (pageIndex-1)*pageSize;
		int rows = pageSize;
		int total =bcProductDao.getSellingTotal(DATATABLE_NAME);
		List<SpuInfoBaogou> list = bcProductDao.findSellingByLimit(DATATABLE_NAME, start, rows);
		Page<SpuInfoBaogou> page = new Page<SpuInfoBaogou>(total, pageIndex, pageSize, list);
		return page;
	}

	@Override
	@RedisCache(expire = 60 * 2, clazz = SpuInfoBaogou.class, cacheType = CacheType.OBJECT)
    public SpuInfoBaogou findBySpuId(long spuId) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		SpuInfoBaogou baogou = bcProductDao.findBySpuId(DATATABLE_NAME, spuId);
		return baogou;
	}

	@Override
	@RedisCache(expire = 60 * 2, clazz = Long.class, cacheType = CacheType.LIST)
	public List<Long> findSellingAll() {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		List<Long> spuIds = bcProductDao.findSellingAll(DATATABLE_NAME);
		return spuIds;
	}

	@Override
	@RedisCache(expire = 60 * 2, clazz = SpuInfoBaogou.class, cacheType = CacheType.OBJECT)
    public SpuInfoBaogou findSellingById(long id) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		SpuInfoBaogou baogou = bcProductDao.findSellingById(DATATABLE_NAME, id);
		return baogou != null?baogou:null;
	}

	@Override
	@RedisCache(expire = 60 * 2, clazz = SpuInfoBaogou.class, cacheType = CacheType.OBJECT)
	public SpuInfoBaogou findById(long id) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		SpuInfoBaogou baogou = bcProductDao.findById(DATATABLE_NAME, id);
		return baogou != null?baogou:null;
	}
}

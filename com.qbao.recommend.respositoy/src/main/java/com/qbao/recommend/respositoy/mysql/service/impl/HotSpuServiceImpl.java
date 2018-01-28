package com.qbao.recommend.respositoy.mysql.service.impl;

import com.qbao.recommend.respositoy.mysql.dao.HotSpuDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.HotSpuSearch;
import com.qbao.recommend.respositoy.mysql.service.IHotSpuService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotSpuServiceImpl implements IHotSpuService {
    
    @Value("${merchant_middle.datasource.key}")
    private String DATASOURCE_KEY;

	@Value("${HOT_SPU_BAOGOU}")
	private String HOT_SPU_BAOGOU;
	
	@Value("${HOT_SPU_MERCHANT}")
	private String HOT_SPU_MERCHANT;
	
	@Value("${HOT_SPU_SEARCH}")
	private String HOT_SPU_SEARCH;
	
	@Autowired
	private HotSpuDao hotSpuDao;
	
	@Override
	@RedisCache(expire = 60 * 10, clazz = Long.class, cacheType = CacheType.LIST)
	public List<Long> findAllSpuIdofHotSpuMerchant() {
	    MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return hotSpuDao.getAllSpuIdfromHotSpuMerchant(HOT_SPU_MERCHANT);
	}

	@Override
	@RedisCache(expire = 60 * 10, clazz = Long.class, cacheType = CacheType.LIST)
    public List<Long> findAllBaogouIdofHotSpuBaogou() {
	    MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return hotSpuDao.getAllBaogouIdfromHotSpuBaogou(HOT_SPU_BAOGOU);
	}

    /* (non-Javadoc)
     * @see com.qbao.recommend.respositoy.mysql.service.IHotSpuService#getAllSpuIdFromHotSpuSearch()
     */
    @Override
    @RedisCache(expire = 60 * 10, clazz = Long.class, cacheType = CacheType.LIST)
    public List<Long> getAllSpuIdFromHotSpuSearch() {
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        return hotSpuDao.getAllBaogouIdfromHotSpuBaogou(HOT_SPU_SEARCH);
    }

	@Override
	@RedisCache(expire = 60 * 10, clazz = HotSpuSearch.class, cacheType = CacheType.LIST)
	public List<HotSpuSearch> getALLHotSpuSearch() {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return hotSpuDao.getAllHotSpuSearch(HOT_SPU_SEARCH);
	}
}

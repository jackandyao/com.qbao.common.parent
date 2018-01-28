package com.qbao.recommend.respositoy.mysql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.CategoryDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.Category;
import com.qbao.recommend.respositoy.mysql.service.ICategoryService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Value("${baoyue.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${CATEGORY}")
    private String CATEGORY;
    
    @Autowired
    private CategoryDao categoryDao;
    
	@Override
	@RedisCache(expire = 60 * 60, clazz = Category.class, cacheType = CacheType.LIST)
	public List<Category> findAll() {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return categoryDao.findAll(CATEGORY);
	}

	@Override
	@RedisCache(expire = 60 * 60, clazz = Category.class, cacheType = CacheType.OBJECT)
	public Category getCategoryById(long id) {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return categoryDao.getCategoryById(CATEGORY, id);
	}

}

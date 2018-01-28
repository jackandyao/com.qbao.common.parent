/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service;

import java.util.List;

import com.qbao.recommend.respositoy.mysql.model.Category;

/**
 * @author zhangjun
 */
public interface ICategoryService{
	public List<Category> findAll();
	public Category getCategoryById(long id);
}

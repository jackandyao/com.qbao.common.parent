/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service;

import java.util.List;

import com.qbao.recommend.respositoy.mysql.model.BYKeyword;

/**
 * @author zhangjun
 */
public interface IBYKeywordService{
	public List<BYKeyword> findAll();
}

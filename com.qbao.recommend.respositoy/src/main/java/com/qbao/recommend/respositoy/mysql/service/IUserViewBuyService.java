/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service;

import java.util.List;

import com.qbao.recommend.respositoy.mysql.model.UserViewBuy;

/**
 * @author zhangjun
 */
public interface IUserViewBuyService{
	public List<UserViewBuy> findById(long id);
}

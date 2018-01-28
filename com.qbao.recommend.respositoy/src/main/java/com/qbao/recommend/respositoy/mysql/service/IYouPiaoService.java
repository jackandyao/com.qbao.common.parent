/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service;

import java.util.List;

/**
 * @author zhangjun
 */
public interface IYouPiaoService{
	public List<String> findAllFilmName();
	public List<String> findAllShowTitle();
}

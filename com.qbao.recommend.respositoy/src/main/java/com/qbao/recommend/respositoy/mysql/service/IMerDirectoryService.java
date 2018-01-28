/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.MerDirectory;

/**
 * @author zhangjun
 */
public interface IMerDirectoryService{
	public MerDirectory findByDirId(String dirId);
}

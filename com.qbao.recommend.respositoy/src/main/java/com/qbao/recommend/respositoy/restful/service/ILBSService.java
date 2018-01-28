package com.qbao.recommend.respositoy.restful.service;

import com.qbao.recommend.respositoy.restful.entities.User;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author linhanye
 *
 *         $LastChangedDate: 2016-11-15 18:38:46 +0800 (周一, 19 九月 2016) $
 *         $LastChangedRevision: 1071 $ $LastChangedBy: linhanye $
 */
public interface ILBSService {

	/**
	 * @param p
	 * @return
	 */
	public List<User> queryUsersNearby(Map p) throws IOException;

}

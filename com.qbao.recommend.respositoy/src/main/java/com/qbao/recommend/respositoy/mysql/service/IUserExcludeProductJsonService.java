package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.UserExcludeProductJson;

/**
 * @author wangping
 * @createTime 上午11:53
 * $$LastChangedDate: 2016-11-09 19:59:02 +0800 (Wed, 09 Nov 2016) $$
 * $$LastChangedRevision: 1377 $$
 * $$LastChangedBy: wangping $$
 */
public interface IUserExcludeProductJsonService {

    public UserExcludeProductJson findByUserId(long userId);

    public void delete(long userId);

    public void insert(long userId, String json);

    public void update (long userId, String json);
}

package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.AgentTaskPush;

import java.util.List;

/**
 * @author wangping
 * @createTime 下午2:39
 * $$LastChangedDate: 2016-12-05 19:03:49 +0800 (Mon, 05 Dec 2016) $$
 * $$LastChangedRevision: 1513 $$
 * $$LastChangedBy: wangping $$
 */
public interface IAgentTaskPushService {
    
    public List<AgentTaskPush> findByUserId(long userId);
}

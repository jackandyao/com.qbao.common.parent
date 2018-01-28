package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.HyipTaskProfit;

/**
 * @author wangping
 * @createTime 上午11:47
 * $$LastChangedDate: 2016-11-03 14:07:14 +0800 (Thu, 03 Nov 2016) $$
 * $$LastChangedRevision: 1374 $$
 * $$LastChangedBy: wangping $$
 */
public interface IHyipTaskProfitService {

    public HyipTaskProfit findByTaskId(long taskId);

}

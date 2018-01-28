package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.GRank;

/**
 * @author wangping
 * @createTime 下午5:06
 * $$LastChangedDate: 2016-10-25 17:19:14 +0800 (Tue, 25 Oct 2016) $$
 * $$LastChangedRevision: 1301 $$
 * $$LastChangedBy: wangping $$
 */
public interface IGRankViewService {
    public GRank findBySpuId(long spuId);
}

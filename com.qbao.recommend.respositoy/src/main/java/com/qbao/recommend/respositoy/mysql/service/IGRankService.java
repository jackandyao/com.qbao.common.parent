package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.GRank;

/**
 * @author wangping
 * @createTime 下午5:10
 * $$LastChangedDate: 2016-10-24 19:45:46 +0800 (Mon, 24 Oct 2016) $$
 * $$LastChangedRevision: 1292 $$
 * $$LastChangedBy: wangping $$
 */
public interface IGRankService {
    public GRank findBySpuId(long spuId);
}

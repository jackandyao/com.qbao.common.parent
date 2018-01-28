package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.GRank;

/**
 * @author wangping
 * @createTime 下午5:10
 * $$LastChangedDate: 2016-10-25 14:40:08 +0800 (Tue, 25 Oct 2016) $$
 * $$LastChangedRevision: 1300 $$
 * $$LastChangedBy: wangping $$
 */
public interface IGRankThumbService {
    public GRank findBySpuId(long spuId);
}

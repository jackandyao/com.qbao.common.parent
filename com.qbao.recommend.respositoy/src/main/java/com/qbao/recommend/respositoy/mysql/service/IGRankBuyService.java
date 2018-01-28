package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.GRank;

/**
 * @author wangping
 * @createTime 下午6:19
 * $$LastChangedDate: 2016-10-27 18:20:23 +0800 (Thu, 27 Oct 2016) $$
 * $$LastChangedRevision: 1330 $$
 * $$LastChangedBy: wangping $$
 */
public interface IGRankBuyService {
    public GRank findBySpuId(long spuId);
}


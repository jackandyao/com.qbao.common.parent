package com.qbao.recommend.business.goodProduct.cmp.service;

import com.qbao.recommend.respositoy.mysql.model.RecGoodProduct;

import java.util.List;

/**
 * @author wangping
 * @createTime 上午11:53
 * $$LastChangedDate: 2016-10-24 11:59:51 +0800 (Mon, 24 Oct 2016) $$
 * $$LastChangedRevision: 1284 $$
 * $$LastChangedBy: wangping $$
 */
public interface IGoodsLikesService {
    public List<RecGoodProduct> getGoodsLikesBySpuId(long spuId ,int limit);
}

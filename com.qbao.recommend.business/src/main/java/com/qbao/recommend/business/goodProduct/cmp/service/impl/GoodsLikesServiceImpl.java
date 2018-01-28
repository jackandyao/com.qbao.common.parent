package com.qbao.recommend.business.goodProduct.cmp.service.impl;

import com.qbao.recommend.business.goodProduct.cmp.service.IGoodsLikesService;
import com.qbao.recommend.respositoy.mysql.model.RecGoodProduct;
import com.qbao.recommend.respositoy.mysql.service.IRecGoodProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author wangping
 * @createTime 上午11:56
 * $$LastChangedDate: 2016-10-24 11:59:51 +0800 (Mon, 24 Oct 2016) $$
 * $$LastChangedRevision: 1284 $$
 * $$LastChangedBy: wangping $$
 */
@Service
public class GoodsLikesServiceImpl implements IGoodsLikesService {

    @Autowired
    IRecGoodProductService iRecGoodProductService;

    @Override
    public List<RecGoodProduct> getGoodsLikesBySpuId(long spuId, int limit) {
        return iRecGoodProductService.findTopNSpuByDirId(spuId,limit);
    }
}

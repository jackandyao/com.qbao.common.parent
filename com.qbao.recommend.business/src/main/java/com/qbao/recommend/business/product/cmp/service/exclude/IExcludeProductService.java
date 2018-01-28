package com.qbao.recommend.business.product.cmp.service.exclude;

import java.util.List;

/**
 * @author wangping
 * @createTime 上午10:10
 * $$LastChangedDate: 2016-11-09 19:59:02 +0800 (Wed, 09 Nov 2016) $$
 * $$LastChangedRevision: 1377 $$
 * $$LastChangedBy: wangping $$
 */
public interface IExcludeProductService {
    public  List<Long> calExcludeProductIds(long userId);

    public void exectue(long userId,long goodId);
}

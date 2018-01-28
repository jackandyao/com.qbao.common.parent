package com.qbao.recommend.business.product.cmp.service.buy;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 *   根据用户领取的分销 然后关联对应的店铺 取店铺对应的top产品
     * @author 贾红平
     * $LastChangedDate: 2016-09-13 18:17:44 +0800 (Tue, 13 Sep 2016) $
     * $LastChangedRevision: 1014 $
     * $LastChangedBy: shuaizhihu $
 */
public interface IBuySpuByDoleDistrService {
    public abstract List<Long> getBuySpuByDoleDistribution(JSONObject jsonObject);
}

package com.qbao.recommend.business.product.cmp.service.view;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.respositoy.redis.model.ItemDTO;
/**
 *   看了又看
     * @author 贾红平
     *
     * $LastChangedDate: 2016-09-08 10:36:36 +0800 (Thu, 08 Sep 2016) $
     * $LastChangedRevision: 951 $
     * $LastChangedBy: jiahongping $
 */
public interface ILookAgainSpuService {
    /**
     * 封装请求参数
     * @param jsonObject
     * @return
     */
    public abstract List<Long> getLookAgainTopSpu(JSONObject jsonObject);
}

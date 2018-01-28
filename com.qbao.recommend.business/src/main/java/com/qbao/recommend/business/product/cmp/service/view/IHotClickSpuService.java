package com.qbao.recommend.business.product.cmp.service.view;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 *   统计点击产品次数最高的产品
     * @author 贾红平
     * $LastChangedDate: 2016-09-06 17:26:00 +0800 (Tue, 06 Sep 2016) $
     * $LastChangedRevision: 906 $
     * $LastChangedBy: jiahongping $
 */
public interface IHotClickSpuService {

    /**
     * 封装请求参数
     * @param jsonObject
     * @return
     */
    public abstract List<Long>getHotViewTopSpu(JSONObject jsonObject);
}

package com.qbao.recommend.business.product.cmp.service.buy;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by THink on 2016/7/7.
 * 贾红平
 * 获取当前销售类目最高的一个类目,然后获取该类目下面的top个商品
 */
public interface IBuySpuByDirectoryService {

    /**
     * 封装请求参数
     * @param jsonObject
     * @return
     */
    public abstract List<Long> getBuyDirectoryTopSpu(JSONObject jsonObject);
}

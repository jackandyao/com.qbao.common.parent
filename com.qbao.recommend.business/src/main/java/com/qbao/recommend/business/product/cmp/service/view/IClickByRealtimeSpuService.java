/**
 * 
 */
package com.qbao.recommend.business.product.cmp.service.view;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * @author shuaizhihu
 * 用户点击实时商品列表
 * $LastChangedDate$
 * $LastChangedRevision$
 * $LastChangedBy$
 */
public interface IClickByRealtimeSpuService {
    /**
     * 获取用户点击商品的实时结果
     * @param jsonObject
     * @return
     */
    public abstract List<Long> getClickByRealtimeTopSpu(JSONObject jsonObject);
}

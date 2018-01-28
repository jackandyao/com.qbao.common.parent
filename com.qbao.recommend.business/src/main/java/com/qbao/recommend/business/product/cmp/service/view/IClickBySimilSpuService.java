package com.qbao.recommend.business.product.cmp.service.view;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 *  
     * @author 贾红平
     * 获取用户点击的相似产品
     * $LastChangedDate: 2016-09-13 18:17:44 +0800 (Tue, 13 Sep 2016) $
     * $LastChangedRevision: 1014 $
     * $LastChangedBy: shuaizhihu $
 */
public interface IClickBySimilSpuService {


    /**
     * 封装请求参数
     * @param jsonObject
     * @return
     */
    public abstract List<Long> getClickSimilTopSpu(JSONObject jsonObject);
}

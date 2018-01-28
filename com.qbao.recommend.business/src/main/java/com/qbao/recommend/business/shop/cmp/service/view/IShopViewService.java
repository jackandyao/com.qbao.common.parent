package com.qbao.recommend.business.shop.cmp.service.view;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 *  
     * @author sjzhangjun
     * 获取用户点击的相似产品
     * $LastChangedDate: 2016-09-13 18:17:44 +0800 (星期二, 13 九月 2016) $
     * $LastChangedRevision: 1014 $
     * $LastChangedBy: sjzhangjun $
 */
public interface IShopViewService {


    /**
     * 封装请求参数
     * @param jsonObject
     * @return
     */
    public abstract List<String> getTopSpuByView(JSONObject jsonObject);
}

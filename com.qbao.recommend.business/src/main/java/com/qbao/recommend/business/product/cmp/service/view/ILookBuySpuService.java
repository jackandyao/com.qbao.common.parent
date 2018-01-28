package com.qbao.recommend.business.product.cmp.service.view;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public interface ILookBuySpuService {

    public abstract List<Long> getLookBuyTopSpu(JSONObject jsonObject);

}
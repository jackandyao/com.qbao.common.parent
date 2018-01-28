package com.qbao.recommend.business.product.cmp.service.view.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.product.cmp.common.CommonSpuService;
import com.qbao.recommend.business.product.cmp.service.view.IClickSpuByDirectoryService;
@Service
public class ClickSpuByDirectoryService extends CommonSpuService implements IClickSpuByDirectoryService {
    @Override
    public List<Long> getClickDirectoryTopSpu(JSONObject jsonObject) {
         return null;
    }

}

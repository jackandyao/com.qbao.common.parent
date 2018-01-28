package com.qbao.recommend.business.product.cmp.service.personalized.service.impl;



import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.product.cmp.common.CommonSpuService;
import com.qbao.recommend.business.product.cmp.service.personalized.service.IFPGSpuService;

/**
 * Created by THink on 2016/7/8.
 */
@Service
public class FPGSpuService extends CommonSpuService implements IFPGSpuService {

    /**
     *
     * @param jsonObject
     * @return
     */
    @Override
    public List<Long> getTopSpuByFPG(JSONObject jsonObject) {
        return null;
    }
}

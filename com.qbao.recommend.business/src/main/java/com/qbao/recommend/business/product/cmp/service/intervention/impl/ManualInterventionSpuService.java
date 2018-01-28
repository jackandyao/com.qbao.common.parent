package com.qbao.recommend.business.product.cmp.service.intervention.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qbao.recommend.business.product.cmp.service.intervention.IManualInterventionSpuService;
@Service
public class ManualInterventionSpuService  implements IManualInterventionSpuService {

    @Override
    public List<Long> getManualDataList(List<Long>list) {
        return list;
    }

}

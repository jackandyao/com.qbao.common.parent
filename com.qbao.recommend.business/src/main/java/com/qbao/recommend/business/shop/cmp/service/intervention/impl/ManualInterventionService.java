package com.qbao.recommend.business.shop.cmp.service.intervention.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qbao.recommend.business.shop.cmp.service.intervention.IManualInterventionService;

@Service
public class ManualInterventionService  implements IManualInterventionService {

    @Override
    public List<String> getManualDataList(List<String>list) {
        return list;
    }

}

package com.qbao.recommend.business.shop.cmp.service.intervention;

import java.util.List;

/**
 *   
     * @author 贾红平
     * 处理人工干预的一些特殊数据,比如动态插入数据
     * $LastChangedDate: 2016-09-06 17:26:00 +0800 (星期二, 06 九月 2016) $
     * $LastChangedRevision: 906 $
     * $LastChangedBy: jiahongping $
 */
public interface IManualInterventionService {
    public List<String> getManualDataList(List<String> alllist);
}

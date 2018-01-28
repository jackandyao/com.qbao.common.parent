package com.qbao.recommend.business.product.cmp.service.emergency;

import java.util.List;

/**
 *    急救数据
     * @author 贾红平
     * 在系统服务出现个性化数据不正常的时候,使用急救数据代替
     * $LastChangedDate: 2016-09-06 17:26:00 +0800 (Tue, 06 Sep 2016) $
     * $LastChangedRevision: 906 $
     * $LastChangedBy: jiahongping $
 */
public interface IEmergencyDataService {
    public List<Long>getEmergencyDataList(List<Long>oldlist);
}

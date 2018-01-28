package com.qbao.recommend.business.shop.cmp.service.emergency;

import java.util.List;

/**
 *    急救数据
     * @author 贾红平
     * 在系统服务出现个性化数据不正常的时候,使用急救数据代替
     * $LastChangedDate: 2016-09-06 17:26:00 +0800 (星期二, 06 九月 2016) $
     * $LastChangedRevision: 906 $
     * $LastChangedBy: jiahongping $
 */
public interface IEmergencyDataService {
    public List<String>getEmergencyDataList(List<String>oldlist);
}

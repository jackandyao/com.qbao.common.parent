package com.qbao.recommend.business.product.cmp.service.intervention;

import java.util.List;

/**
 *   
     * @author 贾红平
     * 处理人工干预的一些特殊数据,比如动态插入数据
     * $LastChangedDate: 2016-09-30 17:17:06 +0800 (Fri, 30 Sep 2016) $
     * $LastChangedRevision: 1223 $
     * $LastChangedBy: shuaizhihu $
 */
public interface IManualInterventionSpuService {
    public List<Long> getManualDataList(List<Long> alllist);
}

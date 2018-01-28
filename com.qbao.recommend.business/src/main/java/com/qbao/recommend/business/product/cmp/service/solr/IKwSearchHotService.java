/**
 * 
 */
package com.qbao.recommend.business.product.cmp.service.solr;

import java.util.List;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate: 2016-09-06 17:26:00 +0800 (Tue, 06 Sep 2016) $
 * $LastChangedRevision: 906 $
 * $LastChangedBy: jiahongping $
 */
public interface IKwSearchHotService {
    
    List<Long> getKwSearchHot(String kw,int limit);
}

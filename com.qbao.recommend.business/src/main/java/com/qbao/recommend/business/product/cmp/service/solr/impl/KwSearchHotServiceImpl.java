/**
 * 
 */
package com.qbao.recommend.business.product.cmp.service.solr.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qbao.recommend.business.product.cmp.common.CommonSpuService;
import com.qbao.recommend.business.product.cmp.service.solr.IKwSearchHotService;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate: 2016-09-06 17:26:00 +0800 (Tue, 06 Sep 2016) $
 * $LastChangedRevision: 906 $
 * $LastChangedBy: jiahongping $
 */
@Service
public class KwSearchHotServiceImpl extends CommonSpuService implements IKwSearchHotService {

    /* (non-Javadoc)
     * @see com.qbao.spu.service.service.solr.IKwSearchHotService#getKwSearchDir(long, int)
     */
    @Override
    public List<Long> getKwSearchHot(String kw, int limit) {
       List<Long> spuIds = new ArrayList<Long>();
       List<String> list =  this.getHotKw(kw, limit);
       for(String id:list){
           spuIds.add(Long.parseLong(id));
       }
        return spuIds;
    }

}

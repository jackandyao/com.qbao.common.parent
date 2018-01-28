/**
 * 
 */
package com.qbao.recommend.business.product.cmp.service.solr.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.qbao.recommend.business.product.cmp.common.CommonSpuService;
import com.qbao.recommend.business.product.cmp.service.solr.IKwSearchDirService;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate: 2016-09-06 17:26:00 +0800 (Tue, 06 Sep 2016) $
 * $LastChangedRevision: 906 $
 * $LastChangedBy: jiahongping $
 */
@Service
public class KwSearchDirServiceImpl extends CommonSpuService implements  IKwSearchDirService{

    /* (non-Javadoc)
     * @see com.qbao.spu.service.service.solr.IKwSearchDirService#getKwSearchDir(long, int)
     */
    @Override
    public List<Long> getKwSearchDir(String kw, int limit) {
          List<Long> list = new ArrayList<Long>();
          Map<String,List<String>> listMap = super.getDirKw(kw, limit);
          for(int i=0;i<=limit;i++){
              for(String key:listMap.keySet()){
                  if(listMap.get(key).size()>i){
                      list.add(Long.parseLong(listMap.get(key).get(i)));
                  }
                  if(list.size()==limit){
                      break;
                  }
              }
          }
          return list;
    }

    
    
    

}

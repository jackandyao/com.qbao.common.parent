/**
 * 
 */
package com.qbao.recommend.business.doctor.biz;

import java.util.List;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
public interface IDoctorBiz {
    
    public List<Long> fetchRecommend(String desc);


    public void updateDiseaseDescription();

}

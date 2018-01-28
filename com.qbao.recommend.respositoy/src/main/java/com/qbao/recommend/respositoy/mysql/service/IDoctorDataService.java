/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service;

import java.util.List;

import com.qbao.recommend.respositoy.mysql.model.QbdcKeywordDeptReal;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
public interface IDoctorDataService {

    public List<QbdcKeywordDeptReal> getAllDeptIdAndKeywords();

    public void updateDiseaseDescription();
    
}

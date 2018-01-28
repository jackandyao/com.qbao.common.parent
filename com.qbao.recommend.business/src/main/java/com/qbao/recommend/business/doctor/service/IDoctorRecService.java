/**
 * 
 */
package com.qbao.recommend.business.doctor.service;

import java.util.Map;
import javax.ws.rs.QueryParam;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
public interface IDoctorRecService {
    
    public Object recommendByDiseaseDescription(@QueryParam("description") String description);
}

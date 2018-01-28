/**
 * 
 */
package com.qbao.recommend.business.doctor.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import net.sf.json.JSONObject;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.qbao.recommend.business.doctor.biz.IDoctorBiz;
import com.qbao.recommend.business.doctor.service.IDoctorRecService;
import com.qbao.recommend.respositoy.mysql.model.RecommendMetadata;
import com.qbao.recommend.respositoy.mysql.service.IRecommendMetadataService;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-07 09:10:36 +0800 (Wed, 07 Sep 2016) $
 * $LastChangedRevision: 916 $
 * $LastChangedBy: jiahongping $
 */
@Path("doctor/doctorRecommend")
public class DoctorRecService implements IDoctorRecService {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    @Autowired
    IDoctorBiz doctorBiz;

   
    @GET
    @Path("diseaseDescription")
    @Override
    public Object recommendByDiseaseDescription(@QueryParam("desc") String desc) {
        logger.info("根据患者描述获取推荐科室接口访问   参数为  description:" + desc);
        Map<String, Object> response = new HashMap<String, Object>();
        try {
            List<Long> deptIds = doctorBiz.fetchRecommend(desc);
            response.put("code", "0");
            response.put("message", "success");
            response.put("dept_ids", deptIds);
        } catch (Exception e) {
            response.put("code", "-1");
            response.put("message", "error");
            logger.error(ExceptionUtils.getFullStackTrace(e));
        }
        return JSONObject.fromObject(response).toString();
    }

}

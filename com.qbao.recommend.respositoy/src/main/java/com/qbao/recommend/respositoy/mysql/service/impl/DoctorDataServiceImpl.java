/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.QbdcKeywordDeptRealDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.QbdcKeywordDeptReal;
import com.qbao.recommend.respositoy.mysql.model.SpuInfoBaogou;
import com.qbao.recommend.respositoy.mysql.service.IDoctorDataService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-19 18:38:46 +0800 (Mon, 19 Sep 2016) $
 * $LastChangedRevision: 1071 $
 * $LastChangedBy: shuaizhihu $
 */
@Service
public class DoctorDataServiceImpl implements IDoctorDataService {

    @Value("${QBDC_KEYWORD_DEPT_REAL}")
    private String qbdc_keyword_dept_real;
    
    @Value("${doctor.datasource.key}")
    private String datasource_key;

    @Autowired
    QbdcKeywordDeptRealDao qbdcKeywordDeptRealDao;

    @Override
    @RedisCache(expire = 60 * 2, clazz = QbdcKeywordDeptReal.class, cacheType = CacheType.LIST)
    public List<QbdcKeywordDeptReal> getAllDeptIdAndKeywords() {
        MultipleDataSource.setDataSourceKey(datasource_key);
        return qbdcKeywordDeptRealDao.findKeyWordDeptRealAll(qbdc_keyword_dept_real);
    }

    @Override
    public void updateDiseaseDescription() {
        throw new RuntimeException("unimplements updateDiseaseDescription() method");
    }

}

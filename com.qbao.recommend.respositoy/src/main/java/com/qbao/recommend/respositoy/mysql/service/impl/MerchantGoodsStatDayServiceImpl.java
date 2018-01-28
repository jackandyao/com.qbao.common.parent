package com.qbao.recommend.respositoy.mysql.service.impl;

import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.qbao.recommend.respositoy.mysql.dao.MerchantGoodsStatDayDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.AgentTask;
import com.qbao.recommend.respositoy.mysql.service.IMerchantGoodStatDayService;
import com.qbao.recommend.respositoy.mysql.util.DateUtil;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shuaizhihu on 2016/11/18.
 */
@Service
public class MerchantGoodsStatDayServiceImpl implements IMerchantGoodStatDayService{

    Logger logger  = LoggerFactory.getLogger(MerchantGoodsStatDayServiceImpl.class);

    @Value("${merchant_middle.datasource.key}")
    private String DATASOURCE_KEY;

    @Autowired
    MerchantGoodsStatDayDao merchantGoodsStatDayDao;

    @Override
    @RedisCache(expire = 60 * 60, clazz = Long.class, cacheType = CacheType.OBJECT)
    public long findOrderNumBySpuId(long spuId, String startDate, String endDate) {
        try {
            Date start = DateUtil.format.parse(startDate);
            Date end = DateUtil.format.parse(endDate);
            MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
            Long num =  merchantGoodsStatDayDao.getOrderNum(spuId, start, end);
            if(num == null){
                return 0;
            }else{
                return num;
            }
        } catch (ParseException e) {
            logger.error(ExceptionUtils.getFullStackTrace(e));
            return 0;
        }
    }
}

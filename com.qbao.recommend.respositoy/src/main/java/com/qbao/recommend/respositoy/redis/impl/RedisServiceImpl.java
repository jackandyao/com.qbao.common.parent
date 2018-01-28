/**
 * 
 */
package com.qbao.recommend.respositoy.redis.impl;

import com.qbao.recommend.respositoy.redis.IRedisService;
import com.qbao.recommend.respositoy.redis.common.BaseRedisClusterDao;
import com.qbao.recommend.respositoy.redis.common.RedisModel;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate: 2016-11-09 19:59:02 +0800 (Wed, 09 Nov 2016) $
 * $LastChangedRevision: 1377 $
 * $LastChangedBy: wangping $
 */
@Service
public class RedisServiceImpl extends BaseRedisClusterDao implements IRedisService {

    Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see com.qbao.dc.redis.IRedisService#find(com.qbao.dc.redis.model.BaseRedisModel)
     */
    @Override
    public RedisModel<?> find(RedisModel<?> model) {
        try {
            model.setValue(super.get(model.getTableName(), model.getKey(), model.getValue().getClass()));
        } catch (JsonParseException e) {
            logger.error("JsonParse error  exception info: " + ExceptionUtils.getFullStackTrace(e));
        } catch (JsonMappingException e) {
            logger.error("JsonMapping error exception info:" + ExceptionUtils.getFullStackTrace(e));
        } catch (IOException e) {
            logger.error("IO error exception info:" + ExceptionUtils.getFullStackTrace(e));
        }
        return model;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.qbao.dc.redis.IRedisService#save(com.qbao.dc.redis.model.BaseRedisModel)
     */
    @Override
    public boolean save(RedisModel<?> model) {
        try {
            super.insert(model);
            return true;
        } catch (JsonGenerationException e) {
            logger.error("JsonGeneration error  exception info: " + ExceptionUtils.getFullStackTrace(e));
        } catch (JsonMappingException e) {
            logger.error("JsonMapping error  exception info: " + ExceptionUtils.getFullStackTrace(e));
        } catch (IOException e) {
            logger.error("IO error  exception info: " + ExceptionUtils.getFullStackTrace(e));
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.qbao.dc.redis.IRedisService#delete(java.lang.Object)
     */
    @Override
    public boolean delete(RedisModel<?> model) {
        try {
            super.del(model);
        } catch (Exception e) {
            logger.error("error  exception info: " + ExceptionUtils.getFullStackTrace(e));
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.qbao.dc.redis.IRedisService#deleteList(com.qbao.dc.redis.common.RedisModel)
     */
    @Override
    public boolean deleteList(RedisModel<?> model) {
        try {
            super.delList(model);
        } catch (Exception e) {
            logger.error("error  exception info: " + ExceptionUtils.getFullStackTrace(e));
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see com.qbao.dc.redis.IRedisService#save(com.qbao.dc.redis.common.RedisModel, int)
     */
    @Override
    public boolean save(RedisModel<?> model, int expire) {
        try {
            super.insert(model,expire);
            return true;
        } catch (JsonGenerationException e) {
            logger.error("JsonGeneration error  exception info: " + ExceptionUtils.getFullStackTrace(e));
        } catch (JsonMappingException e) {
            logger.error("JsonMapping error  exception info: " + ExceptionUtils.getFullStackTrace(e));
        } catch (IOException e) {
            logger.error("IO error  exception info: " + ExceptionUtils.getFullStackTrace(e));
        }
        return false;
    }

    @Override
    public boolean delete(String key) {
        try {
            redisClusterTemplate.delete(key);
        } catch (Exception e) {
            logger.error("delete redis key =["+key+"] . error  exception info: " + ExceptionUtils.getFullStackTrace(e));
            return false;
        }
        return true;
    }
}

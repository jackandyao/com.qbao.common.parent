/**
 * 
 */
package com.qbao.recommend.respositoy.redis.factory;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qbao.recommend.respositoy.redis.common.RedisModel;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate: 2016-11-16 17:22:42 +0800 (Wed, 16 Nov 2016) $
 * $LastChangedRevision: 1403 $
 * $LastChangedBy: linhanye $
 */
public class    RedisModelFactory {
    
    static Logger logger = LoggerFactory.getLogger(RedisModelFactory.class);
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static RedisModel<?> getRedisModel(String key,Object o) {
        if(key==null||o==null){
            logger.error("create RedisModel error:key or object is not be null");
            return null;
        }
        RedisModel<?> redisModel = new RedisModel(key, o);
        return (RedisModel<?>) redisModel;
    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static  RedisModel<?> getQueryModel(String key, Class<?> type)  {
        if(key==null){
            logger.error("create QueryModel error:key  is not be null");
            return null;
        }
        Object t = null;
        try {
            t = type.newInstance();
        } catch (InstantiationException e) {
            logger.error("Instantiation error  exception info: " + ExceptionUtils.getFullStackTrace(e));
            return null;
        } catch (IllegalAccessException e) {
            logger.error("IllegalAccess error  exception info: " + ExceptionUtils.getFullStackTrace(e));
            return null;
        }
        RedisModel<?> redisModel = new RedisModel(key, t);
        return redisModel;
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static RedisModel<?> getDeleteModel(String key,Class<?> type){
        if(key==null){
            logger.error("create DeleteModel error:key  is not be null");
            return null;
        }
        Object t = null;
        try {
            t = type.newInstance();
        } catch (InstantiationException e) {
            logger.error("Instantiation error  exception info: " + ExceptionUtils.getFullStackTrace(e));
            return null;
        } catch (IllegalAccessException e) {
            logger.error("IllegalAccess error  exception info: " + ExceptionUtils.getFullStackTrace(e));
            return null;
        }
        RedisModel<?> redisModel = new RedisModel(key, t);
        return redisModel;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static RedisModel<?> getDeleteListModel(String pattern,Class<?> type){
        if(pattern==null||pattern.equals("")){
            logger.error("create DeleteModel error:pattern  is not be null or empty");
            return null;
        }
        Object t = null;
        try {
            t = type.newInstance();
        } catch (InstantiationException e) {
            logger.error("Instantiation error  exception info: " + ExceptionUtils.getFullStackTrace(e));
            return null;
        } catch (IllegalAccessException e) {
            logger.error("IllegalAccess error  exception info: " + ExceptionUtils.getFullStackTrace(e));
            return null;
        }
        RedisModel<?> redisModel = new RedisModel(pattern, t);
        return redisModel;
    }
}
 
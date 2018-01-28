/**
 * 
 */
package com.qbao.recommend.respositoy.redis.cache.aspect;

import com.alibaba.fastjson.JSON;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;
import com.qbao.recommend.respositoy.redis.common.AbstractBaseRedisClusterDao;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate: 2016-10-27 21:50:35 +0800 (Thu, 27 Oct 2016) $
 * $LastChangedRevision: 1338 $
 * $LastChangedBy: wangping $
 */
@Component
public class RedisCacheAspect extends AbstractBaseRedisClusterDao<String, String>{
    
    private static Logger logger = LoggerFactory.getLogger(RedisCacheAspect.class);  
    
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable { 
        MethodSignature ms = (MethodSignature)pjp.getSignature();
        Class<?> classTarget=pjp.getTarget().getClass(); 
        
        //获取类名、方法名、参数名  
        String className = classTarget.getSimpleName();  
        String methodName = ms.getName();  
        Object[] args = pjp.getArgs(); 
        
        Class<?>[] par=ms.getParameterTypes();  
        Method method=classTarget.getMethod(methodName, par);  
        
        
        RedisCache annotation = method.getAnnotation(RedisCache.class);  
  
        //获取注解信息  
        int expire = annotation.expire();  
        Class<?> clazz = annotation.clazz();  
        CacheType cacheType = annotation.cacheType();  
  
         
        StringBuffer sb = new StringBuffer();  
        for(Object arg : args) {  
            if(arg != null) {  
                sb.append("_").append(arg.toString());  
            }  
        }  
        //用类名、方法名、参数名作为缓存的key  
        String cacheKey = className.concat("_").concat(methodName).concat(sb.toString());  
        Object obj = this.getCache(cacheKey, clazz, cacheType);  
        //命中缓存，直接返回信息  
        if(obj != null) {  
            System.out.println("cache hit for key:"+cacheKey);  
            return obj;  
        } else {  
            //未命中缓存，查询结果，并放到缓存中  
            Object result = pjp.proceed(); 
            if(result!=null) {  
                System.out.println("put to cache for key:"+cacheKey);  
                this.putCache(cacheKey, result, expire);  
            }  
            return result;  
        }  
   }  
    
    
    private void putCache(String key, Object result, int expire){
        String str = JSON.toJSONString(result); 
        this.redisClusterTemplate.opsForValue().set(key, str, expire, TimeUnit.SECONDS);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private Object getCache(String key, Class clazz, CacheType cacheType) {
        String result = "";
        try {
            result = this.redisClusterTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(result)) {
                if (CacheType.LIST.equals(cacheType)) {
                    List list = JSON.parseObject(result, List.class);
                    List retList = new ArrayList();
                    for (Object obj : list) {
                        retList.add(JSON.parseObject(obj.toString(), clazz));
                    }
                    return retList;
                } else {
                    return JSON.parseObject(result, clazz);
                }
            }
        } catch (Exception e) {
            logger.error("getFromCache  class : ["+clazz + "], cache value : ["+result+"] , Cache Type :["+cacheType+"] ,exception: " + ExceptionUtils.getFullStackTrace(e));
        }
        return null;
    }
    
    
}

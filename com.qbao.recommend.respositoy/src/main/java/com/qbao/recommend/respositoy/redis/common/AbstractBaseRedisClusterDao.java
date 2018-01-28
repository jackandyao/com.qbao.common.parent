package com.qbao.recommend.respositoy.redis.common;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**  
 * AbstractBaseRedisClusterDao 
 * @author shuaizhihu
 * @date 2016-04-27 
 */   
public abstract class AbstractBaseRedisClusterDao<K, V> {  
        
    @Resource(name="redisClusterTemplate")
    protected RedisTemplate<K, V> redisClusterTemplate;  
  
    /** 
     * 设置redisTemplate 
     * @param redisTemplate the redisTemplate to set 
     */  
    public void setRedisTemplate(RedisTemplate<K, V> redisClusterTemplate) {  
        this.redisClusterTemplate = redisClusterTemplate;  
    }  
      
    /** 
     * 获取 RedisSerializer 
     * <br>------------------------------<br> 
     */  
    protected RedisSerializer<String> getRedisSerializer() {  
        return redisClusterTemplate.getStringSerializer();  
    }  
}  
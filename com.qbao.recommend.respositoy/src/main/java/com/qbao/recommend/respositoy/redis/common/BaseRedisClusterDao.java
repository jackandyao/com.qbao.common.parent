package com.qbao.recommend.respositoy.redis.common;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig;

public class BaseRedisClusterDao extends AbstractBaseRedisClusterDao<String, String> {

    public static ObjectMapper objectMapper;

    public void insert(RedisModel<?> t) throws JsonGenerationException, JsonMappingException, IOException {
        this.redisClusterTemplate.opsForValue().set(t.getTableName() + ":" + t.getKey(), this.toJson(t.getValue()));
    }
    
    
    public void insert(RedisModel<?> t,int expire) throws JsonGenerationException, JsonMappingException, IOException {
        this.redisClusterTemplate.opsForValue().set(t.getTableName() + ":" + t.getKey(), this.toJson(t.getValue()),expire,TimeUnit.SECONDS);
    }

    public <T> T get(String tableName,String key,Class<T> type) throws JsonParseException, JsonMappingException, IOException {
        String json = this.redisClusterTemplate.opsForValue().get(tableName+":"+key);
        if (json != null) {
           @SuppressWarnings("unchecked")
           T  t = (T) this.toObject(json, type );
           return t;
        } else {
           return null;
        }
    }
    
    public void del(RedisModel<?> t){
        this.redisClusterTemplate.delete(t.getTableName()+":"+t.getKey());
    }
    
    public void delList(RedisModel<?> t){
        Set<String> keys = this.redisClusterTemplate.keys(t.getTableName()+":"+t.getKey());
        this.redisClusterTemplate.delete(keys);
        
    }

    private String toJson(Object t) throws JsonGenerationException, JsonMappingException, IOException {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }
        return objectMapper.writeValueAsString(t);
    }

    private Object toObject(String json, Class<?> type) throws JsonParseException, JsonMappingException, IOException {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }

        return objectMapper.readValue(json, type);
    }
    
    
}

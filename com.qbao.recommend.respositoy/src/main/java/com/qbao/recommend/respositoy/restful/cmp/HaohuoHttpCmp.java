package com.qbao.recommend.respositoy.restful.cmp;

import com.qbao.recommend.respositoy.mysql.page.Page;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;
import com.qbao.recommend.util.http.HttpClientUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by shuaizhihu on 2016/11/22.
 */
@Component
public class HaohuoHttpCmp {

    @Value("${haohuo.url}")
    private String haohuoUrl;

    @RedisCache(expire = 60 * 3, clazz = String.class, cacheType = CacheType.OBJECT)
    public String getResultJson(String url, int page, int size) throws IOException {
        String newUrl= "";
        if(!url.contains("?")){
            newUrl= haohuoUrl+url+"?page="+page+"&size="+size;
        }else{
            newUrl= haohuoUrl+url+"&page="+page+"&size="+size;
        }

        String json = HttpClientUtils.doGet(newUrl);
        return json;
    }
}

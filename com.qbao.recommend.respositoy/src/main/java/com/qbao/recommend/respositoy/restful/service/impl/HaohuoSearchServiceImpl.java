package com.qbao.recommend.respositoy.restful.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.respositoy.mysql.page.Page;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;
import com.qbao.recommend.respositoy.restful.cmp.HaohuoHttpCmp;
import com.qbao.recommend.respositoy.restful.entities.GoodGoods;
import com.qbao.recommend.respositoy.restful.entities.User;
import com.qbao.recommend.respositoy.restful.service.IHaohuoSearchService;
import com.qbao.recommend.util.http.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaizhihu on 2016/11/22.
 */
@Service
public class HaohuoSearchServiceImpl implements IHaohuoSearchService{
    @Autowired
    HaohuoHttpCmp haohuoHttpCmp;

    @Override
    public Page<GoodGoods> findList(String url, int page, int size) throws IOException {
        String json =  haohuoHttpCmp.getResultJson( url, page,size);
        JSONObject reponse = JSON.parseObject(json);
        String returnCode = reponse.getString("returnCode");
        if(returnCode.equals("1000")) {
            JSONObject dataObject = reponse.getJSONObject("data");
            int total = dataObject.getInteger("total");
            JSONArray array = dataObject.getJSONArray("list");
            List<GoodGoods> list= JSON.parseArray(array.toJSONString(),GoodGoods.class);
            return new Page<GoodGoods>(total,page,size,list);
        }else{
            throw new RuntimeException("请求接口出错！ url："+url+" response:"+json);
        }
    }
}

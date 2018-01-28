package com.qbao.recommend.respositoy.restful.service;

import com.qbao.recommend.respositoy.mysql.page.Page;
import com.qbao.recommend.respositoy.restful.entities.GoodGoods;

import java.io.IOException;

/**
 * Created by shuaizhihu on 2016/11/22.
 */
public interface IHaohuoSearchService {

     Page<GoodGoods> findList(String url, int page, int size) throws IOException;

}

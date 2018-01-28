package com.qbao.recommend.respositoy.mysql.service;

import com.qbao.recommend.respositoy.mysql.model.GoodProductDir;

import java.util.List;

/**
 * Created by shuaizhihu on 2016/11/22.
 */
public interface IGoodProductDirService {

        public List<GoodProductDir> findList();

        public GoodProductDir findById(long id);
 }

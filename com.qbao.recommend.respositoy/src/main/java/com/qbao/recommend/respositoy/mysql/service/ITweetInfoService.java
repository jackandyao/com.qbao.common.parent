package com.qbao.recommend.respositoy.mysql.service;

import java.util.List;

import com.qbao.recommend.respositoy.mysql.model.TweetInfo;

/**
 * 推文数据层接口
 * 
 * @author sjzhangjun
 */
public interface ITweetInfoService {

    List<TweetInfo> getTweetInfoList();

    List<TweetInfo> getTweetInfoListByStatus(int status);

    TweetInfo getTweetInfoById(long id);

    TweetInfo getTweetInfoBySn(String sn);
}

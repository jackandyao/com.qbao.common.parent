package com.qbao.recommend.respositoy.mysql.service;
import com.qbao.recommend.respositoy.mysql.model.RecommendMetadata;

public interface IRecommendMetadataService {
    public RecommendMetadata findByParamKey(String key);

}

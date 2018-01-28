package com.qbao.recommend.business.tweet.cache;

import com.qbao.recommend.business.tweet.model.RecommendResult;
import com.qbao.recommend.business.tweet.model.TweetDTO;
import com.qbao.recommend.respositoy.redis.IRedisService;
import com.qbao.recommend.respositoy.redis.common.RedisModel;
import com.qbao.recommend.respositoy.redis.factory.RedisModelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author wangping
 * @createTime 下午4:13
 * $$LastChangedDate: 2017-01-12 15:34:26 +0800 (Thu, 12 Jan 2017) $$
 * $$LastChangedRevision: 1543 $$
 * $$LastChangedBy: wangping $$
 */
@Component
public class TweetCacheService {

    @Autowired
    private IRedisService iRedisService;

    public void cacheRecommendResult(long userId, List<TweetDTO> results) {
        RecommendResult recommendResult = new RecommendResult();
        recommendResult.setUserId(userId);
        recommendResult.setResult(results);
        recommendResult.setRecommendDate(new Date());
        RedisModel<RecommendResult> queryModel = (RedisModel<RecommendResult>) RedisModelFactory.getQueryModel(String.valueOf(userId), RecommendResult.class);
        iRedisService.delete(queryModel);
        RedisModel<?> model = RedisModelFactory.getRedisModel(String.valueOf(userId), recommendResult);
        iRedisService.save(model);
    }

    public RecommendResult fetchRecommendResult(long userId) {
        RecommendResult result = null;
        RedisModel<RecommendResult> queryModel = (RedisModel<RecommendResult>) RedisModelFactory.getQueryModel(String.valueOf(userId), RecommendResult.class);
        RedisModel<RecommendResult> targetModel = (RedisModel<RecommendResult>) iRedisService.find(queryModel);
        if (null == targetModel || null == targetModel.getValue()) { // 缓存失效或者没有缓存
            return result;
        }
        result = targetModel.getValue();
        return result;
    }
}

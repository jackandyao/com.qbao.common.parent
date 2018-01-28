package com.qbao.recommend.business.tweet.cmp.common;

import com.qbao.recommend.respositoy.mysql.model.TweetOwnerWapper;
import com.qbao.recommend.respositoy.mysql.service.ITweetPoolServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author wangping
 * @createTime 下午4:58
 * $$LastChangedDate: 2017-01-12 15:34:26 +0800 (Thu, 12 Jan 2017) $$
 * $$LastChangedRevision: 1543 $$
 * $$LastChangedBy: wangping $$
 */
@Component
public class WhiteListService {

    @Autowired
    @Qualifier("tweetPoolServcieImpl")
    private ITweetPoolServcie tweetPoolServcie;

    /**
     *
     * @param userId
     * @return teng rong tweet ids
     */
    public Set<Long>  getWhiteList(Long userId){
        TweetOwnerWapper tweetOwnerWapper = tweetPoolServcie.getAllValidTwettInfoOwner();
        return tweetOwnerWapper.getOwenrMapping().get(userId);

    }
}

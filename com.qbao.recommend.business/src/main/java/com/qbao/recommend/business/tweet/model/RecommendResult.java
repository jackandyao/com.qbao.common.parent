package com.qbao.recommend.business.tweet.model;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wangping
 * @createTime 下午3:55
 * $$LastChangedDate: 2017-01-12 15:34:26 +0800 (Thu, 12 Jan 2017) $$
 * $$LastChangedRevision: 1543 $$
 * $$LastChangedBy: wangping $$
 */
public class RecommendResult implements Serializable {

    private static final long serialVersionUID = "$Id: RecommendResult.java 1543 2017-01-12 07:34:26Z wangping $".hashCode();

    private long userId;
    private List<TweetDTO> result;
    private Date recommendDate;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<TweetDTO> getResult() {
        return result;
    }

    public void setResult(List<TweetDTO> result) {
        this.result = result;
    }

    public Date getRecommendDate() {
        return recommendDate;
    }

    public void setRecommendDate(Date recommendDate) {
        this.recommendDate = recommendDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof RecommendResult))
            return false;

        RecommendResult that = (RecommendResult) o;

        return new EqualsBuilder()
                .append(getUserId(), that.getUserId())
                .append(getResult(), that.getResult())
                .append(getRecommendDate(), that.getRecommendDate())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getUserId())
                .append(getResult())
                .append(getRecommendDate())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userId", userId)
                .append("result", result)
                .append("recommendDate", recommendDate)
                .toString();
    }

    /**
     *
     * @param source ding ling or teng rong
     * @return
     */
    public Set<Long> fetchTweetIdBySource(String source) {
        String formatKey = StringUtils.upperCase(source);
        Map<String, Set<Long>> tweetIdMap = new HashMap<>();
        for (TweetDTO tweetDTO : result) {
            String key = StringUtils.upperCase(tweetDTO.getSource());
            if (!tweetIdMap.containsKey(key)) {
                tweetIdMap.put(key, new HashSet<Long>());
            }
            tweetIdMap.get(key).add(tweetDTO.getId());
        }
        return tweetIdMap.get(formatKey);
    }
}
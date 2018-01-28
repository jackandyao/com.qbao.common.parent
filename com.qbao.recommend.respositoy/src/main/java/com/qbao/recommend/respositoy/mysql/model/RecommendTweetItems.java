/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-26 10:49:24 +0800 (Mon, 26 Sep 2016) $
 * $LastChangedRevision: 1173 $
 * $LastChangedBy: wangping $
 */
public class RecommendTweetItems implements Serializable {
    private static final long serialVersionUID = "$Id: RecommendTweetItems.java 1173 2016-09-26 02:49:24Z wangping $".hashCode();
    private long userId;
    private String tweets;

    /**
     * @return the userId
     */
    public long getUserId() {
        return userId;
    }

    /**
     * @param userId
     * the userId to set
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTweets() {
        return tweets;
    }

    public void setTweets(String tweets) {
        this.tweets = tweets;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tweets == null) ? 0 : tweets.hashCode());
        result = prime * result + (int) (userId ^ (userId >>> 32));
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RecommendTweetItems other = (RecommendTweetItems) obj;
        if (tweets == null) {
            if (other.tweets != null)
                return false;
        } else if (!tweets.equals(other.tweets))
            return false;
        if (userId != other.userId)
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "RecommendTweetItems [userId=" + userId + ", tweets=" + tweets + "]";
    }

   

    public static void main(String[] args) {
        RecommendTweetItems item = new RecommendTweetItems();
        item.setTweets("3:0.0,2:0.0,1:0.0");
        item.setUserId(10000);
//        String tweets = ;
//        List<Long> spuIdsList = new ArrayList<Long>();
//        System.out.println("RecommendTweetItems : " + tweets);
//        if (!StringUtils.isEmpty(tweets)) {// 3:0.0,2:0.0,1:0.0
//            String[] pairs = StringUtils.split(tweets, ",");
//            for (String str : pairs) {
//                System.out.println("RecommendTweetItems pair : " + str);
//                if (StringUtils.isNotBlank(str)) {
//                    String[] pair = StringUtils.split(str, ":");
//                    spuIdsList.add(NumberUtils.toLong(pair[0]));
//                }
//            }
//        }
  //      System.out.println(item.getTweetIds());

    }
}

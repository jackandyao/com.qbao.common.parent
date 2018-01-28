package com.qbao.recommend.business.tweet.cmp.util;

import com.google.common.collect.Lists;
import com.qbao.recommend.respositoy.mysql.model.RecommendTweetItems;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.math.RandomUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2017-01-13 15:35:09 +0800 (Fri, 13 Jan 2017) $
 * $LastChangedRevision: 1545 $
 * $LastChangedBy: wangping $
 */

public class RecommendUtils {

    /**
     * random sort the list elements
     * @param
     */
    public static <T> void disorderList(List<T> list){
        int sed = list.size() - 1;
        if(sed < -1){
            return;
        }
        for(int i =0; i< list.size(); i++) {
            int j = RandomUtils.nextInt(sed+1);
            if (j > -1 && j < list.size()) {// swap list[i] list[j]
                T a = list.get(i);
                list.set(i, list.get(j));
                list.set(j, a);
            }
        }
    }

    /**
     *
     * @param ids
     * @param baseIds
     * @return 如果集合ids元素在baseIds中存在,该元素排在ids集合最后
     *  List<Long> ids = Lists.newArrayList(1L,2L,3L,4L,5L,6L,7L,8L);
        List<Long> baseIds = Lists.newArrayList(4L,6L,7L);
     排序后 [1, 2, 3, 5, 8, 7, 6, 4]
     */
    public static  List<Long> sort( List<Long>  ids  , Collection<Long> baseIds){
        List<Long> result = new ArrayList<>();
        for(int index = ids.size()-1; index >-1 ; index --){
            Long id = ids.get(index);
            if(baseIds.contains(id)){
                result.add(result.size(),id);
            }else {
                result.add(0,id);
            }
        }
      return result;
    }


    /**
     *
     * @param recommend from  Mysql Recommend Result Item
     * @return tweet id list
     */
    public static List<Long> parseRecommendTweetItems(RecommendTweetItems recommend) {
        List<Long> tweetIds = Lists.newArrayList();
        if (null != recommend) {
            String tweets = recommend.getTweets();
            if (!StringUtils.isEmpty(tweets)) {// 3:0.0,2:0.0,1:0.0
                String[] pairs = StringUtils.split(tweets, ",");
                for (String str : pairs) {
                    if (StringUtils.isNotBlank(str)) {
                        String[] pair = StringUtils.split(str, ":");
                        Long tweetId = NumberUtils.toLong(pair[0]);
                        if(!tweetIds.contains(tweetId)) {
                            tweetIds.add(tweetId);
                        }
                    }
                }
            }
        }
        return tweetIds;
    }

    public static void main(String[] args){
        List<Long> ids = Lists.newArrayList(1L,2L,3L,4L,5L,6L,7L,8L);
        RecommendUtils.disorderList(ids);
        System.out.println(ids );
//        List<Long> baseIds = Lists.newArrayList(4L,6L,7L);
//        System.out.println( RecommendUtils.sort(ids,baseIds));
    }
}

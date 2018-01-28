/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.dao;

import com.qbao.recommend.respositoy.mysql.model.TweetInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-11-10 14:50:12 +0800 (Thu, 10 Nov 2016) $
 * $LastChangedRevision: 1378 $
 * $LastChangedBy: wangping $
 */
@Component
public interface TweetsPoolDao {

    @Select("select * from ${tableName}")
    @ResultMap("TweetsPoolMap")
    List<TweetInfo> getTweetInfoList(@Param("tableName") String tableName);

    @Select("select * from ${tableName} where state = #{state}")
    @ResultMap("TweetsPoolMap")
    List<TweetInfo> getTweetInfoListByStatus(@Param("tableName") String tableName, @Param("state") int state);

    @Select("select * from ${tableName} where id = #{id} and state = 1 limit 0,1")
    @ResultMap("TweetsPoolMap")
    TweetInfo getTweetInfoById(@Param("tableName") String tableName, @Param("id") long id);

    @Insert("insert into tweetinfo_tr(id,title,url,keywords,state, update_time) select id,title,url,'[{\"name\":\"商品类目\",\"level\":2,\"values\":[],\"desc\":\"商品类目ID\"},{\"name\":\"品牌\",\"level\":3,\"values\":[],\"desc\":\"品牌名称\"},{\"name\":\"位置\",\"level\":6,\"values\":[],\"desc\":\"地理位置\"},{\"name\":\"性别\",\"level\":1,\"values\":[\"男\",\"女\"],\"desc\":\"性别\"},{\"name\":\"年龄\",\"level\":5,\"values\":[\"18-80\"],\"desc\":\"年龄范围\"},{\"name\":\"资产\",\"level\":6,\"values\":[],\"desc\":\"资产范围(宝币)\"}]',#{state},NOW() from sign_tweets_pool where id = #{tweetId} ")
    public void insertTweet( @Param("tweetId") long tweetId,  @Param("state") int state );

    @Select("select * from ${tableName} where id = #{id}  limit 0,1")
    @ResultMap("TweetsPoolMap")
    TweetInfo getTweetInfoIngoreState(@Param("tableName") String tableName, @Param("id") long id);
}

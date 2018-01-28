package com.qbao.recommend.respositoy.mysql.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.qbao.recommend.respositoy.mysql.model.UserViewBuy;



/**
 * 数据表user_view_buy推荐结果操作接口
 * @author zhangjun
 * @Date 2016-07-21
 *
 */
@Component
public interface UserViewBuyDao {
	
	@Select("select * from ${tableName} where user_id = #{id}  order by action_time desc")
	@ResultMap("UserViewBuyMap")
	public List<UserViewBuy> findById(@Param("tableName") String tableName,@Param("id") long id);
}

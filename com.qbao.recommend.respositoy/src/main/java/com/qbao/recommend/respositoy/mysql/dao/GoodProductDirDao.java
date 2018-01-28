package com.qbao.recommend.respositoy.mysql.dao;

import com.qbao.recommend.respositoy.mysql.model.GoodProductDir;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by shuaizhihu on 2016/11/22.
 */
public interface GoodProductDirDao {

    @Select("select * from good_product_dir order by sort asc")
    @ResultMap("GoodProductDirMap")
    public List<GoodProductDir> findList();

    @Select("select * from good_product_dir where id = #{id}")
    @ResultMap("GoodProductDirMap")
    public GoodProductDir  findById(long id);
}

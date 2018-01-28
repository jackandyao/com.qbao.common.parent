package com.qbao.recommend.business.product.cmp.common;

 
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;

/**
 * Created by THink on 2016/7/13.
 * 贾红平
 *
 */
public abstract  class AbstractRecommedService {

    protected Logger servericeLogger = LoggerManagerUtil.getLogger(LogNameEnum.spu_service, Level.INFO);

    protected boolean is_similar=false;
    protected boolean is_directory=false;
    protected int num=0;

    /**
     * 初始化基本数据
     * @param jsonObject
     */
    protected void initParamData(JSONObject jsonObject){
        //获取每种不同算法显示的记录条数
        num=Integer.parseInt(jsonObject.get(RecommendConstantUtil.SHOW_NUM).toString());
        //是否给每个产品取相似产品
       is_similar=Boolean.parseBoolean(jsonObject.get(RecommendConstantUtil.IS_SIMILAR).toString());
        //是否给每个产品取关联产品
       is_directory=Boolean.parseBoolean(jsonObject.get(RecommendConstantUtil.IS_DIRECTORY).toString());
    }
    
   
    
}

package com.qbao.recommend.business.shop.cmp.handler;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;

/**
 * Created by THink on 2016/7/7.
 * 贾红平
 * 定义关于推荐的一个处理器
 */
public interface RecommendHandler {
    Logger handleLogger = LoggerManagerUtil.getLogger(LogNameEnum.shop_facade, Level.INFO);

    /**
     * 定义数据处理接口
     * @param t
     * @param <T>
     */
    public abstract <T> void executeHandler(T t);
}

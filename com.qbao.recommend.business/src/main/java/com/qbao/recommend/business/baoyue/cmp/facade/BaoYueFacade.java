package com.qbao.recommend.business.baoyue.cmp.facade;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.qbao.recommend.business.baoyue.cmp.service.IBaoyueService;
import com.qbao.recommend.business.baoyue.cmp.service.IBaoyueValicateService;
import com.qbao.recommend.business.baoyue.cmp.util.BaoYueConstantUtil;
import com.qbao.recommend.business.baoyue.cmp.util.BaoYueUtils;
import com.qbao.recommend.business.baoyue.cmp.util.ParametersUtil;
import com.qbao.recommend.business.baoyue.rest.dto.BaoYueDto;
import com.qbao.recommend.respositoy.restful.entities.User;
import com.qbao.recommend.respositoy.restful.service.ILBSService;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangping
 * @createTime 上午11:55 $$LastChangedDate: 2016-11-14 14:36:34 +0800 (周一, 14 十一月
 *             2016) $$ $$LastChangedRevision: 1506 $$ $$LastChangedBy: wangping
 *             $$
 */
@Component
public class BaoYueFacade {

    @Autowired
    @Qualifier("lBSServiceImpl")
    ILBSService lBSService;

    @Autowired
    IBaoyueService baoyueService;

    @Autowired
    IBaoyueValicateService baoyueValicateService;

    private Logger error = LoggerManagerUtil.getLogger(LogNameEnum.bao_yue, Level.ERROR);
    private Logger infoLogger = LoggerManagerUtil.getLogger(LogNameEnum.bao_yue, Level.INFO);

    public List<BaoYueDto> recommend(Map<String, Object> requestParams, JSONObject context) {
        Long themeId = (Long) ParametersUtil.getParameter(requestParams, BaoYueConstantUtil.THEME_ID);
        String title = (String) ParametersUtil.getParameter(requestParams, BaoYueConstantUtil.TITLE);
        int limit = (Integer) ParametersUtil.getParameter(requestParams, BaoYueConstantUtil.LIMIT);
        Preconditions.checkNotNull(title, "The theme title empty or null");
        Preconditions.checkNotNull(themeId, "The theme id is empty or null");

        boolean validTheme = baoyueValicateService.validation(title);
        infoLogger.info("The Theme title ["+title+"] is valid = " + validTheme);
        if(!validTheme){
           return Lists.newArrayList();
       }
        Map<String, Object> lbsPara = lbsParameters(requestParams, context);
        List<User> nearByUsers = Lists.newArrayList();
        try {
            nearByUsers = lBSService.queryUsersNearby(lbsPara);
        } catch (IOException e) {
            error.error("宝约推荐接口requestParams:" + requestParams + ", context:" + context, e);
        }

        infoLogger.info("totally get [" + nearByUsers.size() + "]  user ids, near by the site dating");
        List<Long> lbsUserIds = BaoYueUtils.getUserId(nearByUsers);
        infoLogger.info("LBS Service return the user ids : " + lbsUserIds);
        List<BaoYueDto> dtos = baoyueService.filter(nearByUsers, themeId, limit);
        infoLogger.info("Bao Yue Service match [" + title + "] user dtos : " + dtos);
        return dtos;
    }

    private Map<String, Object> lbsParameters(Map<String, Object> requestParams, JSONObject context) {
        Map<String, Object> map = Maps.newHashMap();
        Long distance = (Long) ParametersUtil.getParameter(requestParams, BaoYueConstantUtil.RANGE, 20000L);//20KM
       // long userId = (Long) ParametersUtil.getParameter(requestParams, BaoYueConstantUtil.USER_ID);//20KM
        int limit = (Integer) ParametersUtil.getParameter(requestParams, BaoYueConstantUtil.LIMIT);
        int pageSize = (Integer) ParametersUtil.getParameter(context, BaoYueConstantUtil.PAGE_SIZE, 10000);
        String type = (String) ParametersUtil.getParameter(context, BaoYueConstantUtil.LBS_TYPE, "50");
        Double lat = (Double) ParametersUtil.getParameter(requestParams, BaoYueConstantUtil.LAT);
        Double lon = (Double) ParametersUtil.getParameter(requestParams, BaoYueConstantUtil.LON);
        Preconditions.checkNotNull(lat, "the lat is null ,please pass the value into request parameters");
        Preconditions.checkNotNull(lon, "the lon is null ,please pass the value into request parameters");
        map.put("type", type);
        map.put("distance", distance);
        map.put("pageNo", 1);
        map.put("pageSize", limit< 100? limit*100 : pageSize);

        Map<String, Object> nearby = new HashMap<>();
        nearby.put("coord", new double[] { lon, lat });
        nearby.put("must_not", getMustNot(-1L,0L)); // 排除用户id不存在的问题
        map.put("nearby", nearby);

        return map;
    }

    private List<Map<String,Object>> getMustNot(long ... userIds){
        List<Map<String,Object>> termList = new ArrayList();
        for(long userId : userIds){
            Map<String, Object> term = new HashMap<>();
            Map<String, Object> user = new HashMap<>();
            user.put("user_id", String.valueOf(userId));
            term.put("term", user);
            termList.add(term);
        }
        return termList;
    }


}

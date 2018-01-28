package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class RecommendItems implements Serializable {
    private static final long serialVersionUID = "$Id: RecommendItems.java 1257 2016-10-09 10:24:56Z shuaizhihu $".hashCode();
    private long userId;
    private String spuIds;

    public RecommendItems() {
    }

    public RecommendItems(long userId, String spuIds) {
        super();
        this.userId = userId;
        this.spuIds = spuIds;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getSpuIds() {
        return spuIds;
    }

    public void setSpuIds(String spuIds) {
        this.spuIds = spuIds;
    }

    @Override
    public String toString() {
        return "RecommendItems [userId=" + userId + ", spuIds=" + spuIds + "]";
    }
    
    public List<Long> calSpuIdsList(){
        List<Long> spuIdsList = new ArrayList<Long>();
        if(!StringUtils.isEmpty(spuIds)){
            String[] idscores = spuIds.split(",");
            for(String idscore:idscores){
                String[] is = idscore.split(":");
                if(is.length==2){
                    spuIdsList.add(Long.parseLong(is[0]));
                }
            }
        }
        return spuIdsList;
    }

}

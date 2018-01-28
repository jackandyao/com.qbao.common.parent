package com.qbao.recommend.respositoy.redis.model;

import java.io.Serializable;
import java.util.List;

//用户浏览商品记录
public class UserViewCountData implements Serializable {

    private String uid;
    private List<SpuCount> spus;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<SpuCount> getSpus() {
        return spus;
    }

    public void setSpus(List<SpuCount> spus) {
        this.spus = spus;
    }

}

package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;

/**
 * @author yuandongrui
 * @date 2016年6月29日
 */
public class ProductProfile implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 8879618670955471020L;
    private long pid;
    private String items;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ProductProfile [pid=" + pid + ", items=" + items + "]";
    }
}

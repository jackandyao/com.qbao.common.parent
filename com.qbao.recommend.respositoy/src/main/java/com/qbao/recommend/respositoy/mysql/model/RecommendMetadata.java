package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;
/**
 *   推荐元数据保存对象
     * @author 贾红平
     * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
     * $LastChangedRevision: 896 $
     * $LastChangedBy: jiahongping $
 */
public class RecommendMetadata implements Serializable {
    public RecommendMetadata() {
        
    }
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public RecommendMetadata(int id, String param_key, String param_value) {
        super();
        this.id = id;
        this.param_key = param_key;
        this.param_value = param_value;
    }
    public String getParam_key() {
        return param_key;
    }
    public void setParam_key(String param_key) {
        this.param_key = param_key;
    }
    public String getParam_value() {
        return param_value;
    }
    public void setParam_value(String param_value) {
        this.param_value = param_value;
    }
    private String param_key;
    private String param_value;
}

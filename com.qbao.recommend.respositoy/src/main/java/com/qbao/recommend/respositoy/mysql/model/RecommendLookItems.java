package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecommendLookItems implements Serializable {
    private static final long serialVersionUID = "$Id: RecommendLookItems.java 1028 2016-09-14 10:07:53Z shuaizhihu $".hashCode();
    private long id;
    private String items;
    private int type;

    public RecommendLookItems() {
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the items
     */
    public String getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(String items) {
        this.items = items;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "RecommendLookItems [id=" + id + ", items=" + items + ", type=" + type + "]";
    }
    
    
    public List<Long> getSpuIdList(){
        List<Long> spuIds = new ArrayList<Long> ();
        String[] ids = this.items.split(",");
        for(String id:ids){
            spuIds.add(Long.parseLong(id));
        }
        return spuIds;
    }


}

package com.qbao.dc.redis.model;

import java.io.Serializable;
import java.util.ArrayList;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.json.JSONArray;
import org.json.JSONObject;

import com.qbao.recommend.respositoy.redis.model.Click;
import com.qbao.recommend.respositoy.redis.model.Event;
import com.qbao.recommend.respositoy.redis.model.Favorites;
import com.qbao.recommend.respositoy.redis.model.GoodsItems;

public class UserItemsBean implements Serializable {
    private static final long serialVersionUID = "$Id: UserItemsBean.java 1116 2016-09-21 02:41:55Z shuaizhihu $".hashCode();
    private boolean flag;
    private ArrayList<GoodsItems> goodsItems;
    private String userId;
    private Event event;
    private String createTime;
    private String updateTime;

    public UserItemsBean() {

    }

    public UserItemsBean(JSONObject json) {

        this.flag = json.optBoolean("flag");

        this.goodsItems = new ArrayList<GoodsItems>();
        JSONArray arrayGoodsItems = json.optJSONArray("goods_items");
        if (null != arrayGoodsItems) {
            int goodsItemsLength = arrayGoodsItems.length();
            for (int i = 0; i < goodsItemsLength; i++) {
                JSONObject item = arrayGoodsItems.optJSONObject(i);
                if (null != item) {
                    this.goodsItems.add(new GoodsItems(item));
                }
            }
        } else {
            JSONObject item = json.optJSONObject("goods_items");
            if (null != item) {
                this.goodsItems.add(new GoodsItems(item));
            }
        }

        this.userId = json.optString("user_id");
        this.event = new Event(json.optJSONObject("event"));
        this.createTime = json.optString("create_time");
        this.updateTime = json.optString("update_time");

    }

    public boolean getFlag() {
        return this.flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public ArrayList<GoodsItems> getGoodsItems() {
        return this.goodsItems;
    }

    public void setGoodsItems(ArrayList<GoodsItems> goodsItems) {
        this.goodsItems = goodsItems;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Event getEvent() {
        return this.event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(ToStringStyle.MULTI_LINE_STYLE);
    }

    public static UserItemsBean createDefaultUserItemBean(){
        UserItemsBean userItems = new UserItemsBean();
        userItems.setGoodsItems(new ArrayList<GoodsItems>());
        Event event = new Event();
        event.setClick(new ArrayList<Click>());
        event.setFavorites(new ArrayList<Favorites>());
        userItems.setEvent(event );
        return userItems;
    }
}


package com.qbao.recommend.stream.cmp.domain.nginx;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.qbao.recommend.stream.cmp.enums.EventType;
import com.qbao.recommend.stream.cmp.enums.PlatformType;
import com.qbao.recommend.stream.cmp.enums.TopicType;

/**
 * 封装日志数据模型对象
 * 
 * @author 贾红平
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
public class Record {
    private String userId;
    private String goodsId;
    private EventType type;
    private PlatformType platform;
    private boolean isBaoGou;
    private TopicType topicType;

    public Record() {
    }

    public Record(String userId, String goodsId) {
        this.userId = userId;
        this.goodsId = goodsId;
    }

    public Record(String userId, String goodsId, EventType type, TopicType topicType, boolean isBaoGou) {
        this.userId = userId;
        this.goodsId = goodsId;
        this.type = type;
        this.topicType = topicType;
        this.isBaoGou = isBaoGou;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodsId() {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public EventType getEventType() {
        return this.type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public boolean getIsBaoGou() {
        return this.isBaoGou;
    }

    public void setIsBaoGou(boolean isBaoGou) {
        this.isBaoGou = isBaoGou;
    }

    public PlatformType getPlatform() {
        return this.platform;
    }

    public void setPlatform(PlatformType platform) {
        this.platform = platform;
    }

    public EventType getType() {
        return this.type;
    }

    public TopicType getTopicType() {
        return topicType;
    }

    public void setTopicType(TopicType topicType) {
        this.topicType = topicType;
    }

    public void setBaoGou(boolean isBaoGou) {
        this.isBaoGou = isBaoGou;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
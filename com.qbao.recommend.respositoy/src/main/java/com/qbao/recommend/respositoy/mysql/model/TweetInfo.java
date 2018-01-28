package com.qbao.recommend.respositoy.mysql.model;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public class TweetInfo implements Serializable , Comparable<TweetInfo>{
    private static final long serialVersionUID = "$Id$".hashCode();

    private long id;
    private String sn;
    private String title;
    private String keywords;
    private String url;
    private int status;
    private Date createTime;
    private Date updateTime;
    private String source;
    private long businessId;
    private int priority ; //优先级数字越低优先级越高
    private String city;
    private String province;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source
     * the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    //hard code 后面支持从priority读取
    public int calPriority(){
        if(StringUtils.isNotBlank(city) || StringUtils.isNotBlank(province)){
            return -1;
        }else
            return 10;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof TweetInfo))
            return false;

        TweetInfo tweetInfo = (TweetInfo) o;

        return new EqualsBuilder()
                .append(getId(), tweetInfo.getId())
                .append(getStatus(), tweetInfo.getStatus())
                .append(getBusinessId(), tweetInfo.getBusinessId())
                .append(getPriority(), tweetInfo.getPriority())
                .append(getSn(), tweetInfo.getSn())
                .append(getTitle(), tweetInfo.getTitle())
                .append(getKeywords(), tweetInfo.getKeywords())
                .append(getUrl(), tweetInfo.getUrl())
                .append(getCreateTime(), tweetInfo.getCreateTime())
                .append(getUpdateTime(), tweetInfo.getUpdateTime())
                .append(getSource(), tweetInfo.getSource())
                .append(getCity(), tweetInfo.getCity())
                .append(getProvince(), tweetInfo.getProvince())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(getSn())
                .append(getTitle())
                .append(getKeywords())
                .append(getUrl())
                .append(getStatus())
                .append(getCreateTime())
                .append(getUpdateTime())
                .append(getSource())
                .append(getBusinessId())
                .append(getPriority())
                .append(getCity())
                .append(getProvince())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("sn", sn)
                .append("title", title)
                .append("url", url)
                .append("status", status)
                .append("source", source)
                .append("businessId", businessId)
                .append("priority", priority)
                .append("city", city)
                .append("province", province)
                .toString();
    }

    @Override
    public int compareTo(TweetInfo o) {
        return (this.calPriority() > o.calPriority()) ? 1 : -1;
    }
}

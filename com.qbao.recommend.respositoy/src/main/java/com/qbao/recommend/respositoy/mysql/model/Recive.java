
package com.qbao.recommend.respositoy.mysql.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Recive {

    @SerializedName("publish_user_id")
    @Expose
    private Long publishUserId;
    @SerializedName("task_id")
    @Expose
    private Long taskId;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("do_time")
    @Expose
    private String doTime;
    @SerializedName("task_type")
    @Expose
    private Integer taskType;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("geo")
    @Expose
    private Geo geo;

    /**
     * 
     * @return
     *     The publishUserId
     */
    public Long getPublishUserId() {
        return publishUserId;
    }

    /**
     * 
     * @param publishUserId
     *     The publish_user_id
     */
    public void setPublishUserId(Long publishUserId) {
        this.publishUserId = publishUserId;
    }

    /**
     * 
     * @return
     *     The taskId
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * 
     * @param taskId
     *     The task_id
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * 
     * @return
     *     The content
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content
     *     The content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     * @return
     *     The doTime
     */
    public String getDoTime() {
        return doTime;
    }

    /**
     * 
     * @param doTime
     *     The do_time
     */
    public void setDoTime(String doTime) {
        this.doTime = doTime;
    }

    /**
     * 
     * @return
     *     The taskType
     */
    public Integer getTaskType() {
        return taskType;
    }

    /**
     * 
     * @param taskType
     *     The task_type
     */
    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    /**
     * 
     * @return
     *     The city
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return
     *     The address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     *     The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     * @return
     *     The geo
     */
    public Geo getGeo() {
        return geo;
    }

    /**
     * 
     * @param geo
     *     The geo
     */
    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(publishUserId).append(taskId).append(content).append(doTime).append(taskType).append(city).append(address).append(geo).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Recive) == false) {
            return false;
        }
        Recive rhs = ((Recive) other);
        return new EqualsBuilder().append(publishUserId, rhs.publishUserId).append(taskId, rhs.taskId).append(content, rhs.content).append(doTime, rhs.doTime).append(taskType, rhs.taskType).append(city, rhs.city).append(address, rhs.address).append(geo, rhs.geo).isEquals();
    }

}

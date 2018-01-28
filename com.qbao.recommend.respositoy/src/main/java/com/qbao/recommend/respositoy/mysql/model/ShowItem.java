
package com.qbao.recommend.respositoy.mysql.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class ShowItem {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("type_name")
    @Expose
    private String typeName;
    @SerializedName("create_time")
    @Expose
    private String createTime;
    @SerializedName("ticket_num")
    @Expose
    private Integer ticketNum;
    @SerializedName("venue")
    @Expose
    private String venue;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lon")
    @Expose
    private String lon;

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 
     * @param typeName
     *     The type_name
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * 
     * @return
     *     The createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime
     *     The create_time
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * @return
     *     The ticketNum
     */
    public Integer getTicketNum() {
        return ticketNum;
    }

    /**
     * 
     * @param ticketNum
     *     The ticket_num
     */
    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }

    /**
     * 
     * @return
     *     The venue
     */
    public String getVenue() {
        return venue;
    }

    /**
     * 
     * @param venue
     *     The venue
     */
    public void setVenue(String venue) {
        this.venue = venue;
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
     *     The lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * 
     * @return
     *     The lon
     */
    public String getLon() {
        return lon;
    }

    /**
     * 
     * @param lon
     *     The lon
     */
    public void setLon(String lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(title).append(typeName).append(createTime).append(ticketNum).append(venue).append(address).append(lat).append(lon).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ShowItem) == false) {
            return false;
        }
        ShowItem rhs = ((ShowItem) other);
        return new EqualsBuilder().append(title, rhs.title).append(typeName, rhs.typeName).append(createTime, rhs.createTime).append(ticketNum, rhs.ticketNum).append(venue, rhs.venue).append(address, rhs.address).append(lat, rhs.lat).append(lon, rhs.lon).isEquals();
    }

}


package com.qbao.recommend.respositoy.mysql.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class FilmItem {

    @SerializedName("film_name")
    @Expose
    private String filmName;
    @SerializedName("film_type")
    @Expose
    private String filmType;
    @SerializedName("create_time")
    @Expose
    private String createTime;
    @SerializedName("ticket_num")
    @Expose
    private Integer ticketNum;
    @SerializedName("cinema_name")
    @Expose
    private String cinemaName;
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
     *     The filmName
     */
    public String getFilmName() {
        return filmName;
    }

    /**
     * 
     * @param filmName
     *     The film_name
     */
    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    /**
     * 
     * @return
     *     The filmType
     */
    public String getFilmType() {
        return filmType;
    }

    /**
     * 
     * @param filmType
     *     The film_type
     */
    public void setFilmType(String filmType) {
        this.filmType = filmType;
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
     *     The cinemaName
     */
    public String getCinemaName() {
        return cinemaName;
    }

    /**
     * 
     * @param cinemaName
     *     The cinema_name
     */
    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
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
        return new HashCodeBuilder().append(filmName).append(filmType).append(createTime).append(ticketNum).append(cinemaName).append(address).append(lat).append(lon).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FilmItem) == false) {
            return false;
        }
        FilmItem rhs = ((FilmItem) other);
        return new EqualsBuilder().append(filmName, rhs.filmName).append(filmType, rhs.filmType).append(createTime, rhs.createTime).append(ticketNum, rhs.ticketNum).append(cinemaName, rhs.cinemaName).append(address, rhs.address).append(lat, rhs.lat).append(lon, rhs.lon).isEquals();
    }

}

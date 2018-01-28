
package com.qbao.recommend.respositoy.mysql.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class BaseInfo {

    @SerializedName("id_code")
    @Expose
    private String idCode;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("age")
    @Expose
    private Long age;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("constellation")
    @Expose
    private String constellation;
    @SerializedName("birthday")
    @Expose
    private String birthday;

    /**
     * 
     * @return
     *     The idCode
     */
    public String getIdCode() {
        return idCode;
    }

    /**
     * 
     * @param idCode
     *     The id_code
     */
    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    /**
     * 
     * @return
     *     The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 
     * @param gender
     *     The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 
     * @return
     *     The age
     */
    public Long getAge() {
        return age;
    }

    /**
     * 
     * @param age
     *     The age
     */
    public void setAge(Long age) {
        this.age = age;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The constellation
     */
    public String getConstellation() {
        return constellation;
    }

    /**
     * 
     * @param constellation
     *     The constellation
     */
    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    /**
     * 
     * @return
     *     The birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 
     * @param birthday
     *     The birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(idCode).append(gender).append(age).append(name).append(constellation).append(birthday).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BaseInfo) == false) {
            return false;
        }
        BaseInfo rhs = ((BaseInfo) other);
        return new EqualsBuilder().append(idCode, rhs.idCode).append(gender, rhs.gender).append(age, rhs.age).append(name, rhs.name).append(constellation, rhs.constellation).append(birthday, rhs.birthday).isEquals();
    }

}

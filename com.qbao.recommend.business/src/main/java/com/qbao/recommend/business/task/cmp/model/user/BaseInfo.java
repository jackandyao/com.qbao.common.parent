
package com.qbao.recommend.business.task.cmp.model.user;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class BaseInfo {

    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("constellation")
    @Expose
    private String constellation;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("id_code")
    @Expose
    private String idCode;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * 
     * @return
     *     The age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 
     * @param age
     *     The age
     */
    public void setAge(Integer age) {
        this.age = age;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(age).append(birthday).append(constellation).append(gender).append(idCode).append(name).toHashCode();
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
        return new EqualsBuilder().append(age, rhs.age).append(birthday, rhs.birthday).append(constellation, rhs.constellation).append(gender, rhs.gender).append(idCode, rhs.idCode).append(name, rhs.name).isEquals();
    }

}

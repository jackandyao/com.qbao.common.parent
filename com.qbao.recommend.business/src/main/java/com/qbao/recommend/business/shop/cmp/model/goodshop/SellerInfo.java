package com.qbao.recommend.business.shop.cmp.model.goodshop;



import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class SellerInfo {

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

}

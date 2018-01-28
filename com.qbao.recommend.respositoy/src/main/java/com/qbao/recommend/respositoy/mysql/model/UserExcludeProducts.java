
package com.qbao.recommend.respositoy.mysql.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated("org.jsonschema2pojo")
public class UserExcludeProducts {
    private static Gson gson = new GsonBuilder().serializeNulls().create();
    @SerializedName("user_id")
    @Expose
    private String userId;

    @SerializedName("exclude_product")
    @Expose
    private List<ExcludeProduct> excludeProducts = new ArrayList<ExcludeProduct>();

    /**
     * 
     * @return
     *     The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId
     *     The user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<ExcludeProduct> getExcludeProducts() {
        return excludeProducts;
    }

    public void setExcludeProducts(List<ExcludeProduct> excludeProducts) {
        this.excludeProducts = excludeProducts;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(userId).append(excludeProducts).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UserExcludeProducts) == false) {
            return false;
        }
        UserExcludeProducts rhs = ((UserExcludeProducts) other);
        return new EqualsBuilder().append(userId, rhs.userId).append(excludeProducts, rhs.excludeProducts).isEquals();
    }

    public String toJson(){
        return gson.toJson(this,this.getClass());
    }

}

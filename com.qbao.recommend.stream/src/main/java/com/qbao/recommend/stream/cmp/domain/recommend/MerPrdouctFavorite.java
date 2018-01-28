/**
 * 
 */
package com.qbao.recommend.stream.cmp.domain.recommend;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class MerPrdouctFavorite {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("create_time")
    @Expose
    private String createTime;
    

    /**
     * 
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     * The productId
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 
     * @param productId
     * The product_id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 
     * @return
     * The userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId
     * The user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 
     * @return
     * The createTime
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime
     * The create_time
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(productId).append(userId).append(createTime).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MerPrdouctFavorite) == false) {
            return false;
        }
        MerPrdouctFavorite rhs = ((MerPrdouctFavorite) other);
        return new EqualsBuilder().append(id, rhs.id).append(productId, rhs.productId).append(userId, rhs.userId).append(createTime, rhs.createTime).isEquals();
    }

}
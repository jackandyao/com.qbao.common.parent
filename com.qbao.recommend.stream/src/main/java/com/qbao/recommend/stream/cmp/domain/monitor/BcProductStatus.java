/**
 * 
 */
package com.qbao.recommend.stream.cmp.domain.monitor;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */

@Generated("org.jsonschema2pojo")
public class BcProductStatus {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("state")
    @Expose
    private Integer state;

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
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     * The state
     */
    public Integer getState() {
        return state;
    }

    /**
     * 
     * @param state
     * The state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BcProductStatus) == false) {
            return false;
        }
        BcProductStatus rhs = ((BcProductStatus) other);
        return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(state, rhs.state).isEquals();
    }

}

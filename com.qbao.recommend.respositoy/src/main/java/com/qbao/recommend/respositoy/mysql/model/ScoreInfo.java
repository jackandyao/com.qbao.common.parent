
package com.qbao.recommend.respositoy.mysql.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class ScoreInfo {

    @SerializedName("score")
    @Expose
    private Long score;
    @SerializedName("update_time")
    @Expose
    private String updateTime;

    /**
     * 
     * @return
     *     The score
     */
    public Long getScore() {
        return score;
    }

    /**
     * 
     * @param score
     *     The score
     */
    public void setScore(Long score) {
        this.score = score;
    }

    /**
     * 
     * @return
     *     The updateTime
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     * @param updateTime
     *     The update_time
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(score).append(updateTime).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ScoreInfo) == false) {
            return false;
        }
        ScoreInfo rhs = ((ScoreInfo) other);
        return new EqualsBuilder().append(score, rhs.score).append(updateTime, rhs.updateTime).isEquals();
    }

}

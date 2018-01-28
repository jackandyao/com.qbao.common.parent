
package com.qbao.recommend.respositoy.mysql.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class BaoYue {

    @SerializedName("publish")
    @Expose
    private List<Publish> publish = new ArrayList<Publish>();
    @SerializedName("recive")
    @Expose
    private List<Recive> recive = new ArrayList<Recive>();

    /**
     * 
     * @return
     *     The publish
     */
    public List<Publish> getPublish() {
        return publish;
    }

    /**
     * 
     * @param publish
     *     The publish
     */
    public void setPublish(List<Publish> publish) {
        this.publish = publish;
    }

    /**
     * 
     * @return
     *     The recive
     */
    public List<Recive> getRecive() {
        return recive;
    }

    /**
     * 
     * @param recive
     *     The recive
     */
    public void setRecive(List<Recive> recive) {
        this.recive = recive;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(publish).append(recive).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BaoYue) == false) {
            return false;
        }
        BaoYue rhs = ((BaoYue) other);
        return new EqualsBuilder().append(publish, rhs.publish).append(recive, rhs.recive).isEquals();
    }

}

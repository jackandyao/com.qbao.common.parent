package com.qbao.recommend.respositoy.mysql.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author wangping
 * @createTime 下午5:44
 * $$LastChangedDate: 2016-11-09 19:59:02 +0800 (Wed, 09 Nov 2016) $$
 * $$LastChangedRevision: 1377 $$
 * $$LastChangedBy: wangping $$
 */

public class UserExcludeProductJson implements Serializable {
    private static final long serialVersionUID = "$Id: UserExcludeProductJson.java 1377 2016-11-09 11:59:02Z wangping $".hashCode();
    private static Gson gson = new GsonBuilder().serializeNulls().create();
    private long userId;
    private String json;
    private UserExcludeProducts model = null;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof UserExcludeProductJson))
            return false;

        UserExcludeProductJson that = (UserExcludeProductJson) o;

        return new EqualsBuilder()
                .append(getUserId(), that.getUserId())
                .append(getJson(), that.getJson())
                .isEquals();
    }

    public UserExcludeProducts json2Model() {
        if (null == model)
            model = gson.fromJson(this.json, UserExcludeProducts.class);
        return model;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getUserId())
                .append(getJson())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userId", userId)
                .append("json", json)
                .toString();
    }
}

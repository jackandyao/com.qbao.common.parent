package com.qbao.recommend.respositoy.mysql.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author wangping
 * @createTime 下午3:03
 * $$LastChangedDate: 2017-01-12 15:34:26 +0800 (Thu, 12 Jan 2017) $$
 * $$LastChangedRevision: 1543 $$
 * $$LastChangedBy: wangping $$
 */
public class TweetOwnerWapper  implements Serializable {

    private  final long serialVersionUID = "$Id: TweetOwnerWapper.java 1543 2017-01-12 07:34:26Z wangping $".hashCode();
    private Map<Long,Set<Long>> owenrMapping = new HashMap<>();

    public Map<Long, Set<Long>> getOwenrMapping() {
        return owenrMapping;
    }

    public void setOwenrMapping(Map<Long, Set<Long>> owenrMapping) {
        this.owenrMapping = owenrMapping;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof TweetOwnerWapper))
            return false;

        TweetOwnerWapper that = (TweetOwnerWapper) o;

        return new EqualsBuilder()
                .append(serialVersionUID, that.serialVersionUID)
                .append(getOwenrMapping(), that.getOwenrMapping())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(serialVersionUID)
                .append(getOwenrMapping())
                .toHashCode();
    }
}

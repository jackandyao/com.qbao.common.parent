package com.qbao.recommend.business.baoyue.rest.dto;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * @author wangping
 * @createTime 上午11:05
 * $$LastChangedDate: 2016-12-05 18:53:02 +0800 (Mon, 05 Dec 2016) $$
 * $$LastChangedRevision: 1510 $$
 * $$LastChangedBy: wangping $$
 */
public class BaoYueDto implements Serializable {
    private static final long serialVersionUID = "$Id: BaoYueDto.java 1510 2016-12-05 10:53:02Z wangping $".hashCode();
    private long id;
    private String matchRule;
    private double distance;

    
    public BaoYueDto() {}

    public BaoYueDto(long id, String matchRule, double distance) {
        this.matchRule = matchRule;
        this.id = id;
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMatchRule() {
        return matchRule;
    }

    public void setMatchRule(String matchRule) {
        this.matchRule = matchRule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof BaoYueDto))
            return false;

        BaoYueDto dto = (BaoYueDto) o;

        return new EqualsBuilder()
                .append(getId(), dto.getId())
                .append(getDistance(), dto.getDistance())
                .append(getMatchRule(), dto.getMatchRule())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(getMatchRule())
                .append(getDistance())
                .toHashCode();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BaoYueDto [");
        sb.append("id=").append(id);
        sb.append(", matchRule='").append(matchRule).append('\'');
        sb.append(", distance=").append(distance);
        sb.append(']');
        return sb.toString();
    }
}

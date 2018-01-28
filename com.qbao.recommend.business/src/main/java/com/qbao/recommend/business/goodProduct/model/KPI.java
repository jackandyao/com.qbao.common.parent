package com.qbao.recommend.business.goodProduct.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author wangping
 * @createTime 下午4:16
 * $$LastChangedDate: 2016-11-14 14:19:26 +0800 (Mon, 14 Nov 2016) $$
 * $$LastChangedRevision: 1386 $$
 * $$LastChangedBy: jiahongping $$
 */
public class KPI {
    private int sortId;
    private String name;
    private double score;
    private String content;

    public int getSortId() {
        return sortId;
    }

    public KPI setSortId(int sortId) {
        this.sortId = sortId;
        return this;
    }

    public String getName() {
        return name;
    }

    public KPI setName(String name) {
        this.name = name;
        return this;
    }

    public double getScore() {
        return score;
    }

    public KPI setScore(double score) {
        this.score = score;
        return this;
    }

    public String getContent() {
        return content;
    }

    public KPI setContent(String content) {
        this.content = content;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof KPI))
            return false;

        KPI kpi = (KPI) o;

        return new EqualsBuilder()
                .append(getSortId(), kpi.getSortId())
                .append(getScore(), kpi.getScore())
                .append(getName(), kpi.getName())
                .append(getContent(), kpi.getContent())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getSortId())
                .append(getName())
                .append(getScore())
                .append(getContent())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("sortId", sortId)
                .append("name", name)
                .append("score", score)
                .append("content", content)
                .toString();
    }
}

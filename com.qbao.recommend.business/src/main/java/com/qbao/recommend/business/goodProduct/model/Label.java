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
public class Label {
    private int sortId;
    private String label;

    public int getSortId() {
        return sortId;
    }

    public Label setSortId(int sortId) {
        this.sortId = sortId;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public Label setLable(String label) {
        this.label = label;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Label))
            return false;

        Label label = (Label) o;

        return new EqualsBuilder()
                .append(getSortId(), label.getSortId())
                .append(getLabel(), label.getLabel())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getSortId())
                .append(getLabel())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("sortId", sortId)
                .append("label", label)
                .toString();
    }
}

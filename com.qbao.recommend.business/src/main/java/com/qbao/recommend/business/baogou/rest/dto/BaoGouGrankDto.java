package com.qbao.recommend.business.baogou.rest.dto;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author wangping
 * @createTime 下午4:51
 * $$LastChangedDate: 2016-11-15 18:34:23 +0800 (Tue, 15 Nov 2016) $$
 * $$LastChangedRevision: 1398 $$
 * $$LastChangedBy: wangping $$
 */
public class BaoGouGrankDto implements Serializable {
    private static final long serialVersionUID = "$Id: BaoGouGrankDto.java 1398 2016-11-15 10:34:23Z wangping $".hashCode();
    private Long baoGouId;
    private Long spuId;
    private double score;

    public Long getBaoGouId() {
        return baoGouId;
    }

    public void setBaoGouId(Long baoGouId) {
        this.baoGouId = baoGouId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("baoGouId", baoGouId)
                .append("spuId", spuId)
                .append("score", score)
                .toString();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (!(o instanceof BaoGouGrankDto))
            return false;

        BaoGouGrankDto that = (BaoGouGrankDto) o;

        return new EqualsBuilder()
                .append(getScore(), that.getScore())
                .append(getBaoGouId(), that.getBaoGouId())
                .append(getSpuId(), that.getSpuId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getBaoGouId())
                .append(getSpuId())
                .append(getScore())
                .toHashCode();
    }
}

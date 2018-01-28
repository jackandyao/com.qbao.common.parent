package com.qbao.recommend.respositoy.mysql.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * @author wangping
 * @createTime 下午4:53
 * $$LastChangedDate: 2016-10-27 21:31:15 +0800 (Thu, 27 Oct 2016) $$
 * $$LastChangedRevision: 1336 $$
 * $$LastChangedBy: wangping $$
 */
public class GRank implements Serializable {
    private static final long serialVersionUID = "$Id: GRank.java 1336 2016-10-27 13:31:15Z wangping $".hashCode();
    private long spuId;
    private int state; // COMMENT '状态 ',
    private int priority ; //等级 1表示必购好货来源，2表示商品详情页来源，3表示好店来源
    private double score;
    private int num;

    public long getSpuId() {
        return spuId;
    }

    public void setSpuId(long spuId) {
        this.spuId = spuId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof GRank))
            return false;

        GRank gRank = (GRank) o;

        return new EqualsBuilder()
                .append(getSpuId(), gRank.getSpuId())
                .append(getState(), gRank.getState())
                .append(getPriority(), gRank.getPriority())
                .append(getScore(), gRank.getScore())
                .append(getNum(), gRank.getNum())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getSpuId())
                .append(getState())
                .append(getPriority())
                .append(getScore())
                .append(getNum())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("spuId", spuId)
                .append("state", state)
                .append("priority", priority)
                .append("score", score)
                .append("num", num)
                .toString();
    }
}

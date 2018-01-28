package com.qbao.recommend.business.goodProduct.rest.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author wangping
 * @createTime 下午2:24
 * $$LastChangedDate: 2016-11-14 14:19:26 +0800 (Mon, 14 Nov 2016) $$
 * $$LastChangedRevision: 1386 $$
 * $$LastChangedBy: jiahongping $$
 */
public class PerformanceDTO implements Serializable {

    private static final long serialVersionUID = "$Id: PerformanceDTO.java 1386 2016-11-14 06:19:26Z jiahongping $".hashCode();
    private Long goodsId;
    private String goodsName;
    private String soldRate;
    private List<Map<String,Object>> sellTrend;
    private List<Map<String,Object>>  report;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSoldRate() {
        return soldRate;
    }

    public void setSoldRate(String soldRate) {
        this.soldRate = soldRate;
    }

    public List<Map<String,Object>> getSellTrend() {
        return sellTrend;
    }

    public void setSellTrend(List<Map<String,Object>> sellTrend) {
        this.sellTrend = sellTrend;
    }

    public List<Map<String,Object>>  getReport() {
        return report;
    }

    public void setReport(List<Map<String,Object>> report) {
        this.report = report;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof PerformanceDTO))
            return false;

        PerformanceDTO that = (PerformanceDTO) o;

        return new EqualsBuilder()
                .append(getGoodsId(), that.getGoodsId())
                .append(getGoodsName(), that.getGoodsName())
                .append(getSoldRate(), that.getSoldRate())
                .append(getSellTrend(), that.getSellTrend())
                .append(getReport(), that.getReport())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getGoodsId())
                .append(getGoodsName())
                .append(getSoldRate())
                .append(getSellTrend())
                .append(getReport())
                .toHashCode();
    }
//

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}

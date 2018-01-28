package com.qbao.recommend.business.goodProduct.rest.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.qbao.recommend.business.goodProduct.model.KPI;
import com.qbao.recommend.business.goodProduct.model.Label;

/**
 * @author wangping
 * @createTime 上午11:02
 * $$LastChangedDate: 2016-11-14 14:19:26 +0800 (Mon, 14 Nov 2016) $$
 * $$LastChangedRevision: 1386 $$
 * $$LastChangedBy: jiahongping $$
 */
public class KpiDTO implements Serializable {
    private static final long serialVersionUID = "$Id: KpiDTO.java 1386 2016-11-14 06:19:26Z jiahongping $".hashCode();
    private Long goodsId;
    private String goodsName;
    private String goodsPic;
    private String goodsSource;
    private String updateTime;
    private String supportUrl; //  点赞URL（保留字段,可设为空）
    private int supportTimes; // 被点赞数
    private String collectUrl; //收藏URL
    private int collectTimes; //被收藏数
    private String buyUrl; // 购买URL
    private String shareUrl; // 分享URL(保留字段，可设为空）
    private String repeatBuyRate; //复购率
    private String receiveTime; //收货天数
    private long completeCount; // 订单完成数
    private Double totalScore; // 商品总分
    private List<Label> labels;
    private List<KPI> goodsKpi;

    public Long getGoodsId() {
        return goodsId;
    }

    public KpiDTO setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public KpiDTO setGoodsName(String goodsName) {
        this.goodsName = goodsName;
        return this;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public KpiDTO setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
        return this;
    }

    public String getGoodsSource() {
        return goodsSource;
    }

    public KpiDTO setGoodsSource(String goodsSource) {
        this.goodsSource = goodsSource;
        return this;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public KpiDTO setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getSupportUrl() {
        return supportUrl;
    }

    public KpiDTO setSupportUrl(String supportUrl) {
        this.supportUrl = supportUrl;
        return this;
    }

    public int getSupportTimes() {
        return supportTimes;
    }

    public KpiDTO setSupportTimes(int supportTimes) {
        this.supportTimes = supportTimes;
        return this;
    }

    public String getCollectUrl() {
        return collectUrl;
    }

    public KpiDTO setCollectUrl(String collectUrl) {
        this.collectUrl = collectUrl;
        return this;
    }

    public int getCollectTimes() {
        return collectTimes;
    }

    public KpiDTO setCollectTimes(int collectTimes) {
        this.collectTimes = collectTimes;
        return this;
    }

    public String getBuyUrl() {
        return buyUrl;
    }

    public KpiDTO setBuyUrl(String buyUrl) {
        this.buyUrl = buyUrl;
        return this;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public KpiDTO setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
        return this;
    }

    public String getRepeatBuyRate() {
        return repeatBuyRate;
    }

    public KpiDTO setRepeatBuyRate(String repeatBuyRate) {
        this.repeatBuyRate = repeatBuyRate;
        return this;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public KpiDTO setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
        return this;
    }

    public long getCompleteCount() {
        return completeCount;
    }

    public KpiDTO setCompleteCount(long completeCount) {
        this.completeCount = completeCount;
        return this;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public KpiDTO setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
        return this;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public KpiDTO setLabels(List<Label> labels) {
        this.labels = labels;
        return this;
    }

    public List<KPI> getGoodsKpi() {
        return goodsKpi;
    }

    public KpiDTO setGoodsKpi(List<KPI> goodsKpi) {
        this.goodsKpi = goodsKpi;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof KpiDTO))
            return false;

        KpiDTO kpiDTO = (KpiDTO) o;

        return new EqualsBuilder()
                .append(getSupportTimes(), kpiDTO.getSupportTimes())
                .append(getCollectTimes(), kpiDTO.getCollectTimes())
                .append(getCompleteCount(), kpiDTO.getCompleteCount())
                .append(getGoodsId(), kpiDTO.getGoodsId())
                .append(getGoodsName(), kpiDTO.getGoodsName())
                .append(getGoodsPic(), kpiDTO.getGoodsPic())
                .append(getGoodsSource(), kpiDTO.getGoodsSource())
                .append(getUpdateTime(), kpiDTO.getUpdateTime())
                .append(getSupportUrl(), kpiDTO.getSupportUrl())
                .append(getCollectUrl(), kpiDTO.getCollectUrl())
                .append(getBuyUrl(), kpiDTO.getBuyUrl())
                .append(getShareUrl(), kpiDTO.getShareUrl())
                .append(getRepeatBuyRate(), kpiDTO.getRepeatBuyRate())
                .append(getReceiveTime(), kpiDTO.getReceiveTime())
                .append(getTotalScore(), kpiDTO.getTotalScore())
                .append(getLabels(), kpiDTO.getLabels())
                .append(getGoodsKpi(), kpiDTO.getGoodsKpi())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getGoodsId())
                .append(getGoodsName())
                .append(getGoodsPic())
                .append(getGoodsSource())
                .append(getUpdateTime())
                .append(getSupportUrl())
                .append(getSupportTimes())
                .append(getCollectUrl())
                .append(getCollectTimes())
                .append(getBuyUrl())
                .append(getShareUrl())
                .append(getRepeatBuyRate())
                .append(getReceiveTime())
                .append(getCompleteCount())
                .append(getTotalScore())
                .append(getLabels())
                .append(getGoodsKpi())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("goodsId", goodsId)
                .append("goodsName", goodsName)
                .append("goodsPic", goodsPic)
                .append("goodsSource", goodsSource)
                .append("updateTime", updateTime)
                .append("supportUrl", supportUrl)
                .append("supportTimes", supportTimes)
                .append("collectUrl", collectUrl)
                .append("collectTimes", collectTimes)
                .append("buyUrl", buyUrl)
                .append("shareUrl", shareUrl)
                .append("repeatBuyRate", repeatBuyRate)
                .append("receiveTime", receiveTime)
                .append("completeCount", completeCount)
                .append("totalScore", totalScore)
                .append("labels", labels)
                .append("goodsKpi", goodsKpi)
                .toString();
    }
}



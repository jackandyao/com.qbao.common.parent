package com.qbao.recommend.business.shop.cmp.model.goodshop;


import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ScoreItems {

    @SerializedName("merchant_deal_score")
    @Expose
    private Double merchantDealScore;
    @SerializedName("merchant_judgment_score")
    @Expose
    private Double merchantJudgmentScore;
    @SerializedName("merchant_quality_score")
    @Expose
    private Double merchantQualityScore;
    @SerializedName("merchant_self_score")
    @Expose
    private Double merchantSelfScore;
    @SerializedName("total_amount_score")
    @Expose
    private Double totalAmountScore;

    /**
     * 
     * @return
     *     The merchantDealScore
     */
    public Double getMerchantDealScore() {
        return merchantDealScore;
    }

    /**
     * 
     * @param merchantDealScore
     *     The merchant_deal_score
     */
    public void setMerchantDealScore(Double merchantDealScore) {
        this.merchantDealScore = merchantDealScore;
    }

    /**
     * 
     * @return
     *     The merchantJudgmentScore
     */
    public Double getMerchantJudgmentScore() {
        return merchantJudgmentScore;
    }

    /**
     * 
     * @param merchantJudgmentScore
     *     The merchant_judgment_score
     */
    public void setMerchantJudgmentScore(Double merchantJudgmentScore) {
        this.merchantJudgmentScore = merchantJudgmentScore;
    }

    /**
     * 
     * @return
     *     The merchantQualityScore
     */
    public Double getMerchantQualityScore() {
        return merchantQualityScore;
    }

    /**
     * 
     * @param merchantQualityScore
     *     The merchant_quality_score
     */
    public void setMerchantQualityScore(Double merchantQualityScore) {
        this.merchantQualityScore = merchantQualityScore;
    }

    /**
     * 
     * @return
     *     The merchantSelfScore
     */
    public Double getMerchantSelfScore() {
        return merchantSelfScore;
    }

    /**
     * 
     * @param merchantSelfScore
     *     The merchant_self_score
     */
    public void setMerchantSelfScore(Double merchantSelfScore) {
        this.merchantSelfScore = merchantSelfScore;
    }

    /**
     * 
     * @return
     *     The totalAmountScore
     */
    public Double getTotalAmountScore() {
        return totalAmountScore;
    }

    /**
     * 
     * @param totalAmountScore
     *     The total_amount_score
     */
    public void setTotalAmountScore(Double totalAmountScore) {
        this.totalAmountScore = totalAmountScore;
    }

}

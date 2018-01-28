package com.qbao.recommend.business.shop.cmp.model.goodshop;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Good {

    @SerializedName("audit_status")
    @Expose
    private Integer auditStatus;
    @SerializedName("favortie_count")
    @Expose
    private Integer favortieCount;
    @SerializedName("goods_id")
    @Expose
    private String goodsId;
    @SerializedName("off_time")
    @Expose
    private String offTime;
    @SerializedName("on_time")
    @Expose
    private String onTime;
    @SerializedName("publish_status")
    @Expose
    private Integer publishStatus;
    @SerializedName("sale_count")
    @Expose
    private Integer saleCount;
    @SerializedName("spu_name")
    @Expose
    private String spuName;
    @SerializedName("thumbs_up_count")
    @Expose
    private Integer thumbsUpCount;
    @SerializedName("view_price")
    @Expose
    private Integer viewPrice;
    
    public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	private String imgUrl;
    

    /**
     * 
     * @return
     *     The auditStatus
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * 
     * @param auditStatus
     *     The audit_status
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 
     * @return
     *     The favortieCount
     */
    public Integer getFavortieCount() {
        return favortieCount;
    }

    /**
     * 
     * @param favortieCount
     *     The favortie_count
     */
    public void setFavortieCount(Integer favortieCount) {
        this.favortieCount = favortieCount;
    }

    /**
     * 
     * @return
     *     The goodsId
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * 
     * @param goodsId
     *     The goods_id
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 
     * @return
     *     The offTime
     */
    public String getOffTime() {
        return offTime;
    }

    /**
     * 
     * @param offTime
     *     The off_time
     */
    public void setOffTime(String offTime) {
        this.offTime = offTime;
    }

    /**
     * 
     * @return
     *     The onTime
     */
    public String getOnTime() {
        return onTime;
    }

    /**
     * 
     * @param onTime
     *     The on_time
     */
    public void setOnTime(String onTime) {
        this.onTime = onTime;
    }

    /**
     * 
     * @return
     *     The publishStatus
     */
    public Integer getPublishStatus() {
        return publishStatus;
    }

    /**
     * 
     * @param publishStatus
     *     The publish_status
     */
    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    /**
     * 
     * @return
     *     The saleCount
     */
    public Integer getSaleCount() {
        return saleCount;
    }

    /**
     * 
     * @param saleCount
     *     The sale_count
     */
    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    /**
     * 
     * @return
     *     The spuName
     */
    public String getSpuName() {
        return spuName;
    }

    /**
     * 
     * @param spuName
     *     The spu_name
     */
    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    /**
     * 
     * @return
     *     The thumbsUpCount
     */
    public Integer getThumbsUpCount() {
        return thumbsUpCount;
    }

    /**
     * 
     * @param thumbsUpCount
     *     The thumbs_up_count
     */
    public void setThumbsUpCount(Integer thumbsUpCount) {
        this.thumbsUpCount = thumbsUpCount;
    }

    /**
     * 
     * @return
     *     The viewPrice
     */
    public Integer getViewPrice() {
        return viewPrice;
    }

    /**
     * 
     * @param viewPrice
     *     The view_price
     */
    public void setViewPrice(Integer viewPrice) {
        this.viewPrice = viewPrice;
    }

}

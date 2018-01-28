package com.qbao.recommend.business.baogou.rest.dto;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * @author wangping
 * @createTime 下午2:49
 * $$LastChangedDate: 2016-11-15 18:34:23 +0800 (Tue, 15 Nov 2016) $$
 * $$LastChangedRevision: 1398 $$
 * $$LastChangedBy: wangping $$
 */
public class TopViewSpuDto implements Serializable {

    private static final long serialVersionUID = "$Id: TopViewSpuDto.java 1398 2016-11-15 10:34:23Z wangping $".hashCode();
    private Long spuId; //商品ID
    private String spuName;//商品名称
    private Long spuPrice; //商品单价
    private long spuSellnumber; //商品已售数
    private String spuImg; //商品图片
    private long spuStock; //商品库存
    private int isBaogou; //是否是宝购商品，1是，0不是
    private Long baogouId; //宝购ID，若isBaogou值不为1，则值为null
    private int currentLv; //商家资质：0普通商家、1个人认证商家、2、企业商家、3个人假一罚十商家、4金牌商家

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public Long getSpuPrice() {
        return spuPrice;
    }

    public void setSpuPrice(Long spuPrice) {
        this.spuPrice = spuPrice;
    }

    public long getSpuSellnumber() {
        return spuSellnumber;
    }

    public void setSpuSellnumber(long spuSellnumber) {
        this.spuSellnumber = spuSellnumber;
    }

    public String getSpuImg() {
        return spuImg;
    }

    public void setSpuImg(String spuImg) {
        this.spuImg = spuImg;
    }

    public long getSpuStock() {
        return spuStock;
    }

    public void setSpuStock(long spuStock) {
        this.spuStock = spuStock;
    }

    public int getIsBaogou() {
        return isBaogou;
    }

    public void setIsBaogou(int isBaogou) {
        this.isBaogou = isBaogou;
    }

    public Long getBaogouId() {
        return baogouId;
    }

    public void setBaogouId(Long baogouId) {
        this.baogouId = baogouId;
    }

    public int getCurrentLv() {
        return currentLv;
    }

    public void setCurrentLv(int currentLv) {
        this.currentLv = currentLv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof TopViewSpuDto))
            return false;

        TopViewSpuDto that = (TopViewSpuDto) o;

        return new EqualsBuilder()
                .append(getSpuSellnumber(), that.getSpuSellnumber())
                .append(getSpuStock(), that.getSpuStock())
                .append(getIsBaogou(), that.getIsBaogou())
                .append(getCurrentLv(), that.getCurrentLv())
                .append(getSpuId(), that.getSpuId())
                .append(getSpuName(), that.getSpuName())
                .append(getSpuPrice(), that.getSpuPrice())
                .append(getSpuImg(), that.getSpuImg())
                .append(getBaogouId(), that.getBaogouId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getSpuId())
                .append(getSpuName())
                .append(getSpuPrice())
                .append(getSpuSellnumber())
                .append(getSpuImg())
                .append(getSpuStock())
                .append(getIsBaogou())
                .append(getBaogouId())
                .append(getCurrentLv())
                .toHashCode();
    }


}

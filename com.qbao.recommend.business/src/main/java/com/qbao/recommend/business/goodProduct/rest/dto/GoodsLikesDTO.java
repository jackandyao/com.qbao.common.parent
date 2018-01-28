package com.qbao.recommend.business.goodProduct.rest.dto;


import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author wangping
 * @createTime 下午1:48
 * $$LastChangedDate: 2016-11-14 14:19:26 +0800 (Mon, 14 Nov 2016) $$
 * $$LastChangedRevision: 1386 $$
 * $$LastChangedBy: jiahongping $$
 */
public class GoodsLikesDTO implements Serializable,Comparable<GoodsLikesDTO> {

    private static final long serialVersionUID = "$Id: GoodsLikesDTO.java 1386 2016-11-14 06:19:26Z jiahongping $".hashCode();

    private Long spuId;  //商品ID
    private String goodsName;//商品名称
    private Double goodKpi;//商品指数
    private String goodsPic;//商品图片
    private String goodsPicLink;//商品详情链接
    private boolean isHaohuo; //好货标识 true 好货, false 不是好货

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getGoodKpi() {
        return goodKpi;
    }

    public void setGoodKpi(Double goodKpi) {
        this.goodKpi = goodKpi;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    public String getGoodsPicLink() {
        return goodsPicLink;
    }

    public void setGoodsPicLink(String goodsPicLink) {
        this.goodsPicLink = goodsPicLink;
    }

    public boolean isHaohuo() {
        return isHaohuo;
    }

    public void setHaohuo(boolean haohuo) {
        isHaohuo = haohuo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof GoodsLikesDTO))
            return false;

        GoodsLikesDTO that = (GoodsLikesDTO) o;

        return new EqualsBuilder()
                .append(isHaohuo(), that.isHaohuo())
                .append(getSpuId(), that.getSpuId())
                .append(getGoodsName(), that.getGoodsName())
                .append(getGoodKpi(), that.getGoodKpi())
                .append(getGoodsPic(), that.getGoodsPic())
                .append(getGoodsPicLink(), that.getGoodsPicLink())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getSpuId())
                .append(getGoodsName())
                .append(getGoodKpi())
                .append(getGoodsPic())
                .append(getGoodsPicLink())
                .append(isHaohuo())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("spuId", spuId)
                .append("goodsName", goodsName)
                .append("goodKpi", goodKpi)
                .append("goodsPic", goodsPic)
                .append("goodsPicLink", goodsPicLink)
                .append("isHaohuo", isHaohuo)
                .toString();
    }

    @Override
    public int compareTo(GoodsLikesDTO other) {
        if(other != null && this.getGoodKpi() > other.getGoodKpi()){
            return  -1;
        }
        return 1;
    }
}

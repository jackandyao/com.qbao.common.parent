package com.qbao.recommend.business.product.rest.impl;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 必购好货DTO
 * 
 * @author yuandongrui
 * @date 2016年6月28日
 */
public class MustBuyDTO {
    private long id; // 商品id
    private String name; // 商品名称
    private long price; // 商品价格
    private int freeDelivery; // 是否包邮：0:不包 1:包 -1:不确定
    private long salesVolume; // 销量
    private int likes; // 点赞数
    private String imgUrl; // 商品图片url
    private String goodsUrl; // 商品url

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getFreeDelivery() {
        return freeDelivery;
    }

    public void setFreeDelivery(int freeDelivery) {
        this.freeDelivery = freeDelivery;
    }

    public long getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(long salesVolume) {
        this.salesVolume = salesVolume;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(name).append(price).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MustBuyDTO) == false) {
            return false;
        }
        MustBuyDTO rhs = ((MustBuyDTO) other);
        return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(price, rhs.price).append(imgUrl, rhs.imgUrl).isEquals();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MustBuyDTO [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
    
}

package com.qbao.recommend.business.goodProduct.rest.dto;

/**
 * Created by shuaizhihu on 2016/11/22.
 */
public class GoodGoodsDTO {
    private long goodsId;
    private String itemImage;
    private String itemUrl;
    private String  itemName;
    private Double goodNum;
    private long itemPresentPrice;
    private long itemOriginalPrice;
    private String channelName;
    private String channelImage;
    private long buyNum;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public Double getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Double goodNum) {
        this.goodNum = goodNum;
    }

    public long getItemPresentPrice() {
        return itemPresentPrice;
    }

    public void setItemPresentPrice(long itemPresentPrice) {
        this.itemPresentPrice = itemPresentPrice;
    }

    public long getItemOriginalPrice() {
        return itemOriginalPrice;
    }

    public void setItemOriginalPrice(long itemOriginalPrice) {
        this.itemOriginalPrice = itemOriginalPrice;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public long getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(long buyNum) {
        this.buyNum = buyNum;
    }

    public String getChannelImage() {
        return channelImage;
    }

    public void setChannelImage(String channelImage) {
        this.channelImage = channelImage;
    }
}

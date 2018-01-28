/**
 * 
 */
package com.qbao.recommend.respositoy.redis.model;

import java.io.Serializable;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
public class ItemDTO implements Serializable {
    private static final long serialVersionUID = "$Id: ItemDTO.java 896 2016-09-05 10:26:32Z jiahongping $".hashCode();
    // id：商品id
    private long id;
    // mainImg：商品主图
    private String mainImg;
    // viewPrice：价格
    private long viewPrice;
    // spuName：商品名称
    private String spuName;
    // shopName：店铺名称
    // private String shopName;
    // // salesNumAggregated：销量
    private long salesNumAggregated;
    // // spuThumb：点赞量
    // private long spuThumb;

    // hasLeiPai：是否雷拍
    // private int hasLeiPai;
    //// hasBaogou：是否宝购
    // private int hasBaogou;
    // currentLv：认证级别
    // private int currentLv;
    // // merchantType:商家类型
    // private int merchantType;

    public ItemDTO() {

    }

    /**
     * @param id
     * @param mainImg
     * @param viewPrice
     * @param spuName
     * @param salesNumAggregated
     */
    public ItemDTO(long id, String mainImg, long viewPrice, String spuName, long salesNumAggregated) {
        super();
        this.id = id;
        this.mainImg = mainImg;
        this.viewPrice = viewPrice;
        this.spuName = spuName;
        this.salesNumAggregated = salesNumAggregated;
    }


    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    public long getViewPrice() {
        return viewPrice;
    }

    public void setViewPrice(long viewPrice) {
        this.viewPrice = viewPrice;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public long getSalesNumAggregated() {
        return salesNumAggregated;
    }

    public void setSalesNumAggregated(long salesNumAggregated) {
        this.salesNumAggregated = salesNumAggregated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ItemDTO [id=" + id + ", mainImg=" + mainImg + ", viewPrice=" + viewPrice + ", spuName=" + spuName + ", salesNumAggregated=" + salesNumAggregated + "]";
    }

    // public int getHasLeiPai() {
    // return hasLeiPai;
    // }
    // public void setHasLeiPai(int hasLeiPai) {
    // this.hasLeiPai = hasLeiPai;
    // }
    // public int getHasBaogou() {
    // return hasBaogou;
    // }
    // public void setHasBaogou(int hasBaogou) {
    // this.hasBaogou = hasBaogou;
    // }
    // public int getCurrentLv() {
    // return currentLv;
    // }
    //
    // public void setCurrentLv(int currentLv) {
    // this.currentLv = currentLv;
    // }
    //
    // public int getMerchantType() {
    // return merchantType;
    // }
    //
    // public void setMerchantType(int merchantType) {
    // this.merchantType = merchantType;
    // }

}

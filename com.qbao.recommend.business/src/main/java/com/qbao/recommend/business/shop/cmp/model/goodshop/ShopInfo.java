package com.qbao.recommend.business.shop.cmp.model.goodshop;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ShopInfo {

    @SerializedName("shop_id")
    @Expose
    private String shopId;
    @SerializedName("shop_name")
    @Expose
    private String shopName;
    @SerializedName("shop_type")
    @Expose
    private String shopType;
    @SerializedName("seller_info")
    @Expose
    private SellerInfo sellerInfo;
    @SerializedName("score_items")
    @Expose
    private ScoreItems scoreItems;
    @SerializedName("logo_path")
    @Expose
    private String logoPath;
    @SerializedName("goods")
    @Expose
    private List<Good> goods = new ArrayList<Good>();
    @SerializedName("base_info")
    @Expose
    private BaseInfo baseInfo;
    @SerializedName("asset_info")
    @Expose
    private AssetInfo assetInfo;

    /**
     * 
     * @return
     *     The shopId
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * 
     * @param shopId
     *     The shop_id
     */
    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    /**
     * 
     * @return
     *     The shopName
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 
     * @param shopName
     *     The shop_name
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * 
     * @return
     *     The shopType
     */
    public String getShopType() {
        return shopType;
    }

    /**
     * 
     * @param shopType
     *     The shop_type
     */
    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    /**
     * 
     * @return
     *     The sellerInfo
     */
    public SellerInfo getSellerInfo() {
        return sellerInfo;
    }

    /**
     * 
     * @param sellerInfo
     *     The seller_info
     */
    public void setSellerInfo(SellerInfo sellerInfo) {
        this.sellerInfo = sellerInfo;
    }

    /**
     * 
     * @return
     *     The scoreItems
     */
    public ScoreItems getScoreItems() {
        return scoreItems;
    }

    /**
     * 
     * @param scoreItems
     *     The score_items
     */
    public void setScoreItems(ScoreItems scoreItems) {
        this.scoreItems = scoreItems;
    }

    /**
     * 
     * @return
     *     The logoPath
     */
    public String getLogoPath() {
        return logoPath;
    }

    /**
     * 
     * @param logoPath
     *     The logo_path
     */
    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    /**
     * 
     * @return
     *     The goods
     */
    public List<Good> getGoods() {
        return goods;
    }

    /**
     * 
     * @param goods
     *     The goods
     */
    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    /**
     * 
     * @return
     *     The baseInfo
     */
    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    /**
     * 
     * @param baseInfo
     *     The base_info
     */
    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    /**
     * 
     * @return
     *     The assetInfo
     */
    public AssetInfo getAssetInfo() {
        return assetInfo;
    }

    /**
     * 
     * @param assetInfo
     *     The asset_info
     */
    public void setAssetInfo(AssetInfo assetInfo) {
        this.assetInfo = assetInfo;
    }

}

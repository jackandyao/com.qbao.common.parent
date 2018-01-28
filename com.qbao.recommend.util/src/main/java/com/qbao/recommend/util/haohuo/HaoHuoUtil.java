package com.qbao.recommend.util.haohuo;

import java.text.SimpleDateFormat;

/**
 * @author yuandongrui
 * @date 2016年6月28日
 */
public class HaoHuoUtil {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取限时抢购中宝购商品详情页的url
     * 
     * @param productId
     * @return
     */
    public static String getBaoGouDetailUrl(String productId) {
        String url = HaoHuoConstant.BAOGOUDETAILURL + productId + "&protype=" + HaoHuoConstant.PROTYPE + "&acttype=" + HaoHuoConstant.ACTTYPE +
        			"&index=" + HaoHuoConstant.INDEX + "&channelid="+HaoHuoConstant.BAOGOU_CHANNELTYPE;
        return url;
    }

    /**
     * 获取必购好货中微商商品详情页
     * 
     * @param spuId
     * @return
     */
    public static String getWeiShangDetailUrl(String spuId) {
        String url = HaoHuoConstant.WEISHANGDETAILURL + spuId + "&channeType="+HaoHuoConstant.WEISHANG_CHANNELTYPE;
        return url;
    }

    /**
     * 获取好店推荐中店铺详情页面* @param shopUserId
     * 
     * @return
     */
    public static String getGoodShopDetailUrl(String shopUserId) {
        String url = HaoHuoConstant.GOODSHOPDETAILURL + HaoHuoConstant.INTERCEPTTYPE + "&shopUserId=" + shopUserId + "&channeType="+HaoHuoConstant.WEISHANG_CHANNELTYPE;
        return url;
    }

 

   
}

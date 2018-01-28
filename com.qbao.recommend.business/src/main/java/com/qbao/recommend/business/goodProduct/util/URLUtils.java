package com.qbao.recommend.business.goodProduct.util;

/**
 * @author wangping
 * @createTime 下午4:57
 * $$LastChangedDate: 2017-01-03 15:36:52 +0800 (Tue, 03 Jan 2017) $$
 * $$LastChangedRevision: 1541 $$
 * $$LastChangedBy: wangping $$
 */
public class URLUtils {
    /**
     *
     * @param spuId
     * @param channel
     * @return 前端自动识别http 还是https 协议
     */
    public static String generateDetailUrl(long spuId, int channel) {
        //https://detail.qbao.com/4617812.html?channel=53
       // return "http://m.qbao.com/wswap/productShare.htm?spuId=" + spuId + "&channel=" + channel+ "&sourceType=" + channel;
        return "//m.qbao.com/wswap/productShare.htm?spuId=" + spuId + "&channel=" + channel+ "&sourceType=" + channel;

    }

    public static String generateHaoHuolUrl(long spuId, int channel) {
        //https://detail.qbao.com/4617812.html?channel=53
       // return "http://banyanapi.qbao.com/release/h5App/goodsIndex/default/page.html?goodsId=" + spuId + "&channel=" + channel+ "&sourceType=" + channel;
        return "//banyanapi.qbao.com/release/h5App/goodsIndex/default/page.html?goodsId=" + spuId + "&channel=" + channel+ "&sourceType=" + channel;
    }
}

/**
 * 
 */
package com.qbao.recommend.util.TestInit;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.jboss.resteasy.util.Encode;

import com.qbao.recommend.util.http.HttpClientUtil;
import com.qbao.recommend.util.http.SendPhoneMessageUtil;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate$
 * $LastChangedRevision$
 * $LastChangedBy$
 */
public class MoniterMain {
    public static void main(String[] args){
       
        HashMap<String,Boolean>  sendFlag = new HashMap<String,Boolean>();
        //商品搜索url
//        http://172.16.14.39/search_v2/api/shop/search?kw=%E5%BA%97%E9%93%BA
      
//        http://172.16.14.39/search_v2/api/product/search?kw=%E5%8F%8C%E8%8A%82%E6%A3%8D
       
//        http://172.16.14.94/hotsale/api/hotsale?p=%7B%22current_page%22%3A1%2C%22device_type%22%3A%22wap%22%2C%22ip_adress%22%3A%2227.27.20.137%22%2C%22page_size%22%3A30%2C%22user_id%22%3A%220%22%2C%22visit_time%22%3A%222016-09-09+09%3A32%3A46%22%7D
//        http://172.16.14.94/search/api/assocaiton?p=%7B%22keyWord%22%3A%22%E5%81%A5%E8%BA%AB%22,%22current_page%22%3A1%2C%22device_type%22%3A%22wap%22%2C%22ip_adress%22%3A%2227.27.20.137%22%2C%22page_size%22%3A30%2C%22user_id%22%3A%220%22%2C%22visit_time%22%3A%222016-09-09+09%3A32%3A46%22%7D
        
//        http://172.16.14.94/lookagain/api/goods?p=%7B%22spu_id%22:45,%22user_id%22:32948801,%22current_page%22:2%7D
//        http://172.16.14.94/view/api/lookbuy?p=%7B%22spu_id%22:45,%22user_id%22:32948801,%22current_page%22:2%7D
       
          
//        http://172.16.14.94/guessforyou/api/recommendation?p=%7B%22spu_id%22%3A1%2C%22user_id%22%3A32948801%2C%22current_page%22%3A2%2C%22page_size%22%3A20%2C%22limit%22%3A10%7D
        
//        http://172.16.14.57/recommend/haoHuoRecommend/mustBuy     userId=94217116&single=1&pageSize=12&page=1
//        http://172.16.14.57/recommend/haoHuoRecommend/flashSale userId=94217116&single=1&pageSize=12&page=1
//        http://172.16.14.57/recommend/haoHuoRecommend/goodShop userId=94217116&single=1&pageSize=12&page=1
        
        sendFlag.put("search_product", false);
        sendFlag.put("search_shop", false);
        sendFlag.put("search_hotsale", false);
        sendFlag.put("search_assocaiton", false);
        sendFlag.put("lookagain", false);
        sendFlag.put("lookbuy", false);
        sendFlag.put("guessforyou", false);
        sendFlag.put("mustBuy", false);
        sendFlag.put("flashSale", false);
        sendFlag.put("goodShop", false);
    
      
        
        while(true){
            
            try{
                moniterUrl("http://172.16.14.39/search_v2/api/product/search?kw=%E5%8F%8C%E8%8A%82%E6%A3%8D","商品搜索",sendFlag,"search_product",true);
                moniterUrl("http://172.16.14.39/search_v2/api/shop/search?kw=%E5%BA%97%E9%93%BA","店铺搜索",sendFlag,"search_shop",true);
                moniterUrl("http://172.16.14.94/hotsale/api/hotsale?p=%7B%22current_page%22%3A1%2C%22device_type%22%3A%22wap%22%2C%22ip_adress%22%3A%2227.27.20.137%22%2C%22page_size%22%3A30%2C%22user_id%22%3A%220%22%2C%22visit_time%22%3A%222016-09-09+09%3A32%3A46%22%7D","搜索页_热卖推荐",sendFlag,"search_hotsale",true);
                moniterUrl("http://172.16.14.94/search/api/assocaiton?p=%7B%22keyWord%22%3A%22%E5%81%A5%E8%BA%AB%22,%22current_page%22%3A1%2C%22device_type%22%3A%22wap%22%2C%22ip_adress%22%3A%2227.27.20.137%22%2C%22page_size%22%3A30%2C%22user_id%22%3A%220%22%2C%22visit_time%22%3A%222016-09-09+09%3A32%3A46%22%7D","搜索页_猜你喜欢",sendFlag,"search_assocaiton",true);
                moniterUrl("http://172.16.14.94/lookagain/api/goods?p=%7B%22spu_id%22:45,%22user_id%22:32948801,%22current_page%22:2%7D","详情页_看了又看",sendFlag,"lookagain",true);
                moniterUrl("http://172.16.14.94/view/api/lookbuy?p=%7B%22spu_id%22:45,%22user_id%22:32948801,%22current_page%22:2%7D","详情页_看了还买",sendFlag,"lookbuy",true);
                moniterUrl("http://172.16.14.94/guessforyou/api/recommendation?p=%7B%22spu_id%22%3A1%2C%22user_id%22%3A32948801%2C%22current_page%22%3A2%2C%22page_size%22%3A20%2C%22limit%22%3A10%7D","首页 为你推荐",sendFlag,"guessforyou",true);
                moniterUrl("http://172.16.14.57/recommend/haoHuoRecommend/mustBuy?userId=94217116&single=1&pageSize=12&page=1","数据助手_好货推荐",sendFlag,"mustBuy",false);
                moniterUrl("http://172.16.14.57/recommend/haoHuoRecommend/flashSale?userId=94217116&single=1&pageSize=12&page=1","数据助手_限时抢购",sendFlag,"flashSale",false);
                moniterUrl("http://172.16.14.57/recommend/haoHuoRecommend/goodShop?userId=94217116&single=1&pageSize=12&page=1","数据助手_好店推荐",sendFlag,"goodShop",false);
            }catch(Exception e){
                
            }
            
            try {
                Thread.sleep(10*1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
          
    }
    
    public static void sendPhoneMessage(String message){
        try {
            message = URLEncoder.encode(message, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        SendPhoneMessageUtil.executeSendPhoneMessage("13524053917", message);
        SendPhoneMessageUtil.executeSendPhoneMessage("13816371924", message);
        SendPhoneMessageUtil.executeSendPhoneMessage("15821805909", message);
        SendPhoneMessageUtil.executeSendPhoneMessage("18602507935", message);
        
    }
    
    private static void  moniterUrl(String url,String name, HashMap<String,Boolean> sendFlag,String flagName,boolean isGet){
        SimpleDateFormat format  =new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HttpClientUtil  httpUtil = HttpClientUtil.getHttpClientInstance(); 
        try{
            
            String result ="";
            if(isGet){
                result= httpUtil.sendHttpGet(url);
            }else{
                result= httpUtil.sendHttpPost(url);
            }
            System.out.println(url);
//            System.out.println(result);
            if(sendFlag.get(flagName)){
                sendPhoneMessage( name+"恢复正常,你真棒！" +format.format(new Date()));
                sendFlag.put(flagName, false);
            }
        }catch(Exception e){
            if(!sendFlag.get(flagName)){
                sendPhoneMessage( name+"异常,请解决！"+format.format(new Date()));
                sendFlag.put(flagName, true);
            }
        }
    }
}

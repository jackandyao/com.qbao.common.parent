package com.qbao.recommend.alarm.phone.factory;

import com.qbao.recommend.alarm.phone.IPhoneAlaramMessageService;
import com.qbao.recommend.alarm.phone.impl.ErrorPhoneAlaramService;
import com.qbao.recommend.alarm.phone.impl.WarnPhoneAlaramService;
import com.qbao.recommend.alarm.util.MessageConstanUtil;

/**
 *  封装短消息的服务工厂
     * @author 贾红平
     * $LastChangedDate: 2016-09-20 15:59:27 +0800 (Tue, 20 Sep 2016) $
     * $LastChangedRevision: 1102 $
     * $LastChangedBy: jiahongping $
 */
public class PhoneAlaramServiceFactory {
    
    /**
     * 执行手机短消息发送
     * @param phoneNumber
     * @param message
     * @param type
     */
    public static void sendPhoneAlaramMessage(String type,String message){
        getIPhoneAlaramMessageService(type).sendPhoneAlaramMessage(message);
    }
    
    /**
     * 封装手机短消息实例
     * @param type
     * @return
     */
    private static IPhoneAlaramMessageService getIPhoneAlaramMessageService(String type){
        IPhoneAlaramMessageService phoneAlaramMessageService=null;
        switch (type) {
        case MessageConstanUtil.PHONE_WARN:
            phoneAlaramMessageService=new WarnPhoneAlaramService();
            break;
        case MessageConstanUtil.PHONE_ERROR:
            phoneAlaramMessageService=new ErrorPhoneAlaramService();
            break;
        default:
            break;
        }
        return phoneAlaramMessageService;
    }
}

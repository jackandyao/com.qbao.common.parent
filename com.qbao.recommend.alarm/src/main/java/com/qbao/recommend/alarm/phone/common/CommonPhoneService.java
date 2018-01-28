package com.qbao.recommend.alarm.phone.common;
import com.qbao.recommend.alarm.cmp.thread.facade.SendThreadFacade;
import com.qbao.recommend.alarm.util.MessageConstanUtil;
/**
 *   执行手机发送短消息
     * @author 贾红平
     * 共用发送方法
     * $LastChangedDate: 2016-09-22 10:15:29 +0800 (Thu, 22 Sep 2016) $
     * $LastChangedRevision: 1141 $
     * $LastChangedBy: jiahongping $
 */
public class CommonPhoneService {
    
    protected static String phones_list=MessageConstanUtil.PHONES_NUMBER;
    
    /**
     *  发送短消息
     * @param phone 手机号码
     * @param message 短信息
     */
    public void executeSendPhoneMessage(String phone, String message) {
        try {
            SendThreadFacade.execueteSendThreadByType(MessageConstanUtil.SEND_TYPE_PHONE, message, null, phone);
        } catch (Exception e) {
            
        }
     }
}

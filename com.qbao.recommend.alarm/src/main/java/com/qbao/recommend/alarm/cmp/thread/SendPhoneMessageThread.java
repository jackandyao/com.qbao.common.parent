package com.qbao.recommend.alarm.cmp.thread;

import com.qbao.recommend.util.http.SendPhoneMessageUtil;
/**
 *  异步发送手机短消息
     * @author 贾红平
     *
     * $LastChangedDate: 2016-09-22 10:15:29 +0800 (Thu, 22 Sep 2016) $
     * $LastChangedRevision: 1141 $
     * $LastChangedBy: jiahongping $
 */
public class SendPhoneMessageThread implements Runnable{
    
    /**
     * 发送手机号码
     */
    private String phone;
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 短消息内容
     */
    private String message;
    
    public SendPhoneMessageThread(String phone,String message) {
         this.phone=phone;
         this.message=message;
    }
    
    @Override
    public void run() {
        synchronized (SendPhoneMessageThread.class) {
            SendPhoneMessageUtil.executeSendPhoneMessage(phone, message);
        }
    }
    
}

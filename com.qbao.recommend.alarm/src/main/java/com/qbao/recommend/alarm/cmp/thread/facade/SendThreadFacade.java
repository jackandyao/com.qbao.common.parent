package com.qbao.recommend.alarm.cmp.thread.facade;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.qbao.recommend.alarm.cmp.thread.SendMailMessageThread;
import com.qbao.recommend.alarm.cmp.thread.SendPhoneMessageThread;
import com.qbao.recommend.alarm.util.MessageConstanUtil;

/**
 *   根据传递过来的不同的类型,通过启动不同的线程来发送信息
     * @author 贾红平
     *
     * $LastChangedDate: 2016-09-22 10:15:29 +0800 (Thu, 22 Sep 2016) $
     * $LastChangedRevision: 1141 $
     * $LastChangedBy: jiahongping $
 */
public class SendThreadFacade {
    
    /**
     * 封装具体的方法
     * @param type mail代表发送邮件信息,phone代表发送手机短消息
     * @param message 代表发送邮件的正文
     * @param subject 代表发送邮件的标题
     * @param phone   代表要发送手机短消息的号码
     * @param param
     */
    public static void execueteSendThreadByType(String type,String message,String subject,String phone){
         ExecutorService excutorService= Executors.newCachedThreadPool();
         if (type.equals(MessageConstanUtil.SEND_TYPE_MAIL)) {
            SendMailMessageThread mailThread=new SendMailMessageThread(subject, message);
            excutorService.execute(mailThread);
         }
         if (type.equals(MessageConstanUtil.SEND_TYPE_PHONE)) {
            SendPhoneMessageThread phoneThread=new SendPhoneMessageThread(phone, message);
            excutorService.execute(phoneThread);
         }
         excutorService.shutdown();
    }
}

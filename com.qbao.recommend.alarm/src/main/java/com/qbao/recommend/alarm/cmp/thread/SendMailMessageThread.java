package com.qbao.recommend.alarm.cmp.thread;

import com.qbao.recommend.alarm.cmp.factory.SendTextMailCmpFactory;
/**
 *  异步发送邮件
     * @author 贾红平
     *
     * $LastChangedDate: 2016-09-22 10:15:29 +0800 (Thu, 22 Sep 2016) $
     * $LastChangedRevision: 1141 $
     * $LastChangedBy: jiahongping $
 */
public class SendMailMessageThread implements Runnable{

    /**
     * 发送邮件标题
     */
    private String subject;
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    /**
     * 发送邮件正文
     */
    private String message;
    
    public SendMailMessageThread(String subject,String message) {
         this.subject=subject;
         this.message=message;
    }
    
    @Override
    public void run() {
        synchronized (SendMailMessageThread.class) {
            SendTextMailCmpFactory.sendMailSimpleTextMsg(subject, message);
            
        }
    }
    
}

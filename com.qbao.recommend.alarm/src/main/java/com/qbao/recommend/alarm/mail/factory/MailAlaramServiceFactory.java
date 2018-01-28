package com.qbao.recommend.alarm.mail.factory;

import com.qbao.recommend.alarm.mail.IMailAlarmMessageService;
import com.qbao.recommend.alarm.mail.impl.ErrorMailAlarmService;
import com.qbao.recommend.alarm.mail.impl.InfoMailAlarmService;
import com.qbao.recommend.alarm.mail.impl.WarnMailAlarmService;
import com.qbao.recommend.alarm.util.MessageConstanUtil;

/**
 *  封装发送邮件信息服务的工厂
     * @author 贾红平
     *
     * $LastChangedDate: 2016-09-21 08:45:37 +0800 (Wed, 21 Sep 2016) $
     * $LastChangedRevision: 1112 $
     * $LastChangedBy: jiahongping $
 */
public class MailAlaramServiceFactory {
    /**
     * 执行发送邮件操作
     * @param json
     * @param type
     * @param subject
     * @param message
     */
    public static void sendMailAlaramMessage(String type,String subject,String message){
        getAlarmMessageService(type).sendMailAlarmMessage(subject, message);
    }
    
    /**
     * 邮件发送服务实例
     * @param type
     * @return
     */
    private static IMailAlarmMessageService getAlarmMessageService(String type){
        IMailAlarmMessageService mailAlarmMessageService=null;
        switch (type) {
        case MessageConstanUtil.MAIL_INFO:
                mailAlarmMessageService=new InfoMailAlarmService();
            break;
        case MessageConstanUtil.MAIL_WARN:
            mailAlarmMessageService=new WarnMailAlarmService();
            break;
        case MessageConstanUtil.MAIL_ERROR:
            mailAlarmMessageService=new ErrorMailAlarmService();
            break;
        default:
            break;
        }
        return mailAlarmMessageService;
    }
}

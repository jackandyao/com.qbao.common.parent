package com.qbao.recommend.alarm.mail;

import com.qbao.recommend.alarm.IAlarmMessageService;

/**
 *   通过邮件形式发送告警,错误等级别形式通知
     * @author 贾红平
     * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
     * $LastChangedRevision: 896 $
     * $LastChangedBy: jiahongping $
 */
public interface IMailAlarmMessageService extends IAlarmMessageService{
    
    /**
     * 通过邮件发送消息
     * @param subject
     * @param message
     */
    public abstract void sendMailAlarmMessage(String subject,String message);
}

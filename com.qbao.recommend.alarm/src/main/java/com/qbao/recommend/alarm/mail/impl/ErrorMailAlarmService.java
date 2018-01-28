package com.qbao.recommend.alarm.mail.impl;

import org.apache.log4j.Logger;

import com.qbao.recommend.alarm.mail.IMailAlarmMessageService;
import com.qbao.recommend.alarm.mail.common.CommonMailService;
import com.qbao.recommend.alarm.util.MessageConstanUtil;

/**
 *   错误级别发送邮件
     * @author 贾红平
     * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
     * $LastChangedRevision: 896 $
     * $LastChangedBy: jiahongping $
 */
public class ErrorMailAlarmService extends CommonMailService implements IMailAlarmMessageService {

    Logger logger = Logger.getLogger(WarnMailAlarmService.class);
    
    @Override
    public void sendMailAlarmMessage(String subject, String message) {
        executeSendMailMessage(subject, message, logger, MessageConstanUtil.LOGGER_ERROR);
    }

}

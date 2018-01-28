package com.qbao.recommend.alarm.mail.common;

import org.apache.log4j.Logger;

import com.qbao.recommend.alarm.cmp.thread.facade.SendThreadFacade;
import com.qbao.recommend.alarm.util.MessageConstanUtil;

/**
 *   通过邮件发送不同级别消息
     * @author 贾红平
     * $LastChangedDate: 2016-09-22 10:15:29 +0800 (Thu, 22 Sep 2016) $
     * $LastChangedRevision: 1141 $
     * $LastChangedBy: jiahongping $
 */
public class CommonMailService {
    public void executeSendMailMessage(String subject, String message,Logger logger,String level) {    
        try {
            SendThreadFacade.execueteSendThreadByType(MessageConstanUtil.SEND_TYPE_MAIL, message, subject, null);
         } catch (Exception e) {
            logger.error(e);
        }
    }
    
    
}

/**
 * 
 */
package com.qbao.recommend.business.task.cmp.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.net.SMTPAppender;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-13 22:24:14 +0800 (Tue, 13 Sep 2016) $
 * $LastChangedRevision: 1016 $
 * $LastChangedBy: wangping $
 */
public class MailUtils {
    public static void sendInfo(String subject, String message) {
        Logger logger = LoggerManagerUtil.getLogger(LogNameEnum.task, Level.ERROR);

        SMTPAppender appender = new SMTPAppender();
        try {
            appender.setSMTPUsername("zhuangaijack");
            appender.setSMTPPassword("aa11ss33");
            appender.setTo("786648643@qq.com,342315465@qq.com,420709335@qq.com,122715341@qq.com");
            appender.setFrom("zhuangaijack@163.com");
            appender.setSMTPHost("smtp.163.com");
            appender.setLocationInfo(true);
            appender.setSubject(subject);
            appender.setLayout(new PatternLayout());
            appender.activateOptions();
            logger.addAppender(appender);
            logger.error(message.toString());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("调用LOG4J发送邮件失败", e);
        }

    }
}

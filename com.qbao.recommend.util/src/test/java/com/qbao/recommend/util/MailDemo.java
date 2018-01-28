package com.qbao.recommend.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.net.SMTPAppender;

import com.qbao.recommend.util.mail.SMTPAppendUtil;

public class MailDemo {
    public static void main(String[] args) {
 
      Logger logger = Logger.getLogger(SMTPAppendUtil.class);
 
      
      SMTPAppender appender =SMTPAppendUtil.getSmtpAppenderInstance();
      try {
          
          appender.setLocationInfo(true);
          appender.setLayout(new PatternLayout());
          appender.setSubject("索引依赖中间表数据抽取应用系统日志-11111");
          appender.activateOptions();
          logger.addAppender(appender);
          logger.warn("xxxxx");
      } catch (Exception e) {
          e.printStackTrace();
          logger.error("Printing ERROR Statements", e);
      }
  }
  
}

package com.qbao.recommend.util.mail;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.net.SMTPAppender;
/**
 *   定义日志发送邮件的实例工具类:这种工具类,一般生产环境中很少去改动它,所以可以直接写成常量,不必存储在数据库
     * @author 贾红平
     * $LastChangedDate: 2016-09-19 19:19:50 +0800 (Mon, 19 Sep 2016) $
     * $LastChangedRevision: 1077 $
     * $LastChangedBy: jiahongping $
 */
public class SMTPAppendUtil {
    
    /**
     * 发送用户名
     */
    //public static final String SEND_USER_NAME="brucelovegongfu@163.com";
    public static final String SEND_USER_NAME="jackaiyaoforever@126.com";
    /**
     * 发送密码
     */
    public static final String SEND_PASSWORD="aa11ss33";
    //public static final String SEND_PASSWORD="4295023";
    /**
     * 发送目的地
     */
    public static final String SEND_TO="786648643@qq.com,342315465@qq.com,420709335@qq.com,122715341@qq.com";
    
    /**
     * 发送方
     */
    //public static final String SEND_FROM="brucelovegongfu@163.com";
    public static final String SEND_FROM="jackaiyaoforever@126.com";
    /**
     * 发送协议
     */
    //public static final String SEND_SMTP="smtp.163.com";
    public static final String SEND_SMTP="smtp.126.com";
    
    private SMTPAppendUtil(){}
    
    private static SMTPAppender appender=null;
    
    /**
     * 获取smtpappend实例
     * @return
     */
    public static synchronized SMTPAppender getSmtpAppenderInstance(){
        if (appender==null) {
            appender=new SMTPAppender();
            appender.setSMTPUsername(SEND_USER_NAME);
            appender.setSMTPPassword(SEND_PASSWORD);
            appender.setTo(SEND_TO);
            appender.setFrom(SEND_FROM);
            appender.setSMTPHost(SEND_SMTP);
        }
        return appender;
    }
    
  
  
}

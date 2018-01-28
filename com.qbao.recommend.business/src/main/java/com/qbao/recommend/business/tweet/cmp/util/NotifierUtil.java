/**
 * 
 */
package com.qbao.recommend.business.tweet.cmp.util;

import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.alarm.facade.AlaramServiceFacotryFacade;
import com.qbao.recommend.alarm.util.MessageConstanUtil;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.net.SMTPAppender;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2017-01-19 21:23:42 +0800 (Thu, 19 Jan 2017) $
 * $LastChangedRevision: 1552 $
 * $LastChangedBy: wangping $
 */
public class NotifierUtil {

    public static Set<String> msgKeys = new HashSet<>();


    public static void notifyByEmail(Map<String, Object> param, Exception e) {
        JSONObject messageJson = getJsonObject(param, e, MessageConstanUtil.MAIL_ERROR);
        AlaramServiceFacotryFacade.sendAlaramMessageByMail(messageJson);
    }

    public static void notifyByEmail(Map<String, Object> param, String msg) {
        Exception e = new Exception(msg);
        JSONObject messageJson  = getJsonObject(param, e, MessageConstanUtil.MAIL_ERROR);
        AlaramServiceFacotryFacade.sendAlaramMessageByMail(messageJson);
    }

    public static void notifyByEmail(Map<String, Object> param, String msg, String alarmLevel) {
        Exception e = new Exception(msg);
        JSONObject  messageJson = getJsonObject(param, e, alarmLevel);
        AlaramServiceFacotryFacade.sendAlaramMessageByMail(messageJson);
    }

    public static void notifyByEmail(Map<String, Object> param, Exception e, String alarmLevel) {
        JSONObject messageJson = getJsonObject(param, e,alarmLevel);
        AlaramServiceFacotryFacade.sendAlaramMessageByMail(messageJson);
    }

    private static JSONObject getJsonObject(Map<String, Object> param, Exception e, String alarmLevel) {
        JSONObject messageJson = new JSONObject();
        messageJson.put(MessageConstanUtil.ALARM_CLASS_NAME, param.get(MessageConstanUtil.ALARM_CLASS_NAME));
        messageJson.put(MessageConstanUtil.ALARM_TYPE, alarmLevel);
        messageJson.put(MessageConstanUtil.ALARM_USERID, param.get(RecommendConstantUtil.USER_ID));
        messageJson.put(MessageConstanUtil.ALARM_EXCEPTION, e);
        return messageJson;
    }

    public static void notifyByPhone(String msg){
        String encodeMsg = StringUtils.EMPTY;
//        try {
//           // encodeMsg = URLEncoder.encode(msg,"utf-8");
//        } catch (UnsupportedEncodingException e) {
//            System.out.println(e.getMessage());
//        }
        //Void to send duplicate msg
        if(!msgKeys.contains(msg)){
            msgKeys.add(msg);
            AlaramServiceFacotryFacade.sendAlaramMessageByPhone(MessageConstanUtil.PHONE_ERROR, msg);
        }
    }

    public static void notifyByEmail(String subject, String message) {
        Logger logger = LoggerManagerUtil.getLogger(LogNameEnum.good_product, Level.ERROR);
        if(!msgKeys.contains(subject)) {
            msgKeys.add(subject);
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
                logger.error("调用LOG4J发送邮件失败", e);
            }
        }
    }
}

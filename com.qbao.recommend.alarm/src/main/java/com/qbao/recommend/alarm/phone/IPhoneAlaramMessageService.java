package com.qbao.recommend.alarm.phone;

import com.qbao.recommend.alarm.IAlarmMessageService;
/**
 *   通过手机短消息发送错误级别消息
     * @author 贾红平
     * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
     * $LastChangedRevision: 896 $
     * $LastChangedBy: jiahongping $
 */
public interface IPhoneAlaramMessageService extends IAlarmMessageService {
    public abstract void sendPhoneAlaramMessage(String message);
}

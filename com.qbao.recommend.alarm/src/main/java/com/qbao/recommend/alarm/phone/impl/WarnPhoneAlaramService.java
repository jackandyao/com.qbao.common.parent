package com.qbao.recommend.alarm.phone.impl;

import com.qbao.recommend.alarm.phone.IPhoneAlaramMessageService;
import com.qbao.recommend.alarm.phone.common.CommonPhoneService;
/**
 *   一些系统警告级别需要通过手机发短消息
     * @author 贾红平
     * warn
     * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
     * $LastChangedRevision: 896 $
     * $LastChangedBy: jiahongping $
 */
public class WarnPhoneAlaramService extends CommonPhoneService implements IPhoneAlaramMessageService {
    @Override
    public void sendPhoneAlaramMessage(String message) {
        String[] phones=phones_list.split(",");
        for(String number:phones){
            executeSendPhoneMessage(number, message);
        }
    }

}

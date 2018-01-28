package com.qbao.recommend.alarm.phone.impl;

import com.qbao.recommend.alarm.phone.IPhoneAlaramMessageService;
import com.qbao.recommend.alarm.phone.common.CommonPhoneService;
/**
 *  错误级别的手机短消息
     * @author 贾红平
     *
     * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
     * $LastChangedRevision: 896 $
     * $LastChangedBy: jiahongping $
 */
public class ErrorPhoneAlaramService extends CommonPhoneService implements IPhoneAlaramMessageService {
    @Override
    public void sendPhoneAlaramMessage(String message) {
        String[] phones=phones_list.split(",");
        for(String number:phones){
            executeSendPhoneMessage(number, message);
        }
    }

}

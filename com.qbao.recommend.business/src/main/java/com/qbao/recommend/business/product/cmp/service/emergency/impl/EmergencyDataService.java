package com.qbao.recommend.business.product.cmp.service.emergency.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qbao.recommend.alarm.facade.AlaramServiceFacotryFacade;
import com.qbao.recommend.alarm.util.MessageConstanUtil;
import com.qbao.recommend.business.product.cmp.common.CommonSpuService;
import com.qbao.recommend.business.product.cmp.handler.factory.SpuHandlerFactory;
import com.qbao.recommend.business.product.cmp.service.emergency.IEmergencyDataService;

/**
 *   使用急救数据
     * @author 贾红平
     * $LastChangedDate: 2016-09-22 18:30:21 +0800 (Thu, 22 Sep 2016) $
     * $LastChangedRevision: 1146 $
     * $LastChangedBy: wangping $
 */
@Service
public class EmergencyDataService extends CommonSpuService implements IEmergencyDataService {
    @Autowired
    private SpuHandlerFactory spuHandlerFactory;
    @Override
    public List<Long> getEmergencyDataList(List<Long>oldlist) { 
        if (oldlist==null||oldlist.size()==0) {
            initHotSpuList();
             servericeLogger.error("系统警告:目前由于使用正常接口服务计算数据获取到的结果为0,开始启用急救的默认数据");
             AlaramServiceFacotryFacade.sendAlaramMessageByPhone(MessageConstanUtil.PHONE_ERROR, "系统出现无数据,使用急救数据进行数据补充");
             oldlist=hotSpuList;
        }
        else{
            servericeLogger.info("系统警告:目前使用接口已经获取到正常数据");
        }
        return oldlist;
       
    }
    
}

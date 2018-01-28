package com.qbao.recommend.business.shop.cmp.service.emergency.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qbao.recommend.alarm.facade.AlaramServiceFacotryFacade;
import com.qbao.recommend.alarm.util.MessageConstanUtil;
import com.qbao.recommend.business.shop.cmp.common.CommonShopService;
import com.qbao.recommend.business.shop.cmp.handler.factory.ShopHandlerFactory;
import com.qbao.recommend.business.shop.cmp.service.emergency.IEmergencyDataService;

/**
 *   使用急救数据
     * @author 贾红平
     * $LastChangedDate: 2016-09-22 18:30:21 +0800 (星期四, 22 九月 2016) $
     * $LastChangedRevision: 1146 $
     * $LastChangedBy: wangping $
 */
@Service
public class EmergencyDataService extends CommonShopService implements IEmergencyDataService {
    @Autowired
    private ShopHandlerFactory shopHandlerFactory;
    @Override
    public List<String> getEmergencyDataList(List<String>oldlist) { 
        if (oldlist==null||oldlist.size()==0) {
            initHotShopList();
             servericeLogger.error("系统警告:目前由于使用正常接口服务计算数据获取到的结果为0,开始启用急救的默认数据");
             AlaramServiceFacotryFacade.sendAlaramMessageByPhone(MessageConstanUtil.PHONE_ERROR, "系统出现无数据,使用急救数据进行数据补充");
             oldlist=hotShopList;
        }
        else{
            servericeLogger.info("系统警告:目前使用接口已经获取到正常数据");
        }
        return oldlist;
       
    }
    
}

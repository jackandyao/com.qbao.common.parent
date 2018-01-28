package com.qbao.recommend.respositoy.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.qbao.recommend.respositoy.mysql.dao.LookAgainAndBuyDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.service.ILookAgainAndBuyService;

@Service
public class LookAgainAndBuyServiceImpl implements ILookAgainAndBuyService {

    @Value("${recommend.datasource.key}")
    private String DATASOURCE_KEY;

    @Value("${REC_LOOKAGAIN}")
    private String REC_LOOKAGAIN_TABLE_NAME;

    @Value("${REC_LOOKBUY}")
    private String REC_LOOKBUY_TABLE_NAME;

    @Autowired
    private LookAgainAndBuyDao lookAgainAndBuyDao;

    @Deprecated
    @Override
    public String findLookAgainBySpuIdAndType(long spuId, int type) {
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        return lookAgainAndBuyDao.findLookItemsByIdAndType(REC_LOOKAGAIN_TABLE_NAME, spuId, type);
    }

    @Deprecated
    @Override
    public String findLookBuyBySpuIdAndType(long spuId, int type) {
        MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
        return lookAgainAndBuyDao.findLookItemsByIdAndType(REC_LOOKBUY_TABLE_NAME, spuId, type);
    }


}

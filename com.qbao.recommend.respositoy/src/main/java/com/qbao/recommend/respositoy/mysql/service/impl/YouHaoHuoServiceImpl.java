/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.RecommendItemsDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.RecommendItems;
import com.qbao.recommend.respositoy.mysql.model.UserViewBuy;
import com.qbao.recommend.respositoy.mysql.service.IYouHaoHuoService;
import com.qbao.recommend.respositoy.redis.cache.annotation.CacheType;
import com.qbao.recommend.respositoy.redis.cache.annotation.RedisCache;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate: 2016-09-19 18:38:46 +0800 (Mon, 19 Sep 2016) $
 * $LastChangedRevision: 1071 $
 * $LastChangedBy: shuaizhihu $
 */
@Service
public class YouHaoHuoServiceImpl implements IYouHaoHuoService{
    
    @Value("${recommend.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${RECOMMEND_BG}")
    private String RECOMMEND_BG;
    
    @Value("${RECOMMEND_GWJS}")
    private String RECOMMEND_GWJS;
    
    @Value("${RECOMMEND_JXSC}")
    private String RECOMMEND_JXSC;
    
    @Autowired
    RecommendItemsDao recommendItemsDao;

    /* (non-Javadoc)
     * @see com.qbao.dc.mysql.service.IDataService#findById(long)
     */
    @Override
    @RedisCache(expire = 60 * 60, clazz = RecommendItems.class, cacheType = CacheType.OBJECT)
    public RecommendItems findById(long id) {
    	MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
    	RecommendItems bg = recommendItemsDao.findById(RECOMMEND_BG, id);
    	if(bg == null) bg = recommendItemsDao.findById(RECOMMEND_BG, 0);
    	RecommendItems gwjs = recommendItemsDao.findById(RECOMMEND_GWJS, id);
    	if(gwjs == null) gwjs = recommendItemsDao.findById(RECOMMEND_GWJS, 0);
//    	RecommendItems jxsc = recommendItemsDao.findById(RECOMMEND_JXSC, id);
//    	if(jxsc == null) jxsc = recommendItemsDao.findById(RECOMMEND_JXSC, 0);
    	String bgItems = bg==null?"":bg.getSpuIds();
    	String gwjsItems = gwjs==null?"":gwjs.getSpuIds();
//    	String jxscItems = jxsc==null?"":jxsc.getSpuIds();
    	if(!StringUtils.isEmpty(bgItems)) bgItems = bgItems.replaceAll("[{|}|\"]*", "");
    	if(!StringUtils.isEmpty(gwjsItems)) gwjsItems = gwjsItems.replaceAll("[{|}|\"]*", "");
//    	if(!StringUtils.isEmpty(jxscItems)) jxscItems = jxscItems.replaceAll("[{|}|\"]*", "");
    	return new RecommendItems(id,bgItems+"|"+gwjsItems);
    	
    }


}

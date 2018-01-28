/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.recommend.respositoy.mysql.dao.QbikeDao;
import com.qbao.recommend.respositoy.mysql.database.MultipleDataSource;
import com.qbao.recommend.respositoy.mysql.model.QbikeCluster;
import com.qbao.recommend.respositoy.mysql.model.QbikeClusterCenter;
import com.qbao.recommend.respositoy.mysql.model.QbikeClusterRegion;
import com.qbao.recommend.respositoy.mysql.model.QbikeFlow;
import com.qbao.recommend.respositoy.mysql.service.IQbikeService;

/**
 * @author sjzhangjun
 *
 * $LastChangedDate: 2016-09-19 18:38:46 +0800 (星期一, 19 九月 2016) $
 * $LastChangedRevision: 1071 $
 * $LastChangedBy:  $
 */
@Service
public class QbikeServiceImpl implements IQbikeService{
    
    @Value("${recommend.datasource.key}")
    private String DATASOURCE_KEY;
    
    @Value("${QBIKE_CLUSTER}")
    private String QBIKE_CLUSTER;
    @Value("${QBIKE_CLUSTER_CENTER}")
    private String QBIKE_CLUSTER_CENTER;
    @Value("${QBIKE_CLUSTER_REGION}")
    private String QBIKE_CLUSTER_REGION;
    @Value("${QBIKE_USER_CLUSTER}")
    private String QBIKE_USER_CLUSTER;
    @Value("${QBIKE_USER_CLUSTER_CENTER}")
    private String QBIKE_USER_CLUSTER_CENTER;
    @Value("${QBIKE_USER_CLUSTER_REGION}")
    private String QBIKE_USER_CLUSTER_REGION;
    @Value("${QBIKE_FLOW}")
    private String QBIKE_FLOW;
    
    @Autowired
    QbikeDao qbikeDao;

	@Override
//	@RedisCache(expire = 60 * 5, clazz = QbikeCluster.class, cacheType = CacheType.LIST)
	public List<QbikeCluster> findQbikeCluster() {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return qbikeDao.findQbikeCluster(QBIKE_CLUSTER);
	}

	@Override
//	@RedisCache(expire = 60 * 5, clazz = QbikeCluster.class, cacheType = CacheType.LIST)
	public List<QbikeClusterCenter> findQbikeClusterCenter() {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return qbikeDao.findQbikeClusterCenter(QBIKE_CLUSTER_CENTER);
	}

	@Override
//	@RedisCache(expire = 60 * 5, clazz = QbikeCluster.class, cacheType = CacheType.LIST)
	public List<QbikeClusterRegion> findQbikeClusterRegion() {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return qbikeDao.findQbikeClusterRegion(QBIKE_CLUSTER_REGION);
	}

	@Override
//	@RedisCache(expire = 60 * 5, clazz = QbikeCluster.class, cacheType = CacheType.LIST)
	public List<QbikeCluster> findQbikeUserCluster() {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return qbikeDao.findQbikeUserCluster(QBIKE_USER_CLUSTER);
	}

	@Override
//	@RedisCache(expire = 60 * 5, clazz = QbikeCluster.class, cacheType = CacheType.LIST)
	public List<QbikeClusterCenter> findQbikeUserClusterCenter() {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return qbikeDao.findQbikeUserClusterCenter(QBIKE_USER_CLUSTER_CENTER);
	}

	@Override
//	@RedisCache(expire = 60 * 5, clazz = QbikeCluster.class, cacheType = CacheType.LIST)
	public List<QbikeClusterRegion> findQbikeUserClusterRegion() {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return qbikeDao.findQbikeUserClusterRegion(QBIKE_USER_CLUSTER_REGION);
	}

	@Override
//	@RedisCache(expire = 60 * 5, clazz = QbikeCluster.class, cacheType = CacheType.LIST)
	public List<QbikeFlow> findQbikeFlow() {
		MultipleDataSource.setDataSourceKey(DATASOURCE_KEY);
		return qbikeDao.findQbikeFlow(QBIKE_FLOW);
	}

}

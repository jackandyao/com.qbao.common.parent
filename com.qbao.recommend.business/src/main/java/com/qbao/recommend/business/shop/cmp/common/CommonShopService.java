package com.qbao.recommend.business.shop.cmp.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qbao.recommend.business.product.cmp.util.RecommendConstantUtil;
import com.qbao.recommend.respositoy.mysql.model.SpuInfoMerchant;
import com.qbao.recommend.respositoy.mysql.service.IMerMiddleDataService;
import com.qbao.recommend.respositoy.mysql.service.IMerSpuService;
import com.qbao.recommend.respositoy.mysql.service.IRecommendShopService;
import com.qbao.recommend.respositoy.redis.IRedisService;
import com.qbao.recommend.respositoy.redis.common.RedisModel;
import com.qbao.recommend.respositoy.redis.factory.RedisModelFactory;
import com.qbao.recommend.respositoy.redis.model.ItemDTO;
import com.qbao.recommend.respositoy.redis.model.goods.mer.MerProductStatus;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.http.HttpClientUtil;
import com.qbao.recommend.util.log.LoggerManagerUtil;

/**
 * Created by THink on 2016/7/8. 贾红平 产品抽象类 保存所有子类实例可能会用到的共有方法
 */
@Component

public  class CommonShopService extends AbstractRecommedService {
    
    Logger shopServiceLogger = LoggerManagerUtil.getLogger(LogNameEnum.shop_facade, Level.WARN);
    
    @Value("${rec_sim_url}")
    private String rec_sim_url;
    @Value("${rec_dir_url}")
    private String rec_dir_url;
    @Value("${rec_kw_dir_url}")
    private String rec_kw_dir_url;
    @Value("${rec_kw_hot_url}")
    private String rec_kw_hot_url;
    
    private static boolean isInit = true;
    
    public static Map<String,Integer> tagKeyDirMap = new HashMap<String,Integer>();
    
    @Autowired
    private IRecommendShopService recommendShopService;
    
    protected List<String>hotShopList; 
  
    
    @Autowired
    private IRedisService iRedisService;

	private Gson gson = new GsonBuilder().serializeNulls().create();

    
    /**
     * 根据kw获取热门数据
     * @param kw
     * @param limit
     * @return
     */
    protected List<String> getHotKw(String kw,int limit){
     // 调用SOLR查询接口 -kw-{kw}
        List<String> result = new ArrayList<String> ();
        String filter = "{\"-view_price\":\"[0 TO 1500]\"}";
        try {
            filter =  URLEncoder.encode(filter, "UTF-8");
            if(!StringUtils.isEmpty(kw)){
                kw = URLEncoder.encode(kw, "UTF-8");
            }else{
                kw="";
            }
        } catch (UnsupportedEncodingException e) {
        }
        String params = "?kw="+kw+"&filter="+filter+"&size="+limit;
        String url =  rec_kw_hot_url+params;
        HttpClientUtil util = HttpClientUtil.getHttpClientInstance();
        String json = util.sendHttpGet(url);
        if(json !=null){
            JSONObject jobject = JSON.parseObject(json);
            JSONObject dataobject = jobject.getJSONObject("data");
            JSONArray dataList = dataobject.getJSONArray("dataList");
            for(Object d:dataList){
                result.add(d.toString());
            } 
        }
        return result;
    }
    
    
    protected Map<String,List<String>> getDirKw(String kw,int limit){
        String filter = "{\"-view_price\":\"[0 TO 3000]\",\"-trade_num\":\"0\"}" ;
        try {
            filter =  URLEncoder.encode(filter, "UTF-8");
        } catch (UnsupportedEncodingException e) {
           
        }
        String params = "?kw="+kw+"&size="+limit+"&filter="+filter;
        String url =  rec_kw_dir_url+params;
        HttpClientUtil util = HttpClientUtil.getHttpClientInstance();
        String json = util.sendHttpGet(url);
        JSONObject object =JSONObject.parseObject(json);
        if("ok".equalsIgnoreCase(object.getString("errorMsg")) || 0 == object.getIntValue("errorCode")){
            
            JSONObject data = object.getJSONObject("data");
            JSONObject dirProductMap = data.getJSONObject("dirProductMap");
            Map<String,List<String>> dirProMap =  (Map<String,List<String>>)JSON.parse(dirProductMap.toJSONString());
            return dirProMap;
        }else{
            return new HashMap<String,List<String>>();
        }
    }
    
    

	

	@Autowired
	private IMerSpuService merSpuService;

	@Autowired
	private IMerMiddleDataService merMiddleDataService;

	private static Random random = new Random();

	/**
	 * 验证产品是否下架
	 * 
	 * @param spuId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected boolean isOnSale(long spuId) {
		boolean result = false;
		RedisModel<MerProductStatus> queryModel = (RedisModel<MerProductStatus>) RedisModelFactory
				.getQueryModel(String.valueOf(spuId), MerProductStatus.class);
		RedisModel<MerProductStatus> targetModel = (RedisModel<MerProductStatus>) iRedisService.find(queryModel);
		if (null == targetModel || null == targetModel.getValue()) { // 缓存失效或者没有缓存
			SpuInfoMerchant merSpu = merSpuService.findBySpuId(spuId);
			if (null != merSpu) {// 缓存到redis
				ItemDTO itemDTO = new ItemDTO(merSpu.getSpuId(), merSpu.getMainImg(), merSpu.getViewPrice(),
						merSpu.getSpuName(), merSpu.getSellCountAggregated());
				MerProductStatus merProduct = new MerProductStatus(merSpu.getSpuId(), itemDTO);
				RedisModel<?> model = RedisModelFactory.getRedisModel(String.valueOf(spuId), merProduct);
				iRedisService.save(model, RecommendConstantUtil.REDIS_EXPIRE_TIME);
				result = true;
			}
		} else {// redis 存在 spuId
			result = true;
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@Cacheable(value = "twoMinCache", key = "#spuId")
	public ItemDTO fetchResponseDto(long spuId) {
		ItemDTO result = null;
		RedisModel<MerProductStatus> queryModel = (RedisModel<MerProductStatus>) RedisModelFactory
				.getQueryModel(String.valueOf(spuId), MerProductStatus.class);
		RedisModel<MerProductStatus> targetModel = (RedisModel<MerProductStatus>) iRedisService.find(queryModel);
		if (null == targetModel || null == targetModel.getValue()) { // 缓存失效或者没有缓存
			SpuInfoMerchant merSpu = merSpuService.findBySpuId(spuId);
			if (null != merSpu) {// 缓存到redis
				result = new ItemDTO(merSpu.getSpuId(), merSpu.getMainImg(), merSpu.getViewPrice(), merSpu.getSpuName(),
						merSpu.getSellCountAggregated());
				MerProductStatus merProduct = new MerProductStatus(merSpu.getSpuId(), result);
				RedisModel<?> model = RedisModelFactory.getRedisModel(String.valueOf(spuId), merProduct);
				iRedisService.save(model, RecommendConstantUtil.REDIS_EXPIRE_TIME);
			}
		} else {// redis 存在 spuId
			result = targetModel.getValue().getDto();
		}
		return result;
	}

	public String fetchResponseDtoJson(long spuId) {
		ItemDTO itemDTO = fetchResponseDto(spuId);
		return gson.toJson(itemDTO);
	}

	/**
	 * 返回热卖数据
	 * 
	 * @return
	 */
	protected void initHotShopList() {
		hotShopList = recommendShopService.findByUserId(0).getShopList();
	}

	/**
	 * 根据一个产品获取对应的相似产品
	 * 
	 * @param spuId
	 * @return
	 */
	protected List<String> getExtraSpuList(long spuId, String operation, int limit) {
		// 1 调用redis api 获取结果集
		List<String> list = Lists.newArrayList();
		// 取相似产品
		if (operation.equals(RecommendConstantUtil.IS_SIMILAR)) {
			list = getSimilarSpu(spuId, limit);
		}
		// 取目录关联产品
		else {
			Map<String, List<String>> listMap = getAssocationSpu(spuId, limit);
			for (String key : listMap.keySet()) {
				List<String> subList = listMap.get(key);
				if(!CollectionUtils.isEmpty(subList)){
					list.add(subList.get(random.nextInt(subList.size())));
				}
			}
		}

		return list;

	}


	/**
	 * 根据一个产品ID获取对应的相似产品集合
	 * 
	 * @return
	 */
	private List<String> getSimilarSpu(long spuId, int limit) {
		// 调用SOLR查询接口 -spuId-{spuId}
		List<String> result = new ArrayList<String>();
		String filter = "{\"-view_price\":\"[0 TO 3000]\"}";
		try {
			filter = URLEncoder.encode(filter, "UTF-8");
		} catch (UnsupportedEncodingException e) {

		}
		String params = "?spu_id=" + spuId + "&filter=" + filter + "&user_id=0&size=" + limit;
		String url = rec_sim_url + params;
		HttpClientUtil util = HttpClientUtil.getHttpClientInstance();
		String json = util.sendHttpGet(url);
		if (json != null) {
			JSONObject jobject = JSON.parseObject(json);
			JSONObject dataobject = jobject.getJSONObject("data");
			JSONArray dataList = dataobject.getJSONArray("dataList");
			for (Object d : dataList) {
				result.add(d.toString());
			}

		}
		return result;
	}

	/**
	 * 根据一个产品ID获取一个类目产品集合
	 * 
	 * @param spuId
	 * @return
	 */
	private Map<String, List<String>> getAssocationSpu(long spuId, int limit) {
		// 调用SOLR查询接口 -spuId-directoryId-{spuId}
		int lev = (tagKeyDirMap.get(spuId) == null ? 3 : tagKeyDirMap.get(spuId));
		String filter = "{\"-view_price\":\"[0 TO 3000]\",\"-trade_num\":\"0\"}";
		try {
			filter = URLEncoder.encode(filter, "UTF-8");
		} catch (UnsupportedEncodingException e) {

		}
		String params = "?spu_id=" + spuId + "&size=" + limit + "&dir_lev=" + lev + "&group_limit=5&filter=" + filter;
		String url = rec_dir_url + params;
		HttpClientUtil util = HttpClientUtil.getHttpClientInstance();
		String json = util.sendHttpGet(url);
		JSONObject object = JSONObject.parseObject(json);
		if ("ok".equalsIgnoreCase(object.getString("errorMsg")) || 0 == object.getIntValue("errorCode")) {

			JSONObject data = object.getJSONObject("data");
			JSONObject dirProductMap = data.getJSONObject("dirProductMap");
			Map<String, List<String>> dirProMap = (Map<String, List<String>>) JSON.parse(dirProductMap.toJSONString());
			return dirProMap;
		} else {
			return new HashMap<String, List<String>>();
		}
	}

	
	protected List<String> splitShopList(List<String> oldList,int num){
	    if(oldList.size()<=num){
	        return oldList;
	    }else{
	        return oldList.subList(0, num);
	    }
	}

}

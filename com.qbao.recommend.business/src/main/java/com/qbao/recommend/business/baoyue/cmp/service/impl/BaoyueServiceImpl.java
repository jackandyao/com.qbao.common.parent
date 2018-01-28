package com.qbao.recommend.business.baoyue.cmp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.qbao.recommend.business.baoyue.cmp.cache.BaoyueCache;
import com.qbao.recommend.business.baoyue.cmp.service.IBaoyueService;
import com.qbao.recommend.business.baoyue.rest.dto.BaoYueDto;
import com.qbao.recommend.respositoy.mysql.model.Category;
import com.qbao.recommend.respositoy.mysql.model.SpuInfoMerchant;
import com.qbao.recommend.respositoy.mysql.model.UserProfile;
import com.qbao.recommend.respositoy.mysql.service.ICategoryService;
import com.qbao.recommend.respositoy.mysql.service.IMerMiddleDataService;
import com.qbao.recommend.respositoy.mysql.service.IUserProfileService;
import com.qbao.recommend.respositoy.restful.entities.User;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.http.HttpClientUtil;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;

@Service
public class BaoyueServiceImpl implements IBaoyueService{

	@Autowired
	ICategoryService categoryService;
	
	@Autowired
	IUserProfileService userProfileService;
	
	@Autowired
	IMerMiddleDataService iMerMiddleDataService;
	private Logger infoLogger = LoggerManagerUtil.getLogger(LogNameEnum.bao_yue, Level.INFO);
	
	private Timer timer;
	
	@PostConstruct
	public void startTimer(){
		timer = new Timer(true);
		timer.schedule(
		new java.util.TimerTask() { 
			public void run(){
				infoLogger.info("执行上架商品定时器任务！");
				try{
					init();
				}catch(Exception e){
					infoLogger.info(e,e);
				}
			}
		}, 0, 24*60*60*1000);
	}
	
	@Override
	public List<BaoYueDto> filter(List<User> users , long categoryId) {
		infoLogger.info("Get into the filter method : userList + " + users  + "categoryId: " + categoryId);
		
		List<BaoYueDto> sameTopicUsers = Lists.newArrayList();
		List<BaoYueDto> recommendUsers = Lists.newArrayList();
		List<BaoYueDto> distanceUsers = Lists.newArrayList();
		Map<Long, User> cache = Maps.newHashMap();
		Set<Long> filterSet = Sets.newHashSet();
		Category category = categoryService.getCategoryById(categoryId);
		if(CollectionUtils.isNotEmpty(users) && category != null){
			for (User user : users) {
				long userId = user.getId();
				UserProfile userProfile = userProfileService.findById(userId);
				if(userProfile == null) continue;
				int status = acceptAttendSameBaoyue(userProfile,category);
				double distance = user.getDistance();
				if(status!=-1){
					filterSet.add(userId);
					if(status==1) sameTopicUsers.add(new BaoYueDto(userId, "发过相同类型宝约的用户", distance));
					if(status==2) sameTopicUsers.add(new BaoYueDto(userId, "领过相同类型宝约的用户", distance));
				} else {
					status = accept(userProfile,category);
					if(status!=-1) filterSet.add(userId);
					if(status==1) recommendUsers.add(new BaoYueDto(userId, "有票匹配用户", distance));
					if(status==2) recommendUsers.add(new BaoYueDto(userId, "浏览商品匹配用户", distance));
					if(status==3) recommendUsers.add(new BaoYueDto(userId, "购买商品匹配用户", distance));
				}
			}
		}
		infoLogger.info("推荐发过领过相同类型宝约的用户:" + sameTopicUsers);
		infoLogger.info("购物、有票、酷雅数据后，推荐的用户:" + recommendUsers);
		sameTopicUsers.addAll(recommendUsers);
		
		if(CollectionUtils.isNotEmpty(users)){
			for (User user : users) {
				long userId = user.getId();
				if(!filterSet.contains(userId)) {
					distanceUsers.add(new BaoYueDto(userId, "按距离推荐的用户",user.getDistance()));
					filterSet.add(userId);
				}
			}
		}
		infoLogger.info("分析宝约地点后，推荐距离最近的用户:" + distanceUsers);
		sameTopicUsers.addAll(distanceUsers);
		filterSet = null;
		return sameTopicUsers;
	}
	
	private int accept(UserProfile userProfile, Category category) {
		if(userProfile==null||userProfile.getJson()==null||category==null) return -1;
		
		JSONObject object = JSON.parseObject(userProfile.getJson());
		String name = category.getName();
		//其他不推荐
		if("其他".equals(name)) return -1;
		//电影社交，推荐看过电影和影出的用户
		if(name.contains("社交")||name.contains("电影")) {
			JSONObject youpiao = object.getJSONObject("you_piao");
			if(youpiao.getJSONArray("film_items").size()>0||youpiao.getJSONArray("show_items").size()>0) {
				infoLogger.info("有票匹配用户：" + userProfile.getUserId());
				return 1;
			}
		}
		List<String> categoryDirs = getDirListByKw(category.getName());
		JSONObject goods = object.getJSONObject("goods");
		if(goods!=null){
			//推荐浏览购买过的商品类型包含宝约主题的用户
			//推荐浏览购买过的商品所在类目被包括在主题所在商品类目的用户
			if(filterItems(goods.getJSONArray("view_items"), name, categoryDirs)) {
				infoLogger.info("浏览商品匹配用户：" + userProfile.getUserId());
				return 2;
			}
			if(filterItems(goods.getJSONArray("buy_items"), name, categoryDirs)) {
				infoLogger.info("购买商品匹配用户：" + userProfile.getUserId());
				return 3;
			}
		}
		return -1;
	}
	
	private int acceptAttendSameBaoyue(UserProfile userProfile, Category category){
		JSONObject object = JSON.parseObject(userProfile.getJson());
		//优先推荐发过领过相同类型宝约的用户
		JSONObject baoYue = object.getJSONObject("bao_yue");
		if(baoYue != null) {
			if(filterAttendSameBaoyue(baoYue.getJSONArray("publish"), category.getId())) return 1;
			if(filterAttendSameBaoyue(baoYue.getJSONArray("recive"), category.getId())) return 2;
		}
		return -1;
	}
	
	private boolean filterAttendSameBaoyue(JSONArray array, long cateId){
		if(array!=null && array.size()>0){
			for (int i = 0; i < array.size(); i++) {
				JSONObject baoyueTask = array.getJSONObject(i);
				long categoryId = baoyueTask.getLongValue("task_type");
				if(categoryId==cateId) return true;
			}
		}
		return false;
	}
	private boolean filterItems(JSONArray array, String categoryName, List<String> categoryDirs){
		if(array!=null && array.size()>0){
			for (int i = 0; i < array.size(); i++) {
				JSONObject item = array.getJSONObject(i);
				String itemCategory = item.getString("category");
				if(itemCategory!=null && itemCategory.contains(categoryName)) return true;
				Long goodsId = item.getLongValue("goods_id");
				String dirId = BaoyueCache.spuIdDirIdMap.get(goodsId);
				if(dirId==null) continue;
				if(categoryDirs.contains(dirId)) return true;
			}
		}
		return false;
	}
	private List<String> getDirListByKw(String kw){
		if(BaoyueCache.baoyueDirList.get(kw)!=null) 
			return BaoyueCache.baoyueDirList.get(kw);
		return saveCacheKwDir(kw,3);
	}
	
	private List<String> saveCacheKwDir(String kw, int retryCount){
		List<String> list = Lists.newArrayList();
		if(kw!=null && BaoyueCache.baoyueDirList.get(kw)==null){
			String json = HttpClientUtil.getHttpClientInstance().getHttpResponse("http://sear.qbao.com/search/goods/facets_kw.html?kw="+kw);
			try{
				JSONObject object = JSON.parseObject(json);
				JSONArray array = object.getJSONArray("data");
				for (int i = 0; i < array.size(); i++) {
					JSONObject jsonObject = array.getJSONObject(i);
					list.add(jsonObject.getString("key"));
				}
				BaoyueCache.baoyueDirList.put(kw,list);
				infoLogger.info("正在解析主题关键字: "+ kw);
				Thread.sleep(3000);
			}catch(Exception e){
				infoLogger.info(json);
				infoLogger.info("解析http://sear.qbao.com/search/goods/facets_kw.html?kw="+kw + ",出错,等待10秒重试");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if(retryCount>0) saveCacheKwDir(kw,--retryCount);
				else return list;
			}
		}
		return list;
	}

	private void init() {
		int page = 0;
		int limit = 3000;
		List<SpuInfoMerchant> list = null;
		do{
			list = iMerMiddleDataService.findByPage(page++*limit, limit);
			if(list != null){
				for(SpuInfoMerchant spu : list){
					BaoyueCache.spuIdDirIdMap.put(spu.getSpuId(), spu.getDirId());
				}
			}
			infoLogger.info("加载上架商品数：" + BaoyueCache.spuIdDirIdMap.size() );
		}while(list!=null && limit == list.size());
		
		List<Category> kws = categoryService.findAll();
		for(Category category : kws){
			String name = category.getName();
			saveCacheKwDir(name,3);
		}
		infoLogger.info("已经解析主题类目完毕");
	}

	@Override
	public List<BaoYueDto> filter(List<User> users, long categoryId, int limit) {
		infoLogger.info("Get into the filter method : userList + " + users  + ",categoryId: " + categoryId + ", limit:" + limit);

		List<BaoYueDto> sameTopicUsers = Lists.newArrayList(); 
		List<BaoYueDto> recommendUsers = Lists.newArrayList(); 
		List<BaoYueDto> distanceUsers = Lists.newArrayList();
		Map<Long, User> cache = Maps.newHashMap();
		Set<Long> filterSet = Sets.newHashSet();
		Category category = categoryService.getCategoryById(categoryId);
		if(CollectionUtils.isNotEmpty(users) && category != null){
			List<UserProfile> userProfileList = Lists.newArrayList();
			for (User user : users) {
				long userId = user.getId();
				cache.put(userId,user);
				UserProfile userProfile = userProfileService.findById(userId);
				if(userProfile == null) continue;
				userProfileList.add(userProfile);
				int status = acceptAttendSameBaoyue(userProfile,category);
				if(status != -1){
					final double distance = user.getDistance();
					if(status==1) sameTopicUsers.add(new BaoYueDto(userId, "发过相同类型宝约的用户", distance));
					if(status==2) sameTopicUsers.add(new BaoYueDto(userId, "领过相同类型宝约的用户", distance));
					filterSet.add(userId);
					if(sameTopicUsers.size()>=limit){
						infoLogger.info("发过领过相同类型宝约的用户:" + sameTopicUsers);
						return sameTopicUsers;
					}
				}
			}

			for (UserProfile userProfile : userProfileList) {
				long userId = userProfile.getUserId();
				if(filterSet.contains(userId)) continue;
				int status = accept(userProfile,category);
				if(status!=-1) filterSet.add(userId);
				final double distance = cache.get(userId).getDistance();
				if(status==1) recommendUsers.add(new BaoYueDto(userId, "有票匹配用户", distance));
				if(status==2) recommendUsers.add(new BaoYueDto(userId, "浏览商品匹配用户", distance));
				if(status==3) recommendUsers.add(new BaoYueDto(userId, "购买商品匹配用户", distance));
				
				if((sameTopicUsers.size()+recommendUsers.size())>=limit) {
					sameTopicUsers.addAll(recommendUsers);
					infoLogger.info("分析购物、有票、酷雅数据后，推荐的用户:" + recommendUsers);
					return sameTopicUsers;
				}
			}
			infoLogger.info("分析购物、有票、酷雅数据后，推荐的用户:" + recommendUsers);
			sameTopicUsers.addAll(recommendUsers);
			
			if(CollectionUtils.isNotEmpty(users)){
				for(User user : users){
					long userId = user.getId();
					if(!filterSet.contains(userId)) {
						distanceUsers.add(new BaoYueDto(userId, "按距离推荐的用户",user.getDistance()));
						filterSet.add(userId);
					}
				}
			}
			infoLogger.info("分析宝约地点后，推荐距离最近的用户:" + distanceUsers);
			sameTopicUsers.addAll(distanceUsers);
			userProfileList = null;
			filterSet = null;
			
		}
		return sameTopicUsers.size()>limit?sameTopicUsers.subList(0, limit):sameTopicUsers;
	}

}

/**
 * 
 */
package com.qbao.recommend.stream.cmp.handler.impl;

 
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qbao.dc.redis.model.UserItemsBean;
import com.qbao.recommend.respositoy.redis.IRedisService;
import com.qbao.recommend.respositoy.redis.common.RedisModel;
import com.qbao.recommend.respositoy.redis.factory.RedisModelFactory;
import com.qbao.recommend.respositoy.redis.model.Click;
import com.qbao.recommend.respositoy.redis.model.Event;
import com.qbao.recommend.respositoy.redis.model.Favorites;
import com.qbao.recommend.respositoy.redis.model.GoodsItems;
import com.qbao.recommend.stream.cmp.domain.nginx.Record;
import com.qbao.recommend.stream.cmp.handler.IHandler;
import com.qbao.recommend.stream.cmp.parser.KafkaParser;
import com.qbao.recommend.util.http.HttpClientUtil;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-21 10:47:45 +0800 (Wed, 21 Sep 2016) $
 * $LastChangedRevision: 1117 $
 * $LastChangedBy: shuaizhihu $
 */
@Service
public class RecommendHandleImpl implements IHandler {

	@Value("${http.realtime.url}")
	private String realtimeUrl;
	
    @Autowired
    private IRedisService iRedisService;

    private KafkaParser<?> parser;

    @Override
    public boolean process(String message) {

        Record record = (Record) getParser().parse(message);
        if (null == record) {
            return true;
        }
        kafkaInfoLogger.info(record.getUserId() + "\t" + record.getGoodsId());
        RedisModel<?> queryModel = RedisModelFactory.getQueryModel(record.getUserId(), UserItemsBean.class);
        RedisModel targetModel = iRedisService.find(queryModel);
        kafkaWarnLogger.warn("从redis查询到的对象实例:" + queryModel.getKey());
        UserItemsBean userItemsBean = (targetModel.getValue() == null || isNeedUpdated(targetModel, record)) ? updateUserItems(targetModel, record) : null;
        if (null != userItemsBean) {
            RedisModel redisModel = RedisModelFactory.getRedisModel(userItemsBean.getUserId(), userItemsBean);
            kafkaWarnLogger.warn("获取到一个最终结果 : " + redisModel.getKey());
            iRedisService.save(redisModel);
            // 调用实时推荐计算
            HttpClientUtil.getHttpClientInstance().getHttpResponse(realtimeUrl+"?userId="+userItemsBean.getUserId());
            kafkaWarnLogger.warn("保存实时推荐结果到redis中: " + record.getUserId());

        } else {
            kafkaWarnLogger.warn("是否需要更新 " + record + " to redis");
        }
        return true;
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub

    }

    private boolean isNeedUpdated(RedisModel<UserItemsBean> model, Record record) {
        boolean result = true;
        switch (record.getEventType()) {
        case CLICK:
            result = (isGoodsIdInUserItems(model, record) || isGoodsIdInClickList(model, record) || isGoodsIdInFavorites(model, record));
            break;
        case FAVORITE:
            result = (isGoodsIdInUserItems(model, record) || isGoodsIdInFavorites(model, record));
            break;
        }
        kafkaWarnLogger.warn("isNeedUpdated: " + !result);
        return !result;
    }

    private boolean isGoodsIdInUserItems(RedisModel<UserItemsBean> model, Record record) {
        boolean result = false;
        if (null == model.getValue().getEvent() || null == model.getValue().getGoodsItems()) {
            return result;
        }
        ArrayList<GoodsItems> items = model.getValue().getGoodsItems();

        if (items.size() > 0) {
            return result;
        }
        for (GoodsItems goods : items) {
            if (StringUtils.equalsIgnoreCase(goods.getGoodsId(), record.getGoodsId())) {
                result = result || true;
                break;
            }
        }
        return result;
    }

    private boolean isGoodsIdInClickList(RedisModel<UserItemsBean> model, Record record) {
        boolean result = false;
        if (null == model.getValue().getEvent() || null == model.getValue().getEvent().getClick()) {
            return result;
        }
        ArrayList<Click> clicks = model.getValue().getEvent().getClick();
        for (Click click : clicks) {
            if (StringUtils.equalsIgnoreCase(click.getGoodsId(), record.getGoodsId())) {
                result = result || true;
                break;
            }
        }
        return result;
    }

    public static void delClickItem(ArrayList<Click> clickItems, String goodsId) {
        Iterator<Click> it = clickItems.iterator();
        while (it.hasNext()) {
            if (it.next().getGoodsId().equals(goodsId)) {
                it.remove();
            }
        }

    }

    private UserItemsBean updateUserItems(RedisModel<UserItemsBean> model, Record record) {
        String now = this.dateFormat.format(new Date());
        UserItemsBean value = (UserItemsBean) model.getValue();
        if (null == value) {
            value = UserItemsBean.createDefaultUserItemBean();
            value.setUserId(record.getUserId());
            value.setCreateTime(now);
        }
        Event event = value.getEvent();
        if (event == null) {
            event = new Event();
            event.setClick(new ArrayList<Click>());
            event.setFavorites(new ArrayList<Favorites>());
            value.setEvent(event);
        }

        switch (record.getEventType()) {
        case CLICK:
            ArrayList<Click> clickItems = event.getClick();
            clickItems.add(new Click(record.getGoodsId(), record.getIsBaoGou()));
            event.setClick(clickItems);
            break;
        case FAVORITE:
            ArrayList<Favorites> favoriteItems = event.getFavorites();
            favoriteItems.add(new Favorites(record.getGoodsId(), record.getIsBaoGou()));
            event.setFavorites(favoriteItems);
            delClickItem(event.getClick(), record.getGoodsId());
            break;
        }
        value.setFlag(true);
        value.setUpdateTime(now);
        return value;
    }

    private boolean isGoodsIdInFavorites(RedisModel<UserItemsBean> model, Record record) {
        boolean result = false;
        if (null == model.getValue().getEvent() || null == model.getValue().getEvent().getFavorites()) {
            return result;
        }
        ArrayList<Favorites> favoritesList = model.getValue().getEvent().getFavorites();
        for (Favorites favorites : favoritesList) {
            if (StringUtils.equalsIgnoreCase(favorites.getGoodsId(), record.getGoodsId())) {
                result = result || true;
                break;
            }
        }
        return result;
    }

    @Override
    public KafkaParser<?> getParser() {
        return parser;
    }

    @Override
    public void setParser(KafkaParser<?> parser) {
        this.parser = parser;
    }

}

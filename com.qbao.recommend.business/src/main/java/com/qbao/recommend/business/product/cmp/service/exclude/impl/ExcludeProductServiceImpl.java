package com.qbao.recommend.business.product.cmp.service.exclude.impl;

import com.google.common.collect.Lists;
import com.qbao.recommend.business.product.cmp.service.exclude.IExcludeProductService;
import com.qbao.recommend.respositoy.mysql.model.ExcludeProduct;
import com.qbao.recommend.respositoy.mysql.model.UserExcludeProductJson;
import com.qbao.recommend.respositoy.mysql.model.UserExcludeProducts;
import com.qbao.recommend.respositoy.mysql.service.IUserExcludeProductJsonService;
import com.qbao.recommend.respositoy.redis.IRedisService;
import com.qbao.recommend.util.date.DateUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

/**
 * @author wangping
 * @createTime 上午10:14
 * $$LastChangedDate: 2016-11-09 19:59:02 +0800 (Wed, 09 Nov 2016) $$
 * $$LastChangedRevision: 1377 $$
 * $$LastChangedBy: wangping $$
 */
@Service
public class ExcludeProductServiceImpl implements IExcludeProductService {

    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private IRedisService redisService;

    @Autowired
    private IUserExcludeProductJsonService userExcludeProductJsonService;

    @Override
    public List<Long> calExcludeProductIds(long userId) {
        UserExcludeProductJson userExcludeProductJson = getUserExcludeProductJson(userId);
        List<Long> ids = getExcludeProductIds(userExcludeProductJson);
        return ids;
    }

    private List<Long> getExcludeProductIds(UserExcludeProductJson userExcludeProductJson) {
        List<Long> ids = Lists.newArrayList();
        if (null != userExcludeProductJson) {
            UserExcludeProducts model = userExcludeProductJson.json2Model();
            if (null != model) {
                List<ExcludeProduct> products = model.getExcludeProducts();
                if (CollectionUtils.isNotEmpty(products)) {
                    for (ExcludeProduct product : products) {
                        ids.add(NumberUtils.toLong(product.getGoodsId()));
                    }
                }
            }
        }
        return ids;
    }

    @Override
    public void exectue(long userId, long goodsId) {
        logger.info("execute : Exclude Service ... user id [" +userId+"], goods id =["+goodsId+"]");
        UserExcludeProductJson userExcludeProductJson = getUserExcludeProductJson(userId);
        List<Long> ids = getExcludeProductIds(userExcludeProductJson);
        if (!ids.contains(goodsId)) {
            UserExcludeProducts userExcludeProducts = userExcludeProductJson.json2Model();
            List<ExcludeProduct> excludeProducts;
            if (null == userExcludeProducts) {
                userExcludeProducts = new UserExcludeProducts();
                userExcludeProducts.setUserId(String.valueOf(userId));
                excludeProducts = Lists.newArrayList();
                userExcludeProducts.setExcludeProducts(excludeProducts);
            }

            excludeProducts = userExcludeProducts.getExcludeProducts();
            ExcludeProduct excludeProduct = getExcludeProduct(goodsId);
            excludeProducts.add(excludeProduct);
            //持久化到mysql
            persist(userId, userExcludeProducts.toJson());
            String key = generateRedisKey(userId);
            //删除缓存
            logger.info("delete key [" + key + "] from redis is successful" + redisService.delete(key));
        }
    }

    private String generateRedisKey(long userId) {
        return "UserExcludeProductJsonServiceImpl_findByUserId_" + userId;
    }

    private UserExcludeProductJson getUserExcludeProductJson(long userId) {
        return userExcludeProductJsonService.findByUserId(userId);
    }

    private void persist(long userId, String json) {
        userExcludeProductJsonService.delete(userId);
        userExcludeProductJsonService.insert(userId,json);
    }

    private ExcludeProduct getExcludeProduct(long goodsId) {
        ExcludeProduct excludeProduct = new ExcludeProduct();
        excludeProduct.setGoodsId(String.valueOf(goodsId));
        excludeProduct.setCreateTime(DateUtil.parseDateSToStr(new Date()));
        excludeProduct.setIsBaogou(false);
        excludeProduct.setSource("HaoHuo");
        return excludeProduct;
    }

}

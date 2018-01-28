/**
 * 
 */
package com.qbao.recommend.business.product.rest;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Map;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate$
 * $LastChangedRevision$
 * $LastChangedBy$
 */
public interface IHaohuoService {
    /**
     * 数据助手 好货接口
     * @param p
     * @return
     */
    Map<String,Object> getHaohuos( long userId, int page,int pageSize);
    
    /**
     * 限时抢购 接口
     * @param p
     * @return
     */
    Map<String,Object> getFlashSales(long userId,  int pageSize,  int single);

    /**
     * 用户不喜欢的商品
     * @param userId
     * @param goodsId
     * @return
     */
    public Map<String, Object> exclude(long userId, long goodsId);


}

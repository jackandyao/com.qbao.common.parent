/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.service;

import java.util.List;

import com.qbao.recommend.respositoy.mysql.model.SpuInfoBaogou;
import com.qbao.recommend.respositoy.mysql.page.Page;


/**
 * @author shuaizhihu
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
public interface IBcProductService{
    public List<SpuInfoBaogou> findByLimit(int page,int pageSize);
    public Page<SpuInfoBaogou> findBcProductSellingPage(int pageIndex, int pageSize);
    
    /**
     * 根据spuId查询宝购在售商品的实体
     * @param spuId
     * @return
     */
    public SpuInfoBaogou findBySpuId(long spuId);
    
    /**
     * 查询所有在售的宝购商品
     * @return
     */
    public List<Long> findSellingAll();
    
    /**
     * 根据宝购id查询宝购在售商品的实体
     * @param spuId
     * @return
     */
    public SpuInfoBaogou findSellingById(long id);
    
    /**
     * 根据宝购id查询宝购商品的实体
     * @param spuId
     * @return
     */
    public SpuInfoBaogou findById(long id);
}

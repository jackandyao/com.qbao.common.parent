/**
 * 
 */
package com.qbao.recommend.respositoy.redis;

import com.qbao.recommend.respositoy.redis.common.RedisModel;

/**
 * @author shuaizhihu
 * redis通用操作接口：保存（更新记录） 删除记录  读取记录
 * $LastChangedDate: 2016-11-09 19:59:02 +0800 (Wed, 09 Nov 2016) $
 * $LastChangedRevision: 1377 $
 * $LastChangedBy: wangping $
 * 
 */
public interface IRedisService{
    
    /**
     * 根据key查找redis一条记录
     * @param key
     * @return T
     */
    public RedisModel<?> find(RedisModel<?> model);
    
    /**
     * 批量插入redis多条记录
     * @param modelList
     * @return
     */
    public boolean save(RedisModel<?> model);
    
    public boolean save (RedisModel<?> model,int expire);
   
    /**
     * 根据key值删除redis记录
     * @param key
     * @return
     */
    public boolean delete(RedisModel<?> model);

    public boolean delete(String key);
    
    /**
     * 模糊批量删除keys
     * @param model
     * @return
     */
    public boolean deleteList(RedisModel<?> model);
    
}

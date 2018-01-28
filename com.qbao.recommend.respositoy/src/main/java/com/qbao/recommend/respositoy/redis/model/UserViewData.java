/**
 * 
 */
package com.qbao.recommend.respositoy.redis.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
@Deprecated
public class UserViewData implements Serializable {

    private String uid;
    private List<String> spuIds;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<String> getSpuIds() {
        return spuIds;
    }

    public void setSpuIds(List<String> spuIds) {
        this.spuIds = spuIds;
    }

}

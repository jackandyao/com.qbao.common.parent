/**
 * 
 */
package com.qbao.recommend.respositoy.redis.model;

import java.io.Serializable;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
public class TestBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

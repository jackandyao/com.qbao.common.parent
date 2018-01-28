/**
 * 
 */
package com.qbao.recommend.business.tweet.cmp.emergency;

import com.google.common.collect.Lists;
import com.qbao.recommend.business.tweet.model.TweetDTO;

import java.util.List;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2017-01-12 15:31:24 +0800 (Thu, 12 Jan 2017) $
 * $LastChangedRevision: 1542 $
 * $LastChangedBy: wangping $
 */
public class EmergencyData {

    public static List<TweetDTO> buildPcEmergencyData() {
        List<TweetDTO> lists = Lists.newArrayList();
        TweetDTO dto1 = new TweetDTO();
        dto1.setId(1);
        dto1.setTitle("【有券】华山论剑，以文会友，文笔彰显实力");
        dto1.setUrl("http://mp2.qbao.com/s/339c8b0866a448288c2c171ad81917cd?sn=43be530744ba48fba21de2401602afc8&devType=pc");
        dto1.setSource("Emergency data");
        lists.add(dto1);

        TweetDTO dto2 = new TweetDTO();
        dto2.setId(2);
        dto2.setTitle("【您收藏的店铺状态已更新】");
        dto2.setUrl("http://mp2.qbao.com/s/0217ae04a5e44a84840874b9d075e817?sn=51d18bc469f64555a5e8f2251ddedb2b&devType=pc");
        dto2.setSource("Emergency data");
        lists.add(dto2);

        TweetDTO dto3 = new TweetDTO();
        dto3.setId(3);
        dto3.setTitle("希望在高高山丘，希望在笑靥如花，希望在龙潭坪小学！");
        dto3.setUrl("http://mp2.qbao.com/s/cd0dcb4e11d1460bb88a2943e0a9f871?sn=de2ef53c58e742eab6fe4d324d79b20a&devType=pc");
        dto3.setSource("Emergency data");
        lists.add(dto3);
        return lists;
    }

    public static List<TweetDTO> buildAppEmergencyData() {
        List<TweetDTO> lists = Lists.newArrayList();
        TweetDTO dto1 = new TweetDTO();
        dto1.setId(1);
        dto1.setTitle("【有券】华山论剑，以文会友，文笔彰显实力");
        dto1.setUrl("http://mp2.qbao.com/s/339c8b0866a448288c2c171ad81917cd?sn=43be530744ba48fba21de2401602afc8");
        dto1.setSource("Emergency data");
        lists.add(dto1);

        TweetDTO dto2 = new TweetDTO();
        dto2.setId(2);
        dto2.setTitle("【您收藏的店铺状态已更新】");
        dto2.setUrl("http://mp2.qbao.com/s/0217ae04a5e44a84840874b9d075e817?sn=51d18bc469f64555a5e8f2251ddedb2b");
        dto2.setSource("Emergency data");
        lists.add(dto2);

        TweetDTO dto3 = new TweetDTO();
        dto3.setId(3);
        dto3.setTitle("希望在高高山丘，希望在笑靥如花，希望在龙潭坪小学！");
        dto3.setUrl("http://mp2.qbao.com/s/cd0dcb4e11d1460bb88a2943e0a9f871?sn=de2ef53c58e742eab6fe4d324d79b20a");
        dto3.setSource("Emergency data");
        lists.add(dto3);
        return lists;
    }
}

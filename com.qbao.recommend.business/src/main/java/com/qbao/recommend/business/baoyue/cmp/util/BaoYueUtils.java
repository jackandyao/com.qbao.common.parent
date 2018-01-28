package com.qbao.recommend.business.baoyue.cmp.util;

import com.google.common.collect.Lists;
import com.qbao.recommend.business.baoyue.rest.dto.BaoYueDto;
import com.qbao.recommend.respositoy.restful.entities.User;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * @author wangping
 * @createTime 下午5:10
 * $$LastChangedDate: 2016-11-22 18:17:45 +0800 (Tue, 22 Nov 2016) $$
 * $$LastChangedRevision: 1442 $$
 * $$LastChangedBy: wangping $$
 */
public class BaoYueUtils {

    public static List<BaoYueDto> getBaoYueDto(List<Long> userIds){
        List<BaoYueDto> result = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(userIds)){
            for(Long userId : userIds){
                BaoYueDto dto = new BaoYueDto();
                dto.setId(userId);
                result.add(dto);
            }
        }
        return result;
    }
    public static List<Long> getUserId(List<User> users){
        List<Long> result = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(users)){
            for( User user : users){
                result.add(user.getId());
            }
        }
        return result;
    }

}

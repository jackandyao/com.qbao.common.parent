/**
 * 
 */
package com.qbao.recommend.business.task.cmp.common;

import com.qbao.recommend.business.task.cmp.model.user.UserLevel;
import com.qbao.recommend.respositoy.mysql.model.QbaoUser;
import com.qbao.recommend.respositoy.mysql.model.UserProfile;
import com.qbao.recommend.respositoy.mysql.model.UserScoreLevel;
import com.qbao.recommend.respositoy.mysql.service.IUserProfileService;
import com.qbao.recommend.respositoy.mysql.service.IUserScoreLevelService;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-11-09 19:59:02 +0800 (Wed, 09 Nov 2016) $
 * $LastChangedRevision: 1377 $
 * $LastChangedBy: wangping $
 */
@Component
public class UserService {
    private Logger logger = LoggerManagerUtil.getLogger(LogNameEnum.task, Level.INFO);

    @Autowired
    private IUserProfileService userProfileService;

    @Autowired
    private IUserScoreLevelService userScoreLevelService;

    /**
     * 
     * @param userId
     * @return bao bi
     */
    @Cacheable(value = "1hourCache", key = "#userId+'getUserAsset'")
    public long getUserAsset(long userId) {
        long asset = -1;
        UserProfile userProfile = userProfileService.findById(userId);
        if (null != userProfile) {
            QbaoUser qbaoUser = userProfile.json2QbaoUser();
            if (null != qbaoUser && null != qbaoUser.getAsset()) {
                asset = qbaoUser.getAsset().getBaobiSnapshot();
            }
        }
        logger.info("user id [" + userId + "] ,  bao bi asset [" + asset + "]");
        return asset;
    }

    @Cacheable(value = "1hourCache", key = "#userId+'getUserLevel'")
    public UserLevel getUserLevel(long userId) {
        UserLevel level = UserLevel.UNKNOW;
        UserScoreLevel userScoreLevel = userScoreLevelService.findById(userId);
        if (null != userScoreLevel) {
            level = UserLevel.asUserLevel(userScoreLevel.getLevel());
        }
        logger.info("user id [" + userId + "] ,  Level [" + level + "]");
        return level;
    }
}

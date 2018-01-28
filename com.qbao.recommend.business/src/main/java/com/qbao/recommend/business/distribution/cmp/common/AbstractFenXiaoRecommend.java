package com.qbao.recommend.business.distribution.cmp.common;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qbao.recommend.business.distribution.cmp.util.ConstantUtils;
import com.qbao.recommend.respositoy.mysql.model.AgentView;
import com.qbao.recommend.respositoy.mysql.service.IAgentTaskService;
import com.qbao.recommend.respositoy.mysql.service.IAgentViewService;

/**
 * @author yuandongrui
 * @date 2016年7月11日
 */
public abstract class AbstractFenXiaoRecommend {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    @Autowired
    IAgentTaskService agentTaskService;
    @Autowired
    IAgentViewService agentViewService;

    public void delOffTimeAgent(List<Long> agentIds) {
        if (CollectionUtils.isNotEmpty(agentIds)) {
            Iterator<Long> it = agentIds.iterator();
            while (it.hasNext()) {
                Long agentId = it.next();
                if (!agentTaskService.isSellingByTaskId(agentId)) {
                    logger.info("agent id =[" + agentId + "] is off time, and be deleted");
                    it.remove();
                }
            }
        }
    }

    public Set<Long> getUserAgentHistory(Long userId) {
        Set<Long> result = new HashSet<>();
        AgentView agentView = agentViewService.findByUserId(userId);
        if (null != agentView && StringUtils.isNotBlank(agentView.getItems())) {
            JSONArray array = JSON.parseArray(agentView.getItems());
            for (int i = 0; i < array.size(); i++) {
                JSONObject object = array.getJSONObject(i);
                Long agentId = object.getLong(ConstantUtils.AGENT_ID);
                result.add(agentId);
            }
        }
        return result;
    }

}

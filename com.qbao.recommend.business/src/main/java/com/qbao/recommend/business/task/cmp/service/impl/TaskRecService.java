/**
 * 
 */
package com.qbao.recommend.business.task.cmp.service.impl;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.qbao.recommend.business.task.cmp.facade.TaskRecFacde;
import com.qbao.recommend.business.task.cmp.model.dto.TaskDto;
import com.qbao.recommend.business.task.cmp.service.ITaskRecSerivce;
import com.qbao.recommend.business.task.cmp.util.MailUtils;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-12-05 18:53:02 +0800 (Mon, 05 Dec 2016) $
 * $LastChangedRevision: 1510 $
 * $LastChangedBy: wangping $
 */
@Path("task/api")
public class TaskRecService implements ITaskRecSerivce {
    Logger logger = LoggerManagerUtil.getLogger(LogNameEnum.task, Level.INFO);

    @Autowired
    private TaskRecFacde taskRecFacde;

    @GET
    @Path("/recommendation/{userId}")
    @Produces(ContentType.APPLICATION_JSON_UTF_8)
    @Override
    public Map<String, Object> recommend(@PathParam("userId") long userId,@QueryParam("limit") @DefaultValue("1") int limit) {
        logger.info("starting user id =[" + userId + "] and limit =["+limit+"] task recommendation ... ");
        List<TaskDto> data = new ArrayList<>();
        List<TaskDto> recommendTasks = taskRecFacde.recommend(userId,limit);
        Map<String, Object> response = new HashMap<String, Object>();
        try {
            response.put("code", "200");
            response.put("message", "success");
            response.put("data", recommendTasks);
        } catch (Exception e) {
            response.put("code", "-1");
            String msg = ExceptionUtils.getFullStackTrace(e);
            response.put("message", msg);
            // 通过email发送 临时方案
            MailUtils.sendInfo("任务推荐接口", " 用户账号:" + userId + ", 错误信息为:" + msg);
        }
        logger.info("user id [" + userId + "] task recommendation is done ! ");
        return response;
    }

}

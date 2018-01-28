/**
 * 
 */
package com.qbao.recommend.business.task.main;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.container.Main;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-08 18:26:11 +0800 (Thu, 08 Sep 2016) $
 * $LastChangedRevision: 965 $
 * $LastChangedBy: wangping $
 */
public class TaskRecommendMain {
    public static void main(String[] args) throws IOException {
        // String[] path = new String[] { "mysql/spring-mysql.xml", "dubbo/task_dubbo_provider.xml",
        // "redis/spring-redis.xml", "dubbo/doctor_dubbo_provider.xml" };
        String[] path = new String[] { "dubbo/task_dubbo_provider.xml" };
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
        context.start();
        Main.main(args);
    }
}

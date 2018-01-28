/**
 * 
 */
package com.qbao.recommend.business.qbike.main;

import com.alibaba.dubbo.container.Main;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-10-01 17:15:35 +0800 (星期六, 01 十月 2016) $
 * $LastChangedRevision: 1237 $
 * $LastChangedBy: wangping $
 */
public class QbikeMain {
    public static void main(String[] args) throws IOException {
        // StringSpringApplicationManager[] path = new String[] { "mysql/spring-mysql.xml", "dubbo/task_dubbo_provider.xml",
        // "redis/spring-redis.xml", "dubbo/doctor_dubbo_provider.xml" };
        String[] path = new String[] { "dubbo/qbike_dubbo_provider.xml" };
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
        context.start();
        Main.main(args);
    }
}

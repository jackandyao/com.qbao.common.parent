/**
 * 
 */
package com.qbao.recommend.respositoy.main;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.container.Main;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate: 2016-09-21 11:10:00 +0800 (Wed, 21 Sep 2016) $
 * $LastChangedRevision: 1119 $
 * $LastChangedBy: shuaizhihu $
 */
public class MysqlRecommendMain {
    public static void main(String[] args) throws IOException {
        String[] str = new String[] { "dubbo/mysql_dubbo_provider.xml" };
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(str);
        context.start();
        Main.main(args);
    }
}

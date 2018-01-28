/**
 * 
 */
package com.qbao.recommend.business.product.main;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.container.Main;

/**
 * @author shuaizhihu
 *
 * $LastChangedDate$
 * $LastChangedRevision$
 * $LastChangedBy$
 */
public class HaohuoRecommendMain {
    public static void main(String[] args) throws IOException {
        String[]path=new String[]{"dubbo/haohuo_dubbo_provider.xml"};
        ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext(path);
        context.start();
        Main.main(args);
    }
}

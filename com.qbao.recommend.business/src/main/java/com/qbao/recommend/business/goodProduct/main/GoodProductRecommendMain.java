/**
 * 
 */
package com.qbao.recommend.business.goodProduct.main;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.container.Main;

/**
 * @author sjzhangjun
 *
 * $LastChangedDate$
 * $LastChangedRevision$
 * $LastChangedBy$
 */
public class GoodProductRecommendMain {
    public static void main(String[] args) throws IOException {
        String[]path=new String[]{"dubbo/goodProduct_dubbo_provider.xml"};
        ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext(path);
        context.start();
        Main.main(args);
    }
}

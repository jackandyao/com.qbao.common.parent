/**
 * 
 */
package com.qbao.recommend.business.doctor.main;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.container.Main;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-08 18:28:59 +0800 (Thu, 08 Sep 2016) $
 * $LastChangedRevision: 967 $
 * $LastChangedBy: jiahongping $
 */
public class DoctorRecommendMain {
    public static void main(String[] args) throws IOException {
        String[]path=new String[]{"dubbo/doctor_dubbo_provider.xml"};
        ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext(path);
        context.start();
        Main.main(args);
    }
}

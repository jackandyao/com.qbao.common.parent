package com.qbao.recommend.business.distribution.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.container.Main;

public class DistributionMainService {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
        		new String[]{"dubbo/distribution_dubbo_provider.xml"});   
                context.start();  
                Main.main(args);
    
    }
}

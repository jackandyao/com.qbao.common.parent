package com.qbao.recommend.stream.kafka.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.container.Main;

public class KafkaMainService {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]
                { 
                "dubbo-kafka.xml" 
                });
        context.start();  
        Main.main(args);
    }
}

package com.qbao.recommend.business.baoyue.main;

import com.alibaba.dubbo.container.Main;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author wangping
 * @createTime 上午10:35
 * $$LastChangedDate: 2016-11-22 18:16:04 +0800 (Tue, 22 Nov 2016) $$
 * $$LastChangedRevision: 1441 $$
 * $$LastChangedBy: wangping $$
 */
public class BaoYueRecommendServiceMain {
    public static void main(String[] args) throws IOException {
        String[] path = new String[] { "dubbo/bao_yue_dubbo_provider.xml" };
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
        context.start();
        Main.main(args);
    }
}

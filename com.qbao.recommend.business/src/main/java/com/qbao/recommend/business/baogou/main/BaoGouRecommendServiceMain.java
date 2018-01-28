package com.qbao.recommend.business.baogou.main;

import com.alibaba.dubbo.container.Main;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author wangping
 * @createTime 下午2:22
 * $$LastChangedDate: 2016-11-15 18:34:23 +0800 (Tue, 15 Nov 2016) $$
 * $$LastChangedRevision: 1398 $$
 * $$LastChangedBy: wangping $$
 */
public class BaoGouRecommendServiceMain {
    public static void main(String[] args) throws IOException {
        String[] path = new String[] { "dubbo/bao_gou_dubbo_provider.xml" };
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
        context.start();
        Main.main(args);
    }
}

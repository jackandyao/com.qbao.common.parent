//package com.qbao.recommend.respositoy.hbase.cmp;
//
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.hbase.HBaseConfiguration;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.annotation.PropertySources;
//import org.springframework.stereotype.Component;
//
///**
// * 初始化hbase集群连接配置信息
// * 
// * @author 贾红平
// *
// */
//@Component
//@PropertySources({ @PropertySource("classpath:hbase-cfg.properties") })
//public class HBaseConfCmp {
//
//    @Value("${hbase.zookeeper.quorum}")
//    private String ZK_CLUSTER;
//    @Value("${hbase.zookeeper.property.clientPort}")
//    private String ZK_PORT;
//    @Value("${zookeeper.session.timeout}")
//    private String ZK_TIMEOUT;
//    @Value("${hbase.master}")
//    private String HBASE_MASTER;
//    @Value("${hbase.master.port}")
//    private String HBASE_PORT;
//
//    static Configuration hadoopCfg = null;
//
//    private HBaseConfCmp() {
//    }
//
//    /**
//     * 实例化hbase基本配置
//     * 
//     * @return
//     */
//    public Configuration getConfiguration() {
//
//        if (hadoopCfg == null) {
//
//            synchronized (HBaseConfCmp.class) {
//
//                if (hadoopCfg == null) {
//
//                    hadoopCfg = HBaseConfiguration.create();
//
//                    hadoopCfg.set("hbase.zookeeper.quorum", ZK_CLUSTER);
//
//                    hadoopCfg.set("hbase.zookeeper.property.clientPort", ZK_PORT);
//
//                    hadoopCfg.set("zookeeper.session.timeout", ZK_TIMEOUT);
//
//                    hadoopCfg.set("hbase.master", HBASE_MASTER);
//
//                    hadoopCfg.set("hbase.master.port", HBASE_PORT);
//
//                }
//            }
//        }
//        return hadoopCfg;
//    }
//}

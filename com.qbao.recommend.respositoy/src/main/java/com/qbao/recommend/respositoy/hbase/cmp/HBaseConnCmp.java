//package com.qbao.recommend.respositoy.hbase.cmp;
//
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.hbase.client.Connection;
//import org.apache.hadoop.hbase.client.ConnectionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * 创建hbase的链接并且优化
// * 
// * @author 贾红平
// *
// */
//@Component
//public class HBaseConnCmp {
//    private static ThreadLocal<Connection> thread = new ThreadLocal<Connection>();
//    private static Connection connection = null;
//
//    @Autowired
//    private HBaseConfCmp hcc;
//
//    public Connection getHConnection() {
//        connection = thread.get();
//        if (connection == null) {
//            try {
//                Configuration cfg = hcc.getConfiguration();
//                connection = ConnectionFactory.createConnection(cfg);
//                thread.set(connection);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return connection;
//
//    }
//}

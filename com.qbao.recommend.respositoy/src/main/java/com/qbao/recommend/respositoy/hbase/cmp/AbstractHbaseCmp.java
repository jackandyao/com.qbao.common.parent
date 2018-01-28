//package com.qbao.recommend.respositoy.hbase.cmp;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.hadoop.hbase.client.Connection;
//import org.apache.hadoop.hbase.client.Durability;
//import org.apache.hadoop.hbase.client.Get;
//import org.apache.hadoop.hbase.client.HBaseAdmin;
//import org.apache.hadoop.hbase.client.Put;
//import org.apache.hadoop.hbase.util.Bytes;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.qbao.recommend.respositoy.hbase.util.ICommConstanUtil;
//
//@Component
//public abstract class AbstractHbaseCmp {
//
//    protected HBaseAdmin hbaseAdmin;
//
//    protected Connection connection;
//
//    @Autowired
//    protected HBaseConnCmp hcc;
//
//    /**
//     * 初始化连接信息
//     */
//    protected void initHBase() {
//        connection = hcc.getHConnection();
//        try {
//
//            hbaseAdmin = (HBaseAdmin) connection.getAdmin();
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 把当前的数据转入成一个PUT格式数据
//     * 
//     * @param rowKey
//     * @param columnsList
//     * @return
//     */
//    protected Put parseRowPut(String rowKey, List<Map<String, String>> columnsList) {
//        Put put = new Put(Bytes.toBytes(rowKey));
//        for (int i = 0; i < columnsList.size(); i++) {
//            Map<String, String> column = columnsList.get(i);
//            put.addColumn(Bytes.toBytes(column.get(ICommConstanUtil.HBASE_COLUMN_FAMILY)), Bytes.toBytes(column.get(ICommConstanUtil.HBASE_COLUMN_QUALIFIER)), Bytes.toBytes(column.get(ICommConstanUtil.HBASE_COLUMN_VALUE)));
//        }
//
//        put.setDurability(Durability.SYNC_WAL);
//
//        return put;
//    }
//
//    /**
//     * 把当前的数据转换成GET对象
//     * 
//     * @param rowKey
//     * 行健
//     * @param colFamily
//     * 列族
//     * @param colName
//     * 列的名称
//     * @return
//     */
//    protected Get parseColumnGet(String rowKey, String colFamily, String colName) {
//        Get get = new Get(Bytes.toBytes(rowKey));
//        get.addColumn(Bytes.toBytes(colFamily), Bytes.toBytes(colName));
//        return get;
//    }
//
//    /**
//     * 释放连接
//     */
//    protected void relaseHconneciton() {
//        try {
//            if (connection != null) {
//                connection.close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

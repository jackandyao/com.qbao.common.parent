package com.qbao.recommend.respositoy.hbase;

import java.util.List;
import java.util.Map;

/**
 * 封装HBase相关操作的服务接口
 * 1 建表
 * 2 删表
 * 3 单条记录插入
 * 4 批量记录插入
 * 5 单条记录查询
 * 6 批量记录插入
 * 7 分页查询
 * 8 更新
 * 
 * @author 贾红平
 *
 */
public interface IHBaseApiService {

    /**
     * 创建表
     * 
     * @param tableName
     * @param family
     */
    void createTable(String tableName, String[] family);

    /**
     * 删除表
     * 
     * @param tableName
     */
    void deleteTable(String tableName);

    /**
     * 录入指定的一行数据到表
     * 
     * @param tableName
     * 表的名称
     * @param rowKey
     * 行健
     * @param columnFamily
     * 列族
     * @param columnQualifier
     * 列的名称
     * @param columnValue
     * 列的值
     */
    void addOneColumByKey(String tableName, String rowKey, String columnFamily, String columnQualifier, String columnValue);

    /**
     * 批量插入数据到表
     * 
     * @param tableName
     * --表的名称
     * @param rows
     * --行健
     */
    void addMultiRowsByTable(String tableName, Map<String, List<Map<String, String>>> rows);

    /**
     * 根据指定的rowkey+列族+列 获取一行数据
     * 
     * @param tableName
     * 表的名称
     * @param rowKey
     * 行健
     * @param colFamily
     * 返回列族
     * @param colName
     * 返回列的名称
     * @return
     */
    List<Map<String, String>> getOneResultByRowKey(String tableName, String rowKey, String colFamily, String colName);

    /**
     * 通过行健获取指定列族对应的值
     * 
     * @param tableName
     * 表的名称
     * @param rowKey
     * 行健
     * @param colFamily
     * 列族
     * @return
     */
    List<Map<String, String>> getOneResultByColumnFamily(String tableName, String rowKey, String colFamily);

    /**
     * 分页检索
     * 
     * @param tableName
     * 表的名称
     * @param size
     * 每页显示数量
     * @param rowNum
     * 当前页
     * @return
     */
    List<List<Map<String, String>>> getMutliResultByPageFilter(String tableName, Integer size, Integer rowNum);

    /**
     * 根据rowkey删除指定的列族
     * 
     * @param tableName
     * @param rowKey
     * @param falilyName
     * @param columnName
     */
    void deleteCFByRowKey(String tableName, String rowKey, String falilyName, String columnName);

    /**
     * 根据rowkey删除所有的列族
     * 
     * @param tableName
     * @param rowKey
     */
    void deleteAllCFByRowKey(String tableName, String rowKey);
}

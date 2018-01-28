//package com.qbao.recommend.respositoy.hbase.api;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.hadoop.hbase.Cell;
//import org.apache.hadoop.hbase.CellUtil;
//import org.apache.hadoop.hbase.HColumnDescriptor;
//import org.apache.hadoop.hbase.HTableDescriptor;
//import org.apache.hadoop.hbase.TableName;
//import org.apache.hadoop.hbase.client.Delete;
//import org.apache.hadoop.hbase.client.Get;
//import org.apache.hadoop.hbase.client.HTable;
//import org.apache.hadoop.hbase.client.Put;
//import org.apache.hadoop.hbase.client.Result;
//import org.apache.hadoop.hbase.client.ResultScanner;
//import org.apache.hadoop.hbase.client.Scan;
//import org.apache.hadoop.hbase.filter.Filter;
//import org.apache.hadoop.hbase.filter.PageFilter;
//import org.apache.hadoop.hbase.util.Bytes;
//import org.apache.log4j.Logger;
//import org.springframework.stereotype.Service;
//
//import com.qbao.recommend.respositoy.hbase.IHBaseApiService;
//import com.qbao.recommend.respositoy.hbase.cmp.AbstractHbaseCmp;
//import com.qbao.recommend.respositoy.hbase.util.ICommConstanUtil;
//
//@Service
//public class HBaseApiService extends AbstractHbaseCmp implements IHBaseApiService {
//    private static Logger logger = Logger.getLogger(HBaseApiService.class);
//
//    public HBaseApiService() {
//        super.initHBase();
//    }
//
//    /**
//     * 创建表
//     */
//    public void createTable(String tableName, String[] family) {
//        try {
//            // 判断表不存在建创建
//            if (!hbaseAdmin.tableExists(tableName)) {
//                // 表的描述器
//                TableName table = TableName.valueOf(tableName);
//                HTableDescriptor tableDesp = new HTableDescriptor(table);
//                // 列族的描述器
//                for (int i = 0; i < family.length; i++) {
//                    tableDesp.addFamily(new HColumnDescriptor(family[i]));
//                }
//                // 建立hbase表
//                hbaseAdmin.createTable(tableDesp);
//                logger.info("创建 [" + tableName + "] 表,成功...");
//            } else {
//                logger.info("表 ["+tableName+ "] 已经存在了...");
//                System.exit(0);
//            }
//        } catch (Exception e) {
//            logger.error("创建hbase ["+tableName+"] 发生了错误", e);
//        } finally {
//            if (hbaseAdmin != null) {
//                try {
//                    hbaseAdmin.close();
//                } catch (Exception e2) {
//                    logger.error("关闭出现异常",e2);
//                }
//            }
//        }
//    }
//
//    /**
//     * 删除表
//     */
//    public void deleteTable(String tableName) {
//        try {
//            // 禁用表
//            hbaseAdmin.disableTable(tableName);
//            // 删除表
//            hbaseAdmin.deleteTable(tableName);
//        } catch (Exception e) {
//            logger.error("delete ["+tableName+"]"+ e);
//        }
//    }
//
//    /**
//     * 向指定rowkey插入多个列
//     * 
//     * @param tableName
//     * @param rowKey
//     * @param columns
//     */
//    private void addMultiColByKey(String tableName, String rowKey, List<Map<String, String>> columns) {
//        HTable table = null;
//        try {
//            table = (HTable) connection.getTable(TableName.valueOf(tableName));
//            Put put = parseRowPut(rowKey, columns);
//            table.put(put);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (table != null) {
//                try {
//                    table.close();
//                } catch (IOException e) {
//                    logger.error("add multi columns to  ["+tableName+"]"+ e);
//                }
//            }
//            relaseHconneciton();
//        }
//    }
//
//    /**
//     * 单条插入
//     */
//    public void addOneColumByKey(String tableName, String rowKey, String columnFamily, String columnQualifier, String columnValue) {
//        List<Map<String, String>> columns = new ArrayList<Map<String, String>>();
//        Map<String, String> columnMap = new HashMap<String, String>();
//        columnMap.put(ICommConstanUtil.HBASE_COLUMN_FAMILY, columnFamily);
//        columnMap.put(ICommConstanUtil.HBASE_COLUMN_QUALIFIER, columnQualifier);
//        columnMap.put(ICommConstanUtil.HBASE_COLUMN_VALUE, columnValue);
//        columns.add(columnMap);
//        addMultiColByKey(tableName, rowKey, columns);
//    }
//
//    /**
//     * 多条插入
//     */
//    public void addMultiRowsByTable(String tableName, Map<String, List<Map<String, String>>> rows) {
//        HTable table = null;
//        if (rows != null) {
//            try {
//                table = (HTable) connection.getTable(TableName.valueOf(tableName));
//                for (String rowKey : rows.keySet()) {
//                    List<Map<String, String>> columns = rows.get(rowKey);
//                    Put put = parseRowPut(rowKey, columns);
//                    table.put(put);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (table != null) {
//                    try {
//                        table.close();
//                    } catch (IOException e) {
//                        logger.error("insert mulit rows to  ["+tableName+"]"+ e);
//                    }
//                }
//                relaseHconneciton();
//            }
//        }
//    }
//
//    /**
//     * 单条查询
//     */
//    public List<Map<String, String>> getOneResultByRowKey(String tableName, String rowKey, String colFamily, String colName) {
//        List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
//        HTable table = null;
//        try {
//            table = (HTable) connection.getTable(TableName.valueOf(tableName));
//
//            Get get = parseColumnGet(rowKey, colFamily, colName);
//            Result result = table.get(get);
//            for (Cell cell : result.rawCells()) {
//                Map<String, String> map = new HashMap<String, String>();
//                map.put(ICommConstanUtil.HBASE_COLUMN_ROW_KEY, Bytes.toString(result.getRow()));
//                map.put(ICommConstanUtil.HBASE_COLUMN_FAMILY_QUALIFIER, Bytes.toString(CellUtil.cloneQualifier(cell)));
//                map.put(ICommConstanUtil.HBASE_COLUMN_VALUE, Bytes.toString(CellUtil.cloneValue(cell)));
//                resultList.add(map);
//            }
//        } catch (IOException e) {
//            logger.error("query "+ rowKey + " from  ["+tableName+"]"+ e);
//        } finally {
//            try {
//                if (table != null)
//                    table.close();
//            } catch (Exception e) {
//                logger.error("close  ["+tableName+"]"+ e);
//            }
//            relaseHconneciton();
//        }
//        return resultList;
//
//    }
//
//    /**
//     * 单条查询+指定列族
//     */
//    public List<Map<String, String>> getOneResultByColumnFamily(String tableName, String rowKey, String colFamily) {
//
//        List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
//        HTable table = null;
//        try {
//            table = (HTable) connection.getTable(TableName.valueOf(tableName));
//            Get get = new Get(Bytes.toBytes(rowKey));
//            get.addFamily(Bytes.toBytes(colFamily));
//            Result result = table.get(get);
//            for (Cell cell : result.rawCells()) {
//                Map<String, String> map = new HashMap<String, String>();
//                map.put(ICommConstanUtil.HBASE_COLUMN_ROW_KEY, Bytes.toString(result.getRow()));
//                map.put(ICommConstanUtil.HBASE_COLUMN_FAMILY, Bytes.toString(CellUtil.cloneFamily(cell)));
//                map.put(ICommConstanUtil.HBASE_COLUMN_QUALIFIER, Bytes.toString(CellUtil.cloneQualifier(cell)));
//                map.put(ICommConstanUtil.HBASE_COLUMN_VALUE, Bytes.toString(CellUtil.cloneValue(cell)));
//                resultList.add(map);
//            }
//        } catch (Exception e) {
//            logger.error("query one result by column family is error . tablename:["+tableName+"], rowkey:["+rowKey+"], colFamily:["+colFamily+"]"+ e);
//        } finally {
//            try {
//                if (table != null)
//                    table.close();
//                relaseHconneciton();
//            } catch (Exception ex) {
//
//            }
//
//        }
//        return resultList;
//    }
//
//    /**
//     * 分页查询
//     */
//    public List<List<Map<String, String>>> getMutliResultByPageFilter(String tableName, Integer size, Integer rowNum) {
//
//        List<List<Map<String, String>>> dataList = null;
//        HTable table = null;
//        try {
//            table = (HTable) connection.getTable(TableName.valueOf(tableName));
//            Scan scan = new Scan();
//            scan.setCaching(size);
//
//            Filter filter = new PageFilter(rowNum);
//            scan.setFilter(filter);
//
//            ResultScanner scanner = table.getScanner(scan);
//            Iterator<Result> results = scanner.iterator();
//            if (results != null)
//                dataList = new ArrayList<List<Map<String, String>>>();
//            while (results.hasNext()) {
//                Result result = results.next();
//                List<Map<String, String>> rowCells = new ArrayList<Map<String, String>>();
//                for (Cell cell : result.rawCells()) {
//                    Map<String, String> map = new HashMap<String, String>();
//                    map.put(ICommConstanUtil.HBASE_COLUMN_ROW_KEY, Bytes.toString(result.getRow()));
//                    map.put(ICommConstanUtil.HBASE_COLUMN_FAMILY, Bytes.toString(CellUtil.cloneFamily(cell)));
//                    map.put(ICommConstanUtil.HBASE_COLUMN_QUALIFIER, Bytes.toString(CellUtil.cloneQualifier(cell)));
//                    map.put(ICommConstanUtil.HBASE_COLUMN_VALUE, Bytes.toString(CellUtil.cloneValue(cell)));
//                    rowCells.add(map);
//                }
//                dataList.add(rowCells);
//            }
//        } catch (IOException e) {
//            logger.error("Page Filter query is error,  ["+tableName+"]"+ e);
//        } finally {
//            try {
//                if (table != null)
//                    table.close();
//                relaseHconneciton();
//            } catch (Exception ex) {
//                logger.error("close  ["+tableName+"]"+ ex);
//            }
//
//        }
//        return dataList;
//    }
//
//    /**
//     * 删除一行
//     */
//    public void deleteCFByRowKey(String tableName, String rowKey, String falilyName, String columnName) {
//        HTable table = null;
//        try {
//            table = (HTable) connection.getTable(TableName.valueOf(tableName));
//            Delete deleteColumn = new Delete(Bytes.toBytes(rowKey));
//            deleteColumn.addColumns(Bytes.toBytes(falilyName), Bytes.toBytes(columnName));
//            table.delete(deleteColumn);
//            logger.info(falilyName + ":" + columnName + " is deleted!");
//        } catch (Exception e) {
//            logger.error("delete "+rowKey +" from  ["+tableName+":"+ columnName+"]"+ e);
//        }
//
//    }
//
//    /**
//     * 删除一行所有的列族
//     */
//    public void deleteAllCFByRowKey(String tableName, String rowKey) {
//        HTable table = null;
//        try {
//            table = (HTable) connection.getTable(TableName.valueOf(tableName));
//            Delete deleteColumn = new Delete(Bytes.toBytes(rowKey));
//            table.delete(deleteColumn);
//            logger.info("all cf is deleted!");
//        } catch (Exception e) {
//            logger.error("delete" + rowKey + " all columns ["+tableName+"]"+ e);
//        }
//    }
//
//}

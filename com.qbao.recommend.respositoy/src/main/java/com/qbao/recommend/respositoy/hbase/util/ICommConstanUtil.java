package com.qbao.recommend.respositoy.hbase.util;

/**
 * HBASE用到的常量
 * 
 * @author 贾红平
 *
 */
public interface ICommConstanUtil {
    /**
     * 行健
     */
    public static final String HBASE_COLUMN_ROW_KEY = "rowkey";
    
    /**
     * 列族
     */
    public static final String HBASE_COLUMN_FAMILY = "family";
   
    /**
     * 列
     */
    public static final String HBASE_COLUMN_QUALIFIER = "qualifier";
    
    /**
     * 列值
     */
    public static final String HBASE_COLUMN_VALUE = "value";
    
    /**
     * 列族+列
     */
    public static final String HBASE_COLUMN_FAMILY_QUALIFIER = HBASE_COLUMN_FAMILY + ":" + HBASE_COLUMN_QUALIFIER;

}

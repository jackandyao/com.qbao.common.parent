/**
 * 
 */
package com.qbao.recommend.stream.cmp.handler;

import java.text.SimpleDateFormat;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.qbao.recommend.stream.cmp.parser.KafkaParser;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */

public interface IHandler {

    public Logger kafkaInfoLogger = LoggerManagerUtil.getLogger(LogNameEnum.kafka, Level.INFO);
    public Logger kafkaWarnLogger = LoggerManagerUtil.getLogger(LogNameEnum.kafka, Level.WARN);
    public Logger kafkaErrorLogger = LoggerManagerUtil.getLogger(LogNameEnum.kafka, Level.ERROR);
    public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public boolean process(String message);

    public void init();

    public KafkaParser<?> getParser() ;

    /**
     * @param parser
     * the parser to set
     */
    public void setParser(KafkaParser<?> parser) ;

}

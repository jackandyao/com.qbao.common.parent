/**
 * 
 */
package com.qbao.recommend.util.log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Appender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import com.qbao.recommend.util.enums.LogNameEnum;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
public class LoggerManagerUtil {

    public static final String FILE_EXTENSION = ".log";

    /** A map of all created logs */
    private static final Map<String, Logger> logCache = new HashMap<String, Logger>();

    private LoggerManagerUtil() {
    }

    public static Logger getLogger(LogNameEnum logNameEnum, Level level) {
        String key = getLogKey(logNameEnum, level);
        Logger logger = logCache.get(key);
        // Create a new one
        if (logger == null) {
            logger = Logger.getLogger(key);
            logger.setLevel(level);
            Appender appender = createDailyRollingFileAppender(key);
            logger.addAppender(appender);
            // Add to log cache
            logCache.put(key, logger);
        }
        // Return the logger
        return logger;
    }

    private static Appender createDailyRollingFileAppender(String key) {
        PatternLayout layout = new PatternLayout();
        layout.setConversionPattern("%d{yyyy-MM-dd HH:mm:ss}\t%m%n");
        String datePattern = "'.'yyyy-MM-dd";
        String logFile = getLogFilePath(key);
        DailyRollingFileAppender appender = null;
        try {
            appender = new DailyRollingFileAppender(layout, logFile, datePattern);
            appender.setAppend(true);
        } catch (IOException e) {
            System.err.println(ExceptionUtils.getMessage(e));
        }

        return appender;
    }

    private static String getLogKey(LogNameEnum logNameEnum, Level leve) {
        return StringUtils.lowerCase(logNameEnum + "_" + leve);
    }

    private static String getLogFilePath(String key) {
        return "log/" + key + FILE_EXTENSION;
    }

    public static void main(String[] args) throws IOException {
        Logger info = LoggerManagerUtil.getLogger(LogNameEnum.guess_you, Level.INFO);
        Logger warn = LoggerManagerUtil.getLogger(LogNameEnum.guess_you, Level.WARN);
        Logger debug = LoggerManagerUtil.getLogger(LogNameEnum.look_again, Level.DEBUG);
        info.info("test logger info");
        warn.warn("test logger warn");
        debug.debug("test logger debug");
        System.out.println("done");
    }
}

/**
 * 
 */
package com.qbao.recommend.stream.cmp.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.qbao.recommend.stream.cmp.domain.nginx.Record;
import com.qbao.recommend.stream.cmp.enums.EventType;
import com.qbao.recommend.stream.cmp.enums.TopicType;
import com.qbao.recommend.util.enums.LogNameEnum;
import com.qbao.recommend.util.log.LoggerManagerUtil;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-05 18:26:32 +0800 (Mon, 05 Sep 2016) $
 * $LastChangedRevision: 896 $
 * $LastChangedBy: jiahongping $
 */
public class NginxParser extends KafkaParser<Record> {
    private Logger kafkaInfoLogger = LoggerManagerUtil.getLogger(LogNameEnum.kafka, Level.INFO);
    private Logger kafkaWarnLogger = LoggerManagerUtil.getLogger(LogNameEnum.kafka, Level.WARN);
    private static Pattern userIdPattern = Pattern.compile("uid=(\\d+)");
    private static Pattern spuIdPattern = Pattern.compile("spuId=(\\d+)");
    private static Pattern baoGouIdPattern = Pattern.compile("(\\d+).html");
    private static Pattern bcPattern = Pattern.compile("bc.qbao.com");

    public NginxParser(TopicType topicType) {
        super(topicType);
    }

    public NginxParser() {
    }

    @Override
    public Record parse(String line) {
        Record record = null;
        if (StringUtils.isNotBlank(line)) {
            boolean isBaoGou = bcPattern.matcher(line).find();
            logger.info("It is parsing the log is bao gou = " + isBaoGou);
            Matcher userIdMatcher = userIdPattern.matcher(line);
            if (userIdMatcher.find()) {
                String userId = StringUtils.trimToEmpty(userIdMatcher.group(1));
                Matcher goodIdMatcher = (isBaoGou) ? baoGouIdPattern.matcher(line) : spuIdPattern.matcher(line);
                if (goodIdMatcher.find()) {
                    String goodsId = StringUtils.trimToEmpty(goodIdMatcher.group(1));
                    kafkaInfoLogger.info(userId + "\t" + goodsId);
                    record = new Record(userId, goodsId, this.getEventType(), getTopicType(), isBaoGou);
                }
            }
        }
        return record;
    }

    @Override
    public EventType getEventType() {
        return EventType.CLICK;
    }

}

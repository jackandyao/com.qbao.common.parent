package com.qbao.recommend.respositoy.mysql.util;
import java.text.ParseException;
import java.util.Date;
import org.apache.commons.lang3.time.FastDateFormat;

/**
 * @author	yuandongrui
 * @date 	2016年7月1日
 */
public class DateUtil {
	public final static FastDateFormat format = FastDateFormat.getInstance("yyyy-MM-dd");
	public final static FastDateFormat format2 =FastDateFormat.getInstance("yyyy:MM:dd:HH:mm:ss");
	public final static FastDateFormat format3 = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
	//FastDateFormat
	/**
	 * 获取天天最后一毫秒的时间
	 * @return
	 * @throws ParseException
	 */
	public static String getDateLastTime() throws ParseException{
		Date d=new Date();
		String str=format.format(d);
		Date d2=format.parse(str);
		int dayMis=1000*60*60*24;//一天的毫秒-1
		//返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
		long curMillisecond=d2.getTime();//当天的毫秒
		long resultMis=curMillisecond+(dayMis-1);
		//得到我需要的时间    当天最后一秒
		Date resultDate=new Date(resultMis);
		return format2.format(resultDate);
	}
	
	public static void main(String[] args) throws ParseException {
		String dateLastTime = getDateLastTime();
		System.out.println(dateLastTime);
	}
}

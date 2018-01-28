package com.qbao.recommend.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * @author 贾红平
 *
 */
public class DateUtil {
	
	
	
	/**
	 * 日期转换为字符串
	 * @param date
	 * @return
	 */
	public static String parseDateSToStr(Date date){
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 字符串转换为日期
	 * @param str
	 * @return
	 */
	public static Date parseStrToDate(String str){
		if (str!=null && !str.equals("")) {
			try {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return sdf.parse(str);
			} catch (Exception e) {
				System.out.println("无法把空字符串的值转换为日期格式!");
			}
		}
		return null;
	}
}

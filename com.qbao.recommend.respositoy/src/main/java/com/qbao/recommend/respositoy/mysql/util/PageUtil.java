package com.qbao.recommend.respositoy.mysql.util;

import java.util.List;

/**
 * @author	yuandongrui
 * @date 	2016年7月1日
 */
public class PageUtil {
	public static List<Long> getPage(List<Long> list, int page, int pagesize) {
		if(page > list.size()/pagesize){
			if (list.size()%pagesize == 0)
				page = list.size()/pagesize;
			else
				page = list.size()/pagesize+1;
		}
		int totalcount = list.size();
		int pagecount = 0;
		int m = totalcount % pagesize;
		if (m > 0) {
			pagecount = totalcount / pagesize + 1;
		} else {
			pagecount = totalcount / pagesize;
		}
		if (m == 0) {
			List<Long> subList = list.subList((page - 1) * pagesize, pagesize * (page));
			return subList;
		} else {
			if (page == pagecount) {
				List<Long> subList = list.subList((page - 1) * pagesize, totalcount);
				return subList;
			} else {
				List<Long> subList = list.subList((page - 1) * pagesize, pagesize * (page));
				return subList;
			}
		}
	}
}

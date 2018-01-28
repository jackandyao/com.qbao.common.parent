package com.qbao.recommend.business.baoyue.cmp.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

public class BaoyueCache {

	public static Map<String,List<String>> baoyueDirList = Maps.newHashMap();
	public static Map<Long,String> spuIdDirIdMap = Maps.newHashMap();
	public static Map<String,String> topic = new HashMap<String,String>();
}

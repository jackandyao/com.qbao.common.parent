package com.qbao.recommend.respositoy.mysql.service;


public interface ILookAgainAndBuyService {
	
	public String findLookAgainBySpuIdAndType(long spuId, int type);
	public String findLookBuyBySpuIdAndType(long spuId, int type);
}
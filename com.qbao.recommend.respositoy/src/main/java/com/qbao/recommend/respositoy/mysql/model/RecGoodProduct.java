package com.qbao.recommend.respositoy.mysql.model;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class RecGoodProduct implements Serializable{

	private static final long serialVersionUID = "$Id$".hashCode();
	private long spuId;
	private String dirId;
	private int sellNum;
	private int userNum;
	private int arriveTime;
	private String snDailyDetail;
	private int snThisMonth;
	private int snLastMonth;
	private String rank;
	private Date updateTime;

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public long getSpuId() {
		return spuId;
	}
	public void setSpuId(long spuId) {
		this.spuId = spuId;
	}
	public String getDirId() {
		return dirId;
	}
	public void setDirId(String dirId) {
		this.dirId = dirId;
	}
	public int getSellNum() {
		return sellNum;
	}
	public void setSellNum(int sellNum) {
		this.sellNum = sellNum;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public int getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(int arriveTime) {
		this.arriveTime = arriveTime;
	}
	public String getSnDailyDetail() {
		return snDailyDetail;
	}
	public void setSnDailyDetail(String snDailyDetail) {
		this.snDailyDetail = snDailyDetail;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public int getSnThisMonth() {
		return snThisMonth;
	}
	public void setSnThisMonth(int snThisMonth) {
		this.snThisMonth = snThisMonth;
	}
	public int getSnLastMonth() {
		return snLastMonth;
	}
	public void setSnLastMonth(int snLastMonth) {
		this.snLastMonth = snLastMonth;
	}

	public String calRePurchaseRate(){
		double rePurchaseRate = 0.0d;
		if(sellNum>0){
			rePurchaseRate = (((sellNum-userNum)*10000/sellNum)/100.0);
		}
		return rePurchaseRate+"%";
	}
	
	public String calSoldRate(){
		double soldRate = 0.0d;
		if(snLastMonth==0){
			if(snThisMonth>0) soldRate = 100.00d;
		} else {
			soldRate = (((snThisMonth-snLastMonth)*10000/snLastMonth)/100.0);
		}
		return soldRate+"%";
	}
	
	public List<Map<String,Object>> calSellTrend(){
		List<Map<String,Object>> list = Lists.newArrayList();
		String[] detailArray = snDailyDetail.split(",");
		int index = 0;
		for(String daily : detailArray){
			Map<String,Object> map = Maps.newHashMap();
			String[] detail = daily.split(":");
			map.put("date", detail[0]);
			if(index==0){
				map.put("selfValue", 0.00);
				map.put("kindValue", 0.00);
			} else {
				String dailyLast = detailArray[index-1];
				String[] detailLast = dailyLast.split(":");
				int selfDaily = Integer.parseInt(detail[1]);
				int selfDailyLast = Integer.parseInt(detailLast[1]);
				int kindDaily = Integer.parseInt(detail[2]);
				int kindDailyLast = Integer.parseInt(detailLast[2]);
				double selfValue = 0.00;
				if(selfDailyLast==0) {
					if(selfDaily>0) selfValue = 100.00;
				} else {
					selfValue = ((selfDaily-selfDailyLast)*10000/selfDailyLast)/100.0;
				}
				double kindValue = 0.00;
				if(kindDailyLast==0) {
					if(kindDaily>0) kindValue = 100.00;
				} else {
					kindValue = ((kindDaily-kindDailyLast)*10000/kindDailyLast)/100.0;
				}
				map.put("selfValue", selfValue);
				map.put("kindValue", kindValue);
			}
			
			list.add(map);
			index++;
		}
		return list;
	}
	
	public List<Map<String,Object>> calReport(){
		List<Map<String,Object>> list = Lists.newArrayList();
		String[] ranks = rank.split("\\D+");
		String totalRank = ranks[ranks.length-1];
		for(int i=0;i<ranks.length/2;i++){
			Map<String,Object> map = Maps.newHashMap();
			if(i==0) {
				map.put("timeArea", "近一周");
			}else if(i==1){
				map.put("timeArea", "近一月");
			} else if(i==2){
				map.put("timeArea", "近三月");
			} else if(i==3){
				map.put("timeArea", "近六月");
			} else if(i==4){
				map.put("timeArea", "近一年");
			}
			map.put("tendency", Integer.parseInt(ranks[2*i])>Integer.parseInt(ranks[2*i+1])?0:1);
			map.put("rankingChange", Math.abs(Integer.parseInt(ranks[2*i])-Integer.parseInt(ranks[2*i+1])));
			map.put("kindredRanking", ranks[2*i]+"/"+totalRank);
			list.add(map);
		}
		return list;
	}
	
}

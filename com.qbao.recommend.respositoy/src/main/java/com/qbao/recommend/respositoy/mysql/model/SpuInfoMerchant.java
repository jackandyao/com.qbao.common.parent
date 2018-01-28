package com.qbao.recommend.respositoy.mysql.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * 微商产品信息model
 * 
 * @author yuandongrui
 * @Date 2016-06-21
 *
 */
public class SpuInfoMerchant implements Serializable{
	// 商品spu id
	private long spuId;
	// 商品目录
	private String dirId;
	// 用户ID
	private long userId;
	// 用户名称
	private String userName;
	// 商品名称
	private String spuName;
	// spu显示价格，用于搜索按价格排序
	private long viewPrice;
	// 商品封面图(文件存储地址)
	private String mainImg;
	// 软文，商品卖点，原desc
	private String advertorial;
	// 关键字
	private String keyword;
	// 图文详情
	private String detailDesc;
	// 1：上架 2：下架 3: 删除
	private int publishStatus;
	// 1：待审核 2：审核通过 3： 审核不通过 4 审核通过，最好人工检查下（针对先发后审情况）
	private int auditStatus;
	// 二维码生产图片保存目录
	private String qrcodePath;
	// 汇总后的spu总销量
	private long sellCountAggregated;
	// 0普通商家、1个人认证商家、2、企业商家、3个人假一罚十、4金牌商家
	private int accountType;
	
	private int spuThumb;//点赞数
	
	private int tagKeyDirectory;//目录级别

	private int favoriteNum;// 收藏数

	private String tagName; //标签

	private int reserveCount; //库存量
	public int getFavoriteNum() {
		return favoriteNum;
	}

	public void setFavoriteNum(int favoriteNum) {
		this.favoriteNum = favoriteNum;
	}

	public int getSpuThumb() {
		return spuThumb;
	}

	public void setSpuThumb(int spuThumb) {
		this.spuThumb = spuThumb;
	}

	public long getSpuId() {
		return spuId;
	}

	public void setSpuId(long spuId) {
		this.spuId = spuId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSpuName() {
		return spuName;
	}

	public void setSpuName(String spuName) {
		this.spuName = spuName;
	}

	public long getViewPrice() {
		return viewPrice;
	}

	public void setViewPrice(long viewPrice) {
		this.viewPrice = viewPrice;
	}

	public String getMainImg() {
		return mainImg;
	}

	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}

	public String getAdvertorial() {
		return advertorial;
	}

	public void setAdvertorial(String advertorial) {
		this.advertorial = advertorial;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDetailDesc() {
		return detailDesc;
	}

	public void setDetailDesc(String detailDesc) {
		this.detailDesc = detailDesc;
	}

	public int getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(int publishStatus) {
		this.publishStatus = publishStatus;
	}

	public int getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(int auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getQrcodePath() {
		return qrcodePath;
	}

	public void setQrcodePath(String qrcodePath) {
		this.qrcodePath = qrcodePath;
	}

	public long getSellCountAggregated() {
		return sellCountAggregated;
	}

	public void setSellCountAggregated(long sellCountAggregated) {
		this.sellCountAggregated = sellCountAggregated;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public String getDirId() {
		return dirId;
	}

	public void setDirId(String dirId) {
		this.dirId = dirId;
	}

	public int getTagKeyDirectory() {
		return tagKeyDirectory;
	}

	public void setTagKeyDirectory(int tagKeyDirectory) {
		this.tagKeyDirectory = tagKeyDirectory;
	}

	public String getTagName() {
		return tagName;
	}

	public SpuInfoMerchant setTagName(String tagName) {
		this.tagName = tagName;
		return this;
	}

	public int getReserveCount() {
		return reserveCount;
	}

	public SpuInfoMerchant setReserveCount(int reserveCount) {
		this.reserveCount = reserveCount;
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("spuId", spuId)
				.append("dirId", dirId)
				.append("userId", userId)
				.append("userName", userName)
				.append("spuName", spuName)
				.append("viewPrice", viewPrice)
				.append("mainImg", mainImg)
				.append("advertorial", advertorial)
				.append("keyword", keyword)
				.append("detailDesc", detailDesc)
				.append("publishStatus", publishStatus)
				.append("auditStatus", auditStatus)
				.append("qrcodePath", qrcodePath)
				.append("sellCountAggregated", sellCountAggregated)
				.append("accountType", accountType)
				.append("spuThumb", spuThumb)
				.append("tagKeyDirectory", tagKeyDirectory)
				.append("favoriteNum", favoriteNum)
				.append("tagName", tagName)
				.append("reserveCount", reserveCount)
				.toString();
	}
}

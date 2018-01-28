package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;
import java.util.Date;
/**
 * 宝购产品信息 model
 * @author shuaizhihu
 * @Date 2016-04-12
 *
 */
public class SpuInfoBaogou implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7218139572066257905L;
	
	//	PK
	private long id;
//	商品名称
	private String name;
//	项目类型：1.股权众筹，2.阶梯式团购，3.一口价团
	private int type;
//	可否超额：0-否，1-是
	private int isExcess;
//	状态：0-待审核，1-待售，2-在售，3-售罄，4-下架，7-已经结束
	private String state;
//	核准时间（预留）
	private Date checkTime;
//	开始时间
	private Date beginTime;
//	宝筹认筹结束时间
	private Date endTime;
//	商品到期时间
	private Date validTime;
//	预筹金额
	private long totalMoney;
//	每份金额
	private int eachMoneyBak;
//	总份额
	private int totalNum;
//	个人最低起购份额
	private int minNum;
//	个人最高起购份额
	private int maxNum;
//	收益类型：0-浮动收益，1-固定收益，2-动+固定收益，3-服务收益，4-实物收益
	private int incomeType;
//	收益率
	private String incomeRatio;
//	第三方托管
	private String thirdParty;
//	描述
	private String description;
//	艺术品介绍
	private String content;
//	推荐显示：0-否，1-是
	private int isRecommend;
//	热门显示：0-否，1-是
	private int isHot;
//	创建用户名
	private String createUser;
//	创建时间
	private Date createTime;
//	修改用户名
	private String modifyUser;
//	修改时间
	private Date modifyTime;
//	商家id
	private long shopId;
//	商家名称
	private String shopName;
//	商品系统，id
	private long spuId;
//	商品型号id
	private long skuId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getIsExcess() {
		return isExcess;
	}
	public void setIsExcess(int isExcess) {
		this.isExcess = isExcess;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getValidTime() {
		return validTime;
	}
	public void setValidTime(Date validTime) {
		this.validTime = validTime;
	}
	public long getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(long totalMoney) {
		this.totalMoney = totalMoney;
	}
	public int getEachMoneyBak() {
		return eachMoneyBak;
	}
	public void setEachMoneyBak(int eachMoneyBak) {
		this.eachMoneyBak = eachMoneyBak;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public int getMinNum() {
		return minNum;
	}
	public void setMinNum(int minNum) {
		this.minNum = minNum;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	public int getIncomeType() {
		return incomeType;
	}
	public void setIncomeType(int incomeType) {
		this.incomeType = incomeType;
	}
	public String getIncomeRatio() {
		return incomeRatio;
	}
	public void setIncomeRatio(String incomeRatio) {
		this.incomeRatio = incomeRatio;
	}
	public String getThirdParty() {
		return thirdParty;
	}
	public void setThirdParty(String thirdParty) {
		this.thirdParty = thirdParty;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIsRecommend() {
		return isRecommend;
	}
	public void setIsRecommend(int isRecommend) {
		this.isRecommend = isRecommend;
	}
	public int getIsHot() {
		return isHot;
	}
	public void setIsHot(int isHot) {
		this.isHot = isHot;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getModifyUser() {
		return modifyUser;
	}
	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public long getShopId() {
		return shopId;
	}
	public void setShopId(long shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public long getSpuId() {
		return spuId;
	}
	public void setSpuId(long spuId) {
		this.spuId = spuId;
	}
	public long getSkuId() {
		return skuId;
	}
	public void setSkuId(long skuId) {
		this.skuId = skuId;
	}
	
	
	
}

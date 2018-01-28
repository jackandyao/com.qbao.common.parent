package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;
import java.util.Date;

public class AgentTask implements Serializable {

    private static final long serialVersionUID = "$Id: AgentTask.java 1510 2016-12-05 10:53:02Z wangping $".hashCode();
    private Long id;

    private String taskName;

    private Integer stock;

    private Long shopId;

    private String shopName;

    private Date createTime;

    private Date modifyTime;

    private Date onlineTime;

    private Date offlineTime;

    private Integer weight;

    private Integer receiveCount;

    private Double joinFee;

    private Double penalty;

    private Double rmbSubsidy;

    private Integer bqSubsidy;

    private Double rmbOnetime;

    private Integer bqOnetime;

    private Double rmbDaily;

    private Integer bqDaily;

    private Integer studySecond;

    private String videoId;

    private Integer videoSecond;

    private Integer taskCycle;

    private Integer validCycle;

    private int status;

    private String logoBigUrl;

    private String logoSmallUrl;

    private String campaignUrl;

    private String goods;

    private String problems;

    private Long packageId;

    private String reason;

    private Date auditTime;

    private String taskDesc;

    private int taskType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    public Date getOfflineTime() {
        return offlineTime;
    }

    public void setOfflineTime(Date offlineTime) {
        this.offlineTime = offlineTime;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getReceiveCount() {
        return receiveCount;
    }

    public void setReceiveCount(Integer receiveCount) {
        this.receiveCount = receiveCount;
    }

    public Double getJoinFee() {
        return joinFee;
    }

    public void setJoinFee(Double joinFee) {
        this.joinFee = joinFee;
    }

    public Double getPenalty() {
        return penalty;
    }

    public void setPenalty(Double penalty) {
        this.penalty = penalty;
    }

    public Double getRmbSubsidy() {
        return rmbSubsidy;
    }

    public void setRmbSubsidy(Double rmbSubsidy) {
        this.rmbSubsidy = rmbSubsidy;
    }

    public Integer getBqSubsidy() {
        return bqSubsidy;
    }

    public void setBqSubsidy(Integer bqSubsidy) {
        this.bqSubsidy = bqSubsidy;
    }

    public Double getRmbOnetime() {
        return rmbOnetime;
    }

    public void setRmbOnetime(Double rmbOnetime) {
        this.rmbOnetime = rmbOnetime;
    }

    public Integer getBqOnetime() {
        return bqOnetime;
    }

    public void setBqOnetime(Integer bqOnetime) {
        this.bqOnetime = bqOnetime;
    }

    public Double getRmbDaily() {
        return rmbDaily;
    }

    public void setRmbDaily(Double rmbDaily) {
        this.rmbDaily = rmbDaily;
    }

    public Integer getBqDaily() {
        return bqDaily;
    }

    public void setBqDaily(Integer bqDaily) {
        this.bqDaily = bqDaily;
    }

    public Integer getStudySecond() {
        return studySecond;
    }

    public void setStudySecond(Integer studySecond) {
        this.studySecond = studySecond;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }

    public Integer getVideoSecond() {
        return videoSecond;
    }

    public void setVideoSecond(Integer videoSecond) {
        this.videoSecond = videoSecond;
    }

    public Integer getTaskCycle() {
        return taskCycle;
    }

    public void setTaskCycle(Integer taskCycle) {
        this.taskCycle = taskCycle;
    }

    public Integer getValidCycle() {
        return validCycle;
    }

    public void setValidCycle(Integer validCycle) {
        this.validCycle = validCycle;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLogoBigUrl() {
        return logoBigUrl;
    }

    public void setLogoBigUrl(String logoBigUrl) {
        this.logoBigUrl = logoBigUrl == null ? null : logoBigUrl.trim();
    }

    public String getLogoSmallUrl() {
        return logoSmallUrl;
    }

    public void setLogoSmallUrl(String logoSmallUrl) {
        this.logoSmallUrl = logoSmallUrl == null ? null : logoSmallUrl.trim();
    }

    public String getCampaignUrl() {
        return campaignUrl;
    }

    public void setCampaignUrl(String campaignUrl) {
        this.campaignUrl = campaignUrl == null ? null : campaignUrl.trim();
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods == null ? null : goods.trim();
    }

    public String getProblems() {
        return problems;
    }

    public void setProblems(String problems) {
        this.problems = problems == null ? null : problems.trim();
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc == null ? null : taskDesc.trim();
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }
}
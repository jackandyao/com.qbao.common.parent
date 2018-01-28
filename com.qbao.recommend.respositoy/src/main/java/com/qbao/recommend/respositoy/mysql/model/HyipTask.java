/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-14 14:47:40 +0800 (Wed, 14 Sep 2016) $
 * $LastChangedRevision: 1024 $
 * $LastChangedBy: wangping $
 */
public class HyipTask implements Serializable {

    private static final long serialVersionUID = "$Id: HyipTask.java 1024 2016-09-14 06:47:40Z wangping $".hashCode();
    private long id;
    private String task_name;
    private long margins;
    private long total_reward;
    private long penalty;
    private int total_num;
    private int one_day_num;
    private int days;
    private int show_time;
    private String mobile_description;
    private int star_num;
    private String task_type;
    private int task_count;
    private int task_seq;
    private int active_flag;
    private int coupon_id;
    private int is_new;
    private int ads_type;
    private String video_url;
    private int business_circles_id;
    private int is_abnormal;
    private String cpa_url;
    private String cpa_img_url;
    private int partner_id;
    private String publish_channel;
    private int stock;
    private int auditer;
    private String y_reject;
    private int partner_user_id;
    private int is_recommend_task;

    public String getTaskName() {
        return task_name;
    }

    public void setTaskName(String task_name) {
        this.task_name = task_name;
    }

    public long getMargins() {
        return margins;
    }

    public void setMargins(long margins) {
        this.margins = margins;
    }

    public long getTotalReward() {
        return total_reward;
    }

    public void setTotalReward(long total_reward) {
        this.total_reward = total_reward;
    }

    public long getPenalty() {
        return penalty;
    }

    public void setPenalty(long penalty) {
        this.penalty = penalty;
    }

    public int getTotalNum() {
        return total_num;
    }

    public void setTotalNum(int totalNum) {
        this.total_num = totalNum;
    }

    public int getOneDayNum() {
        return one_day_num;
    }

    public void setOneDayNum(int oneDayNum) {
        this.one_day_num = oneDayNum;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getShowTime() {
        return show_time;
    }

    public void setShowTime(int show_time) {
        this.show_time = show_time;
    }

    public String getMobileDescription() {
        return mobile_description;
    }

    public void setMobileDescription(String mobile_description) {
        this.mobile_description = mobile_description;
    }

    public int getStarNum() {
        return star_num;
    }

    public void setStarNum(int star_num) {
        this.star_num = star_num;
    }

    public String getTaskType() {
        return task_type;
    }

    public void setTaskType(String task_type) {
        this.task_type = task_type;
    }

    public int getTaskCount() {
        return task_count;
    }

    public void setTaskCount(int task_count) {
        this.task_count = task_count;
    }

    public int getTaskSeq() {
        return task_seq;
    }

    public void setTaskSeq(int task_seq) {
        this.task_seq = task_seq;
    }

    public int getActiveFlag() {
        return active_flag;
    }

    public void setActiveFlag(int active_flag) {
        this.active_flag = active_flag;
    }

    public int getCouponId() {
        return coupon_id;
    }

    public void setCouponId(int coupon_id) {
        this.coupon_id = coupon_id;
    }

    public int getIsNew() {
        return is_new;
    }

    public void setIsNew(int is_new) {
        this.is_new = is_new;
    }

    public int getAdsType() {
        return ads_type;
    }

    public void setAdsType(int ads_type) {
        this.ads_type = ads_type;
    }

    public String getVideoUrl() {
        return video_url;
    }

    public void setVideoUrl(String video_url) {
        this.video_url = video_url;
    }

    public int getBusinessCirclesId() {
        return business_circles_id;
    }

    public void setBusinessCirclesId(int business_circles_id) {
        this.business_circles_id = business_circles_id;
    }

    public int getIsAbnormal() {
        return is_abnormal;
    }

    public void setIsAbnormal(int is_abnormal) {
        this.is_abnormal = is_abnormal;
    }

    public String getCpaUrl() {
        return cpa_url;
    }

    public void setCpaUrl(String cpa_url) {
        this.cpa_url = cpa_url;
    }

    public String getCpaImgUrl() {
        return cpa_img_url;
    }

    public void setCpaImgUrl(String cpa_img_url) {
        this.cpa_img_url = cpa_img_url;
    }

    public int getPartnerId() {
        return partner_id;
    }

    public void setPartnerId(int partner_id) {
        this.partner_id = partner_id;
    }

    public String getPublishChannel() {
        return publish_channel;
    }

    public void setPublishChannel(String publish_channel) {
        this.publish_channel = publish_channel;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getAuditer() {
        return auditer;
    }

    public void setAuditer(int auditer) {
        this.auditer = auditer;
    }

    public String getYReject() {
        return y_reject;
    }

    public void setYReject(String y_reject) {
        this.y_reject = y_reject;
    }

    public int getPartnerUserId() {
        return partner_user_id;
    }

    public void setPartnerUserId(int partner_user_id) {
        this.partner_user_id = partner_user_id;
    }

    public int getIsRecommendTask() {
        return is_recommend_task;
    }

    public void setIsRecommendTask(int is_recommend_task) {
        this.is_recommend_task = is_recommend_task;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id
     * the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "HyipTask [id=" + id + ", task_name=" + task_name + ", margins=" + margins + ", total_reward=" + total_reward + ", penalty=" + penalty + ", total_num=" + total_num + ", one_day_num=" + one_day_num + ", days=" + days + "active_flag=" + active_flag + ", show_time=" + show_time + "]";
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + active_flag;
        result = prime * result + ads_type;
        result = prime * result + auditer;
        result = prime * result + business_circles_id;
        result = prime * result + coupon_id;
        result = prime * result + ((cpa_img_url == null) ? 0 : cpa_img_url.hashCode());
        result = prime * result + ((cpa_url == null) ? 0 : cpa_url.hashCode());
        result = prime * result + days;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + is_abnormal;
        result = prime * result + is_new;
        result = prime * result + is_recommend_task;
        result = prime * result + (int) (margins ^ (margins >>> 32));
        result = prime * result + ((mobile_description == null) ? 0 : mobile_description.hashCode());
        result = prime * result + one_day_num;
        result = prime * result + partner_id;
        result = prime * result + partner_user_id;
        result = prime * result + (int) (penalty ^ (penalty >>> 32));
        result = prime * result + ((publish_channel == null) ? 0 : publish_channel.hashCode());
        result = prime * result + show_time;
        result = prime * result + star_num;
        result = prime * result + stock;
        result = prime * result + task_count;
        result = prime * result + ((task_name == null) ? 0 : task_name.hashCode());
        result = prime * result + task_seq;
        result = prime * result + ((task_type == null) ? 0 : task_type.hashCode());
        result = prime * result + total_num;
        result = prime * result + (int) (total_reward ^ (total_reward >>> 32));
        result = prime * result + ((video_url == null) ? 0 : video_url.hashCode());
        result = prime * result + ((y_reject == null) ? 0 : y_reject.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HyipTask other = (HyipTask) obj;
        if (active_flag != other.active_flag)
            return false;
        if (ads_type != other.ads_type)
            return false;
        if (auditer != other.auditer)
            return false;
        if (business_circles_id != other.business_circles_id)
            return false;
        if (coupon_id != other.coupon_id)
            return false;
        if (cpa_img_url == null) {
            if (other.cpa_img_url != null)
                return false;
        } else if (!cpa_img_url.equals(other.cpa_img_url))
            return false;
        if (cpa_url == null) {
            if (other.cpa_url != null)
                return false;
        } else if (!cpa_url.equals(other.cpa_url))
            return false;
        if (days != other.days)
            return false;
        if (id != other.id)
            return false;
        if (is_abnormal != other.is_abnormal)
            return false;
        if (is_new != other.is_new)
            return false;
        if (is_recommend_task != other.is_recommend_task)
            return false;
        if (margins != other.margins)
            return false;
        if (mobile_description == null) {
            if (other.mobile_description != null)
                return false;
        } else if (!mobile_description.equals(other.mobile_description))
            return false;
        if (one_day_num != other.one_day_num)
            return false;
        if (partner_id != other.partner_id)
            return false;
        if (partner_user_id != other.partner_user_id)
            return false;
        if (penalty != other.penalty)
            return false;
        if (publish_channel == null) {
            if (other.publish_channel != null)
                return false;
        } else if (!publish_channel.equals(other.publish_channel))
            return false;
        if (show_time != other.show_time)
            return false;
        if (star_num != other.star_num)
            return false;
        if (stock != other.stock)
            return false;
        if (task_count != other.task_count)
            return false;
        if (task_name == null) {
            if (other.task_name != null)
                return false;
        } else if (!task_name.equals(other.task_name))
            return false;
        if (task_seq != other.task_seq)
            return false;
        if (task_type == null) {
            if (other.task_type != null)
                return false;
        } else if (!task_type.equals(other.task_type))
            return false;
        if (total_num != other.total_num)
            return false;
        if (total_reward != other.total_reward)
            return false;
        if (video_url == null) {
            if (other.video_url != null)
                return false;
        } else if (!video_url.equals(other.video_url))
            return false;
        if (y_reject == null) {
            if (other.y_reject != null)
                return false;
        } else if (!y_reject.equals(other.y_reject))
            return false;
        return true;
    }

}
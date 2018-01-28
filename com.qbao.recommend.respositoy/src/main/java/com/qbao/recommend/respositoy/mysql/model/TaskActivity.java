/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-14 14:47:40 +0800 (Wed, 14 Sep 2016) $
 * $LastChangedRevision: 1024 $
 * $LastChangedBy: wangping $
 */
public class TaskActivity implements Comparable<TaskActivity>, Serializable {

    private static final long serialVersionUID = "$Id: TaskActivity.java 1024 2016-09-14 06:47:40Z wangping $".hashCode();
    private long id;
    private String activity_name;
    private String activity_desc;
    private String activity_img_url;
    private String activity_small_img_url;
    private long user_id;
    private String refer_id;
    private Date start_date;
    private Date end_date;
    private int days;
    private int weight;
    private long reward;
    private long extra_reward;
    private long margins;
    private long penalty;
    private int issue_platform;
    private int plan_id;
    private int receive_count;
    private int stock;
    private int cycle_days;
    private int fee;
    private String merchant_name;
    private int total_num;
    private int one_day_num;
    private int frame_num;
    private int frame_time;
    private String video_id;
    private int limit_day_everybody;

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

    public String getActivityName() {
        return activity_name;
    }

    public void setActivityName(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getActivityDesc() {
        return activity_desc;
    }

    public void setActivityDesc(String activity_desc) {
        this.activity_desc = activity_desc;
    }

    public String getActivityImgUrl() {
        return activity_img_url;
    }

    public void setActivityImgUrl(String activity_img_url) {
        this.activity_img_url = activity_img_url;
    }

    public String getActivitySmallImgUrl() {
        return activity_small_img_url;
    }

    public void setActivitySmallImgUrl(String activity_small_img_url) {
        this.activity_small_img_url = activity_small_img_url;
    }

    public long getUserId() {
        return user_id;
    }

    public void setUserId(long user_id) {
        this.user_id = user_id;
    }

    public String getReferId() {
        return refer_id;
    }

    public void setReferId(String refer_id) {
        this.refer_id = refer_id;
    }

    public Date getStartDate() {
        return start_date;
    }

    public void setStartDate(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEndDate() {
        return end_date;
    }

    public void setEndDate(Date end_date) {
        this.end_date = end_date;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public long getReward() {
        return reward;
    }

    public void setReward(long reward) {
        this.reward = reward;
    }

    public long getExtraReward() {
        return extra_reward;
    }

    public void setExtraReward(long extra_reward) {
        this.extra_reward = extra_reward;
    }

    public long getMargins() {
        return margins;
    }

    public void setMargins(long margins) {
        this.margins = margins;
    }

    public long getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public int getIssue_platform() {
        return issue_platform;
    }

    public void setIssue_platform(int issue_platform) {
        this.issue_platform = issue_platform;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public int getReceive_count() {
        return receive_count;
    }

    public void setReceive_count(int receive_count) {
        this.receive_count = receive_count;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCycle_days() {
        return cycle_days;
    }

    public void setCycle_days(int cycle_days) {
        this.cycle_days = cycle_days;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getMerchant_name() {
        return merchant_name;
    }

    public void setMerchant_name(String merchant_name) {
        this.merchant_name = merchant_name;
    }

    public int getTotalNum() {
        return total_num;
    }

    public void setTotalNum(int total_num) {
        this.total_num = total_num;
    }

    public int getOneDayNum() {
        return one_day_num;
    }

    public void setOneDayNum(int one_day_num) {
        this.one_day_num = one_day_num;
    }

    public int getFrameNum() {
        return frame_num;
    }

    public void setFrameNum(int frame_num) {
        this.frame_num = frame_num;
    }

    public int getFrameTime() {
        return frame_time;
    }

    public void setFrameTime(int frame_time) {
        this.frame_time = frame_time;
    }

    public String getVideoId() {
        return video_id;
    }

    public void setVideoId(String video_id) {
        this.video_id = video_id;
    }

    public int getLimitDayEverybody() {
        return limit_day_everybody;
    }

    public void setLimitDayEverybody(int limit_day_everybody) {
        this.limit_day_everybody = limit_day_everybody;
    }


    @Override
    public String toString() {
        return "TaskActivity [id=" + id + ", activity_name=" + activity_name + ", days=" + days + ", reward=" + reward + ", extra_reward=" + extra_reward + ", margins=" + margins + ", penalty=" + penalty + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((activity_desc == null) ? 0 : activity_desc.hashCode());
        result = prime * result + ((activity_img_url == null) ? 0 : activity_img_url.hashCode());
        result = prime * result + ((activity_name == null) ? 0 : activity_name.hashCode());
        result = prime * result + ((activity_small_img_url == null) ? 0 : activity_small_img_url.hashCode());
        result = prime * result + cycle_days;
        result = prime * result + days;
        result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
        result = prime * result + (int) (extra_reward ^ (extra_reward >>> 32));
        result = prime * result + fee;
        result = prime * result + frame_num;
        result = prime * result + frame_time;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + issue_platform;
        result = prime * result + limit_day_everybody;
        result = prime * result + (int) (margins ^ (margins >>> 32));
        result = prime * result + ((merchant_name == null) ? 0 : merchant_name.hashCode());
        result = prime * result + one_day_num;
        result = prime * result + (int) (penalty ^ (penalty >>> 32));
        result = prime * result + plan_id;
        result = prime * result + receive_count;
        result = prime * result + ((refer_id == null) ? 0 : refer_id.hashCode());
        result = prime * result + (int) (reward ^ (reward >>> 32));
        result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
        result = prime * result + stock;
        result = prime * result + total_num;
        result = prime * result + (int) (user_id ^ (user_id >>> 32));
        result = prime * result + ((video_id == null) ? 0 : video_id.hashCode());
        result = prime * result + weight;
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
        TaskActivity other = (TaskActivity) obj;
        if (activity_desc == null) {
            if (other.activity_desc != null)
                return false;
        } else if (!activity_desc.equals(other.activity_desc))
            return false;
        if (activity_img_url == null) {
            if (other.activity_img_url != null)
                return false;
        } else if (!activity_img_url.equals(other.activity_img_url))
            return false;
        if (activity_name == null) {
            if (other.activity_name != null)
                return false;
        } else if (!activity_name.equals(other.activity_name))
            return false;
        if (activity_small_img_url == null) {
            if (other.activity_small_img_url != null)
                return false;
        } else if (!activity_small_img_url.equals(other.activity_small_img_url))
            return false;
        if (cycle_days != other.cycle_days)
            return false;
        if (days != other.days)
            return false;
        if (end_date == null) {
            if (other.end_date != null)
                return false;
        } else if (!end_date.equals(other.end_date))
            return false;
        if (extra_reward != other.extra_reward)
            return false;
        if (fee != other.fee)
            return false;
        if (frame_num != other.frame_num)
            return false;
        if (frame_time != other.frame_time)
            return false;
        if (id != other.id)
            return false;
        if (issue_platform != other.issue_platform)
            return false;
        if (limit_day_everybody != other.limit_day_everybody)
            return false;
        if (margins != other.margins)
            return false;
        if (merchant_name == null) {
            if (other.merchant_name != null)
                return false;
        } else if (!merchant_name.equals(other.merchant_name))
            return false;
        if (one_day_num != other.one_day_num)
            return false;
        if (penalty != other.penalty)
            return false;
        if (plan_id != other.plan_id)
            return false;
        if (receive_count != other.receive_count)
            return false;
        if (refer_id == null) {
            if (other.refer_id != null)
                return false;
        } else if (!refer_id.equals(other.refer_id))
            return false;
        if (reward != other.reward)
            return false;
        if (start_date == null) {
            if (other.start_date != null)
                return false;
        } else if (!start_date.equals(other.start_date))
            return false;
        if (stock != other.stock)
            return false;
        if (total_num != other.total_num)
            return false;
        if (user_id != other.user_id)
            return false;
        if (video_id == null) {
            if (other.video_id != null)
                return false;
        } else if (!video_id.equals(other.video_id))
            return false;
        if (weight != other.weight)
            return false;
        return true;
    }

    @Override
    public int compareTo(TaskActivity o) {
        if (o.getMargins() > getMargins())
            return 1;
        else {
            return -1;
        }
    }

}
/**
 * 
 */
package com.qbao.recommend.business.task.cmp.model.dto;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-12-05 18:53:02 +0800 (Mon, 05 Dec 2016) $
 * $LastChangedRevision: 1510 $
 * $LastChangedBy: wangping $
 */
public class TaskDto {
    /** 任务ID */
    private long taskId;
    /** 任务类型 1： 图片任务类型 2：视频任务类型 3：分享任务类型 4：分销任务类型  5: 特定分销*/
    private int taskType;
    /** 任务名称 */
    private String name;
    /** 任务收益 */
    private String reward;
    /** 宝券收益 */
    private String rewardBaoquan;
    /** 保证金 */
    private String margins;
    /** 周期 */
    private int days;
    /** 封面URL **/
    private String coverUrl;

    /**
     * @param taskId
     * @param taskType
     * @param name
     * @param reward
     * @param rewardBaoquan
     * @param margins
     * @param days
     */
    public TaskDto(long taskId, int taskType, String name, String reward, String rewardBaoquan, String margins, int days) {
        super();
        this.taskId = taskId;
        this.taskType = taskType;
        this.name = name;
        this.reward = reward;
        this.rewardBaoquan = rewardBaoquan;
        this.margins = margins;
        this.days = days;
    }

    /**
     * 
     */
    public TaskDto() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the taskId
     */
    public long getTaskId() {
        return taskId;
    }

    /**
     * @param taskId
     * the taskId to set
     */
    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    /**
     * @return the taskType
     */
    public int getTaskType() {
        return taskType;
    }

    /**
     * @param taskType
     * the taskType to set
     */
    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     * the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the reward
     */
    public String getReward() {
        return reward;
    }

    /**
     * @param reward
     * the reward to set
     */
    public void setReward(String reward) {
        this.reward = reward;
    }

    /**
     * @return the rewardBaoquan
     */
    public String getRewardBaoquan() {
        return rewardBaoquan;
    }

    /**
     * @param rewardBaoquan
     * the rewardBaoquan to set
     */
    public void setRewardBaoquan(String rewardBaoquan) {
        this.rewardBaoquan = rewardBaoquan;
    }

    /**
     * @return the margins
     */
    public String getMargins() {
        return margins;
    }

    /**
     * @param margins
     * the margins to set
     */
    public void setMargins(String margins) {
        this.margins = margins;
    }

    /**
     * @return the days
     */
    public int getDays() {
        return days;
    }

    /**
     * @param days
     * the days to set
     */
    public void setDays(int days) {
        this.days = days;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;

    }

    /**
     * @return the coverUrl
     */
    public String getCoverUrl() {
        return coverUrl;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TaskDto [taskId=" + taskId + ", taskType=" + taskType + ", name=" + name + ", reward=" + reward + ", rewardBaoquan=" + rewardBaoquan + ", margins=" + margins + ", days=" + days + ", coverUrl=" + coverUrl + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((coverUrl == null) ? 0 : coverUrl.hashCode());
        result = prime * result + days;
        result = prime * result + ((margins == null) ? 0 : margins.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((reward == null) ? 0 : reward.hashCode());
        result = prime * result + ((rewardBaoquan == null) ? 0 : rewardBaoquan.hashCode());
        result = prime * result + (int) (taskId ^ (taskId >>> 32));
        result = prime * result + taskType;
        return result;
    }

    /* (non-Javadoc)
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
        TaskDto other = (TaskDto) obj;
        if (coverUrl == null) {
            if (other.coverUrl != null)
                return false;
        } else if (!coverUrl.equals(other.coverUrl))
            return false;
        if (days != other.days)
            return false;
        if (margins == null) {
            if (other.margins != null)
                return false;
        } else if (!margins.equals(other.margins))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (reward == null) {
            if (other.reward != null)
                return false;
        } else if (!reward.equals(other.reward))
            return false;
        if (rewardBaoquan == null) {
            if (other.rewardBaoquan != null)
                return false;
        } else if (!rewardBaoquan.equals(other.rewardBaoquan))
            return false;
        if (taskId != other.taskId)
            return false;
        if (taskType != other.taskType)
            return false;
        return true;
    }
    

}

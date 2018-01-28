/**
 * 
 */
package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author sjwangping@qbao.com
 *
 * $LastChangedDate: 2016-09-13 22:24:14 +0800 (Tue, 13 Sep 2016) $
 * $LastChangedRevision: 1016 $
 * $LastChangedBy: wangping $
 */
public class UserScoreLevel implements Serializable {
    private static final long serialVersionUID = "$Id: UserScoreLevel.java 1016 2016-09-13 14:24:14Z wangping $".hashCode();
    private long userId;
    private String userName;
    private double totalScore;
    private String level;
    private Date statDate;

    public UserScoreLevel() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     * the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userId
     */
    public long getUserId() {
        return userId;
    }

    /**
     * @param userId
     * the userId to set
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * @return the totalScore
     */
    public double getTotalScore() {
        return totalScore;
    }

    /**
     * @param totalScore
     * the totalScore to set
     */
    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level
     * the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return the statDate
     */
    public Date getStatDate() {
        return statDate;
    }

    /**
     * @param statDate
     * the statDate to set
     */
    public void setStatDate(Date statDate) {
        this.statDate = statDate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "UserScoreLevel [userId=" + userId + ", userName=" + userName + ", totalScore=" + totalScore + ", level=" + level + ", statDate=" + statDate + "]";
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
        result = prime * result + ((level == null) ? 0 : level.hashCode());
        result = prime * result + ((statDate == null) ? 0 : statDate.hashCode());
        long temp;
        temp = Double.doubleToLongBits(totalScore);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + (int) (userId ^ (userId >>> 32));
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
        UserScoreLevel other = (UserScoreLevel) obj;
        if (level == null) {
            if (other.level != null)
                return false;
        } else if (!level.equals(other.level))
            return false;
        if (statDate == null) {
            if (other.statDate != null)
                return false;
        } else if (!statDate.equals(other.statDate))
            return false;
        if (Double.doubleToLongBits(totalScore) != Double.doubleToLongBits(other.totalScore))
            return false;
        if (userId != other.userId)
            return false;
        if (userName == null) {
            if (other.userName != null)
                return false;
        } else if (!userName.equals(other.userName))
            return false;
        return true;
    }

}

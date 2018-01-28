package com.qbao.recommend.respositoy.mysql.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class MerDirectory implements Serializable{

	private static final long serialVersionUID = "$Id".hashCode();
	
	private String dirId;
	private String mainDirId;
	private String dirName;
	private String mainDirName;
	private int level;
	private int validFlag;
	
	

	public String getMainDirName() {
		return mainDirName;
	}



	public void setMainDirName(String mainDirName) {
		this.mainDirName = mainDirName;
	}



	public String getDirId() {
		return dirId;
	}



	public void setDirId(String dirId) {
		this.dirId = dirId;
	}



	public String getMainDirId() {
		return mainDirId;
	}



	public void setMainDirId(String mainDirId) {
		this.mainDirId = mainDirId;
	}



	public String getDirName() {
		return dirName;
	}



	public void setDirName(String dirName) {
		this.dirName = dirName;
	}



	public int getLevel() {
		return level;
	}



	public void setLevel(int level) {
		this.level = level;
	}



	public int getValidFlag() {
		return validFlag;
	}



	public void setValidFlag(int validFlag) {
		this.validFlag = validFlag;
	}



	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(ToStringStyle.MULTI_LINE_STYLE);
    }
	
	
}

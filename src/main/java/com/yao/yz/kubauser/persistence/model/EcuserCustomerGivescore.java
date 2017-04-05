package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserCustomerGivescore implements Serializable {
	private static final long serialVersionUID = 0X228130579F7E5BA2L;
	private Integer iD; // type in db: int(11)
	private Integer userId; // type in db: int(11)
	private String userName; // type in db: varchar(150)
	private Integer score; // type in db: int(11)
	private Integer runflag; // type in db: tinyint(4)
	private java.util.Date addTime; // type in db: datetime
	private String sysComment; // type in db: varchar(250)

	public Integer getID() {
		return this.iD;
	}
	public void setID(Integer iD) {
		this.iD = iD;
	}

	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getScore() {
		return this.score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getRunflag() {
		return this.runflag;
	}
	public void setRunflag(Integer runflag) {
		this.runflag = runflag;
	}

	public java.util.Date getAddTime() {
		return this.addTime;
	}
	public void setAddTime(java.util.Date addTime) {
		this.addTime = addTime;
	}

	public String getSysComment() {
		return this.sysComment;
	}
	public void setSysComment(String sysComment) {
		this.sysComment = sysComment;
	}


	@Override
	public String toString() {
		return "EcuserCustomerGivescore [iD=" + iD + ", userId=" + userId + ", userName=" + userName + ", score=" + score + ", runflag=" + runflag + ", addTime=" + addTime + ", sysComment=" + sysComment + "]";
	}
}

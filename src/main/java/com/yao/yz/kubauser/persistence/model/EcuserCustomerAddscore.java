package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserCustomerAddscore implements Serializable {
	private static final long serialVersionUID = 0X548598289D7036B7L;
	private Integer userId; // type in db: int(11)
	private String userName; // type in db: varchar(50)
	private Integer score; // type in db: int(11)
	private Integer runflag; // type in db: int(11)
	private java.util.Date addTime; // type in db: datetime

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


	@Override
	public String toString() {
		return "EcuserCustomerAddscore [userId=" + userId + ", userName=" + userName + ", score=" + score + ", runflag=" + runflag + ", addTime=" + addTime + "]";
	}
}

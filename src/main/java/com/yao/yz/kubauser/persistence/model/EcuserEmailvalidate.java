package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserEmailvalidate implements Serializable {
	private static final long serialVersionUID = 0XEF032CFD8BE4B9B0L;
	private Integer iD; // type in db: int(11)
	private Integer userId; // type in db: int(11)
	private String userName; // type in db: varchar(50)
	private java.util.Date addTime; // type in db: datetime
	private java.util.Date expiredTime; // type in db: datetime
	private String keyCode; // type in db: varchar(50)

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

	public java.util.Date getAddTime() {
		return this.addTime;
	}
	public void setAddTime(java.util.Date addTime) {
		this.addTime = addTime;
	}

	public java.util.Date getExpiredTime() {
		return this.expiredTime;
	}
	public void setExpiredTime(java.util.Date expiredTime) {
		this.expiredTime = expiredTime;
	}

	public String getKeyCode() {
		return this.keyCode;
	}
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}


	@Override
	public String toString() {
		return "EcuserEmailvalidate [iD=" + iD + ", userId=" + userId + ", userName=" + userName + ", addTime=" + addTime + ", expiredTime=" + expiredTime + ", keyCode=" + keyCode + "]";
	}
}

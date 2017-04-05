package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserCustomeractivity implements Serializable {
	private static final long serialVersionUID = 0XE9D01AE6F1559444L;
	private Integer id; // type in db: int(11)
	private String userName; // type in db: varchar(50)
	private String activityCode; // type in db: varchar(50)
	private java.util.Date addTime; // type in db: datetime
	private Integer status; // type in db: int(11)

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getActivityCode() {
		return this.activityCode;
	}
	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public java.util.Date getAddTime() {
		return this.addTime;
	}
	public void setAddTime(java.util.Date addTime) {
		this.addTime = addTime;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "EcuserCustomeractivity [id=" + id + ", userName=" + userName + ", activityCode=" + activityCode + ", addTime=" + addTime + ", status=" + status + "]";
	}
}

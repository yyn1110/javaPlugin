package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class Lotteryjoinuser implements Serializable {
	private static final long serialVersionUID = 0X3F32E100AE81CD47L;
	private Integer id; // type in db: int(11)
	private String userName; // type in db: varchar(50)
	private String ip; // type in db: varchar(20)
	private Integer clickCount; // type in db: smallint(6)
	private java.util.Date joinTime; // type in db: datetime
	private Integer userId; // type in db: int(11)
	private java.util.Date joinDate; // type in db: date
	private Integer actType; // type in db: int(11)

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

	public String getIp() {
		return this.ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getClickCount() {
		return this.clickCount;
	}
	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	public java.util.Date getJoinTime() {
		return this.joinTime;
	}
	public void setJoinTime(java.util.Date joinTime) {
		this.joinTime = joinTime;
	}

	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public java.util.Date getJoinDate() {
		return this.joinDate;
	}
	public void setJoinDate(java.util.Date joinDate) {
		this.joinDate = joinDate;
	}

	public Integer getActType() {
		return this.actType;
	}
	public void setActType(Integer actType) {
		this.actType = actType;
	}


	@Override
	public String toString() {
		return "Lotteryjoinuser [id=" + id + ", userName=" + userName + ", ip=" + ip + ", clickCount=" + clickCount + ", joinTime=" + joinTime + ", userId=" + userId + ", joinDate=" + joinDate + ", actType=" + actType + "]";
	}
}

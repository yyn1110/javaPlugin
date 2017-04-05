package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserSensitivewords implements Serializable {
	private static final long serialVersionUID = 0X0E1D6F2F29D24E20L;
	private Integer id; // type in db: int(11)
	private String wordContent; // type in db: varchar(200)
	private java.util.Date addTime; // type in db: datetime
	private String addUser; // type in db: varchar(50)
	private Integer status; // type in db: int(11)
	private Integer type; // type in db: int(11)
	private String updateUser; // type in db: varchar(50)
	private java.util.Date updateTime; // type in db: datetime

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getWordContent() {
		return this.wordContent;
	}
	public void setWordContent(String wordContent) {
		this.wordContent = wordContent;
	}

	public java.util.Date getAddTime() {
		return this.addTime;
	}
	public void setAddTime(java.util.Date addTime) {
		this.addTime = addTime;
	}

	public String getAddUser() {
		return this.addUser;
	}
	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}


	@Override
	public String toString() {
		return "EcuserSensitivewords [id=" + id + ", wordContent=" + wordContent + ", addTime=" + addTime + ", addUser=" + addUser + ", status=" + status + ", type=" + type + ", updateUser=" + updateUser + ", updateTime=" + updateTime + "]";
	}
}

package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class OpenVenderUser implements Serializable {
	private static final long serialVersionUID = 0X29222B60C3E8B665L;
	private Integer id; // type in db: int(11)
	private String venderId; // type in db: varchar(30)
	private Integer userId; // type in db: int(11)
	private String userName; // type in db: varchar(50)
	private Integer type; // type in db: int(11)
	private Integer status; // type in db: int(11)
	private String mobile; // type in db: varchar(20)
	private String inputer; // type in db: varchar(50)
	private java.util.Date inputTime; // type in db: datetime
	private String updater; // type in db: varchar(50)
	private java.util.Date updateTime; // type in db: datetime

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getVenderId() {
		return this.venderId;
	}
	public void setVenderId(String venderId) {
		this.venderId = venderId;
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

	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMobile() {
		return this.mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getInputer() {
		return this.inputer;
	}
	public void setInputer(String inputer) {
		this.inputer = inputer;
	}

	public java.util.Date getInputTime() {
		return this.inputTime;
	}
	public void setInputTime(java.util.Date inputTime) {
		this.inputTime = inputTime;
	}

	public String getUpdater() {
		return this.updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}


	@Override
	public String toString() {
		return "OpenVenderUser [id=" + id + ", venderId=" + venderId + ", userId=" + userId + ", userName=" + userName + ", type=" + type + ", status=" + status + ", mobile=" + mobile + ", inputer=" + inputer + ", inputTime=" + inputTime + ", updater=" + updater + ", updateTime=" + updateTime + "]";
	}
}

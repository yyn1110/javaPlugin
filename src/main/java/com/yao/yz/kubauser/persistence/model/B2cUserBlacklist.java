package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class B2cUserBlacklist implements Serializable {
	private static final long serialVersionUID = 0X320C2790DBE48420L;
	private Integer id; // type in db: int(11)
	private Integer ecUserId; // type in db: int(11)
	private String userName; // type in db: varchar(200)
	private String userMobile; // type in db: varchar(20)
	private String userEmail; // type in db: varchar(250)
	private String blacklistType; // type in db: varchar(3)
	private String blacklistStatus; // type in db: varchar(3)
	private String createUserId; // type in db: varchar(200)
	private java.util.Date createDate; // type in db: datetime
	private String updateUserId; // type in db: varchar(200)
	private java.util.Date updateDate; // type in db: datetime

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEcUserId() {
		return this.ecUserId;
	}
	public void setEcUserId(Integer ecUserId) {
		this.ecUserId = ecUserId;
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMobile() {
		return this.userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserEmail() {
		return this.userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getBlacklistType() {
		return this.blacklistType;
	}
	public void setBlacklistType(String blacklistType) {
		this.blacklistType = blacklistType;
	}

	public String getBlacklistStatus() {
		return this.blacklistStatus;
	}
	public void setBlacklistStatus(String blacklistStatus) {
		this.blacklistStatus = blacklistStatus;
	}

	public String getCreateUserId() {
		return this.createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public java.util.Date getCreateDate() {
		return this.createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUserId() {
		return this.updateUserId;
	}
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public java.util.Date getUpdateDate() {
		return this.updateDate;
	}
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}


	@Override
	public String toString() {
		return "B2cUserBlacklist [id=" + id + ", ecUserId=" + ecUserId + ", userName=" + userName + ", userMobile=" + userMobile + ", userEmail=" + userEmail + ", blacklistType=" + blacklistType + ", blacklistStatus=" + blacklistStatus + ", createUserId=" + createUserId + ", createDate=" + createDate + ", updateUserId=" + updateUserId + ", updateDate=" + updateDate + "]";
	}
}

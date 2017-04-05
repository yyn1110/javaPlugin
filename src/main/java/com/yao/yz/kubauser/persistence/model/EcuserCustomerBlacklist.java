package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserCustomerBlacklist implements Serializable {
	private static final long serialVersionUID = 0XB0B6B8179F5CA699L;
	private Integer autoId; // type in db: int(11)
	private Integer userId; // type in db: int(11)
	private String userName; // type in db: varchar(50)
	private String mobile; // type in db: varchar(20)
	private String tel; // type in db: varchar(20)
	private String userIp; // type in db: varchar(20)
	private String creator; // type in db: varchar(50)
	private java.util.Date createTime; // type in db: datetime
	private Integer isDeleted; // type in db: tinyint(4)

	public Integer getAutoId() {
		return this.autoId;
	}
	public void setAutoId(Integer autoId) {
		this.autoId = autoId;
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

	public String getMobile() {
		return this.mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return this.tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUserIp() {
		return this.userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getCreator() {
		return this.creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}

	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public Integer getIsDeleted() {
		return this.isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}


	@Override
	public String toString() {
		return "EcuserCustomerBlacklist [autoId=" + autoId + ", userId=" + userId + ", userName=" + userName + ", mobile=" + mobile + ", tel=" + tel + ", userIp=" + userIp + ", creator=" + creator + ", createTime=" + createTime + ", isDeleted=" + isDeleted + "]";
	}
}

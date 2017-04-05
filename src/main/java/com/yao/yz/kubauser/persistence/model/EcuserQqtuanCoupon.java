package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserQqtuanCoupon implements Serializable {
	private static final long serialVersionUID = 0X6CA11BADB0F62541L;
	private Integer id; // type in db: int(11)
	private Integer userId; // type in db: int(11)
	private String userName; // type in db: varchar(50)
	private String validateCode; // type in db: varchar(50)
	private String couponCode; // type in db: varchar(50)
	private java.util.Date createdTime; // type in db: datetime

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
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

	public String getValidateCode() {
		return this.validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public String getCouponCode() {
		return this.couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public java.util.Date getCreatedTime() {
		return this.createdTime;
	}
	public void setCreatedTime(java.util.Date createdTime) {
		this.createdTime = createdTime;
	}


	@Override
	public String toString() {
		return "EcuserQqtuanCoupon [id=" + id + ", userId=" + userId + ", userName=" + userName + ", validateCode=" + validateCode + ", couponCode=" + couponCode + ", createdTime=" + createdTime + "]";
	}
}

package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class WeixinUserCoupon implements Serializable {
	private static final long serialVersionUID = 0XD88AD970C1EE91A0L;
	private Integer id; // type in db: int(20)
	private String openId; // type in db: varchar(32)
	private String userId; // type in db: varchar(200)
	private String batchCode; // type in db: varchar(20)
	private java.util.Date getTime; // type in db: datetime
	private Integer shopId; // type in db: int(20)

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenId() {
		return this.openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBatchCode() {
		return this.batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	public java.util.Date getGetTime() {
		return this.getTime;
	}
	public void setGetTime(java.util.Date getTime) {
		this.getTime = getTime;
	}

	public Integer getShopId() {
		return this.shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}


	@Override
	public String toString() {
		return "WeixinUserCoupon [id=" + id + ", openId=" + openId + ", userId=" + userId + ", batchCode=" + batchCode + ", getTime=" + getTime + ", shopId=" + shopId + "]";
	}
}

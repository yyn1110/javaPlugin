package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class WeixinUserBind implements Serializable {
	private static final long serialVersionUID = 0X9B32EDC9FF4E2FA3L;
	private Integer id; // type in db: int(20)
	private String openId; // type in db: varchar(32)
	private String userId; // type in db: varchar(200)
	private java.util.Date bindDate; // type in db: datetime
	private Integer status; // type in db: int(2)
	private java.util.Date unbindDate; // type in db: datetime
	private String recOpenId; // type in db: varchar(64)
	private String taobaoAccount; // type in db: varchar(64)
	private Integer forwardLevel; // type in db: int(11)
	private String weixinAccount; // type in db: varchar(50)
	private Integer shopId; // type in db: int(20)
	private String venderId; // type in db: varchar(32)

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

	public java.util.Date getBindDate() {
		return this.bindDate;
	}
	public void setBindDate(java.util.Date bindDate) {
		this.bindDate = bindDate;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public java.util.Date getUnbindDate() {
		return this.unbindDate;
	}
	public void setUnbindDate(java.util.Date unbindDate) {
		this.unbindDate = unbindDate;
	}

	public String getRecOpenId() {
		return this.recOpenId;
	}
	public void setRecOpenId(String recOpenId) {
		this.recOpenId = recOpenId;
	}

	public String getTaobaoAccount() {
		return this.taobaoAccount;
	}
	public void setTaobaoAccount(String taobaoAccount) {
		this.taobaoAccount = taobaoAccount;
	}

	public Integer getForwardLevel() {
		return this.forwardLevel;
	}
	public void setForwardLevel(Integer forwardLevel) {
		this.forwardLevel = forwardLevel;
	}

	public String getWeixinAccount() {
		return this.weixinAccount;
	}
	public void setWeixinAccount(String weixinAccount) {
		this.weixinAccount = weixinAccount;
	}

	public Integer getShopId() {
		return this.shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getVenderId() {
		return this.venderId;
	}
	public void setVenderId(String venderId) {
		this.venderId = venderId;
	}


	@Override
	public String toString() {
		return "WeixinUserBind [id=" + id + ", openId=" + openId + ", userId=" + userId + ", bindDate=" + bindDate + ", status=" + status + ", unbindDate=" + unbindDate + ", recOpenId=" + recOpenId + ", taobaoAccount=" + taobaoAccount + ", forwardLevel=" + forwardLevel + ", weixinAccount=" + weixinAccount + ", shopId=" + shopId + ", venderId=" + venderId + "]";
	}
}

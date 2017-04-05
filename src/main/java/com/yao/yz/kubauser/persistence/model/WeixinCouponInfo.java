package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class WeixinCouponInfo implements Serializable {
	private static final long serialVersionUID = 0X96EB92FDEAC14695L;
	private Integer id; // type in db: int(20)
	private String batchCode; // type in db: varchar(20)
	private String showName; // type in db: varchar(100)
	private Integer freezeQuantity; // type in db: int(4)
	private Integer usedCount; // type in db: int(4)
	private java.util.Date inputeTime; // type in db: datetime
	private String inputer; // type in db: varchar(20)
	private Integer status; // type in db: int(11)
	private Integer shopId; // type in db: int(20)

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getBatchCode() {
		return this.batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	public String getShowName() {
		return this.showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}

	public Integer getFreezeQuantity() {
		return this.freezeQuantity;
	}
	public void setFreezeQuantity(Integer freezeQuantity) {
		this.freezeQuantity = freezeQuantity;
	}

	public Integer getUsedCount() {
		return this.usedCount;
	}
	public void setUsedCount(Integer usedCount) {
		this.usedCount = usedCount;
	}

	public java.util.Date getInputeTime() {
		return this.inputeTime;
	}
	public void setInputeTime(java.util.Date inputeTime) {
		this.inputeTime = inputeTime;
	}

	public String getInputer() {
		return this.inputer;
	}
	public void setInputer(String inputer) {
		this.inputer = inputer;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getShopId() {
		return this.shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}


	@Override
	public String toString() {
		return "WeixinCouponInfo [id=" + id + ", batchCode=" + batchCode + ", showName=" + showName + ", freezeQuantity=" + freezeQuantity + ", usedCount=" + usedCount + ", inputeTime=" + inputeTime + ", inputer=" + inputer + ", status=" + status + ", shopId=" + shopId + "]";
	}
}

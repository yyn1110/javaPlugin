package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class YdyVoucher implements Serializable {
	private static final long serialVersionUID = 0XE179A62ED469FD4CL;
	private Integer id; // type in db: int(11)
	private String voucherId; // type in db: varchar(200)
	private Integer status; // type in db: int(11)
	private java.util.Date createtime; // type in db: timestamp
	private java.util.Date activeTime; // type in db: timestamp

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getVoucherId() {
		return this.voucherId;
	}
	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public java.util.Date getCreatetime() {
		return this.createtime;
	}
	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public java.util.Date getActiveTime() {
		return this.activeTime;
	}
	public void setActiveTime(java.util.Date activeTime) {
		this.activeTime = activeTime;
	}


	@Override
	public String toString() {
		return "YdyVoucher [id=" + id + ", voucherId=" + voucherId + ", status=" + status + ", createtime=" + createtime + ", activeTime=" + activeTime + "]";
	}
}

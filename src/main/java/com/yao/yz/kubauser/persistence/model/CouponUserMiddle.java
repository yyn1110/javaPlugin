package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class CouponUserMiddle implements Serializable {
	private static final long serialVersionUID = 0X27F35A38B86FE2C5L;
	private String batchcode; // type in db: varchar(100)
	private String code; // type in db: varchar(100)
	private String username; // type in db: varchar(100)
	private java.util.Date senddate; // type in db: timestamp
	private Integer status; // type in db: int(2)

	public String getBatchcode() {
		return this.batchcode;
	}
	public void setBatchcode(String batchcode) {
		this.batchcode = batchcode;
	}

	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public java.util.Date getSenddate() {
		return this.senddate;
	}
	public void setSenddate(java.util.Date senddate) {
		this.senddate = senddate;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "CouponUserMiddle [batchcode=" + batchcode + ", code=" + code + ", username=" + username + ", senddate=" + senddate + ", status=" + status + "]";
	}
}

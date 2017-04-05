package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserSyncusererror implements Serializable {
	private static final long serialVersionUID = 0X6DA04E05B1619A11L;
	private Integer id; // type in db: int(11)
	private String skey; // type in db: varchar(50)
	private String status; // type in db: char(1)
	private String sType; // type in db: varchar(50)
	private String sKind; // type in db: varchar(10)
	private String sDesc; // type in db: varchar(200)
	private java.util.Date addDate; // type in db: datetime

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getSkey() {
		return this.skey;
	}
	public void setSkey(String skey) {
		this.skey = skey;
	}

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getSType() {
		return this.sType;
	}
	public void setSType(String sType) {
		this.sType = sType;
	}

	public String getSKind() {
		return this.sKind;
	}
	public void setSKind(String sKind) {
		this.sKind = sKind;
	}

	public String getSDesc() {
		return this.sDesc;
	}
	public void setSDesc(String sDesc) {
		this.sDesc = sDesc;
	}

	public java.util.Date getAddDate() {
		return this.addDate;
	}
	public void setAddDate(java.util.Date addDate) {
		this.addDate = addDate;
	}


	@Override
	public String toString() {
		return "EcuserSyncusererror [id=" + id + ", skey=" + skey + ", status=" + status + ", sType=" + sType + ", sKind=" + sKind + ", sDesc=" + sDesc + ", addDate=" + addDate + "]";
	}
}

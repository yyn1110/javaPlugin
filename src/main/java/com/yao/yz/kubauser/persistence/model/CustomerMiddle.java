package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class CustomerMiddle implements Serializable {
	private static final long serialVersionUID = 0X079C0901E37174A4L;
	private Integer ecuserid; // type in db: int(11)
	private String userName; // type in db: varchar(200)
	private Double backcount; // type in db: double

	public Integer getEcuserid() {
		return this.ecuserid;
	}
	public void setEcuserid(Integer ecuserid) {
		this.ecuserid = ecuserid;
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getBackcount() {
		return this.backcount;
	}
	public void setBackcount(Double backcount) {
		this.backcount = backcount;
	}


	@Override
	public String toString() {
		return "CustomerMiddle [ecuserid=" + ecuserid + ", userName=" + userName + ", backcount=" + backcount + "]";
	}
}

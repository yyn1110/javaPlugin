package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempCouponTouser implements Serializable {
	private static final long serialVersionUID = 0X1BE468380825BC3CL;
	private String username; // type in db: varchar(255)
	private String batchcode; // type in db: varchar(30)
	private java.util.Date activedate; // type in db: datetime

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getBatchcode() {
		return this.batchcode;
	}
	public void setBatchcode(String batchcode) {
		this.batchcode = batchcode;
	}

	public java.util.Date getActivedate() {
		return this.activedate;
	}
	public void setActivedate(java.util.Date activedate) {
		this.activedate = activedate;
	}


	@Override
	public String toString() {
		return "TempCouponTouser [username=" + username + ", batchcode=" + batchcode + ", activedate=" + activedate + "]";
	}
}

package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempCouponUser1 implements Serializable {
	private static final long serialVersionUID = 0X410469EAD922D400L;
	private String username; // type in db: varchar(255)

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "TempCouponUser1 [username=" + username + "]";
	}
}

package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempCouponUser implements Serializable {
	private static final long serialVersionUID = 0XBF9474B5F2894159L;
	private String username; // type in db: varchar(255)

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "TempCouponUser [username=" + username + "]";
	}
}

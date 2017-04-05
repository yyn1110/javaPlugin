package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempCouponUsername implements Serializable {
	private static final long serialVersionUID = 0X2E86C2EAD5E1C308L;
	private String username; // type in db: varchar(50)

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "TempCouponUsername [username=" + username + "]";
	}
}

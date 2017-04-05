package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempCouponUserCopy implements Serializable {
	private static final long serialVersionUID = 0X5AC4A70073BEFE60L;
	private String username; // type in db: varchar(255)

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "TempCouponUserCopy [username=" + username + "]";
	}
}

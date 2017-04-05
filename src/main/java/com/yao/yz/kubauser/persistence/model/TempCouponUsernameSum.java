package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempCouponUsernameSum implements Serializable {
	private static final long serialVersionUID = 0X7451CAC52A1B3F6CL;
	private String username; // type in db: varchar(255)
	private Double denomination; // type in db: double

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Double getDenomination() {
		return this.denomination;
	}
	public void setDenomination(Double denomination) {
		this.denomination = denomination;
	}


	@Override
	public String toString() {
		return "TempCouponUsernameSum [username=" + username + ", denomination=" + denomination + "]";
	}
}

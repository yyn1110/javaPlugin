package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempCouponUsernameSumCopy implements Serializable {
	private static final long serialVersionUID = 0X0372A94A6E208029L;
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
		return "TempCouponUsernameSumCopy [username=" + username + ", denomination=" + denomination + "]";
	}
}

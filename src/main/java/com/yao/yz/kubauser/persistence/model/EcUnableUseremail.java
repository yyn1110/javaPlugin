package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcUnableUseremail implements Serializable {
	private static final long serialVersionUID = 0X5E996128BB6064E5L;
	private String email; // type in db: varchar(255)

	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "EcUnableUseremail [email=" + email + "]";
	}
}

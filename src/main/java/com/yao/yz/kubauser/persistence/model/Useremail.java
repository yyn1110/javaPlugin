package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class Useremail implements Serializable {
	private static final long serialVersionUID = 0X7DFB959493795926L;
	private String email; // type in db: varchar(200)

	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Useremail [email=" + email + "]";
	}
}

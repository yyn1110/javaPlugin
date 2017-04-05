package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class Tempusers implements Serializable {
	private static final long serialVersionUID = 0XA04F2A2252621DCFL;
	private String username; // type in db: varchar(20)
	private String email; // type in db: varchar(50)

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Tempusers [username=" + username + ", email=" + email + "]";
	}
}

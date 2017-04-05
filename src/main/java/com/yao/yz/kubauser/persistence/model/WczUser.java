package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class WczUser implements Serializable {
	private static final long serialVersionUID = 0XE4B88298A3ABB9BDL;
	private String username; // type in db: varchar(50)

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "WczUser [username=" + username + "]";
	}
}

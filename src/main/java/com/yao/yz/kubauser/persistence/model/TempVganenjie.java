package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempVganenjie implements Serializable {
	private static final long serialVersionUID = 0XEB4CED86462C104DL;
	private String username; // type in db: varchar(255)

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "TempVganenjie [username=" + username + "]";
	}
}

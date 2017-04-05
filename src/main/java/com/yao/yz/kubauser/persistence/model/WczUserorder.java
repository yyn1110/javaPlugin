package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class WczUserorder implements Serializable {
	private static final long serialVersionUID = 0XF17707F3E00BC4B5L;
	private String username; // type in db: varchar(50)

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "WczUserorder [username=" + username + "]";
	}
}

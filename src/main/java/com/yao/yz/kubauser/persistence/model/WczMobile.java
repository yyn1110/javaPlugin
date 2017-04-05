package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class WczMobile implements Serializable {
	private static final long serialVersionUID = 0X6FE371B68031321AL;
	private String username; // type in db: varchar(50)
	private String sendContactmobile; // type in db: varchar(20)

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getSendContactmobile() {
		return this.sendContactmobile;
	}
	public void setSendContactmobile(String sendContactmobile) {
		this.sendContactmobile = sendContactmobile;
	}


	@Override
	public String toString() {
		return "WczMobile [username=" + username + ", sendContactmobile=" + sendContactmobile + "]";
	}
}

package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class ZsjVenderUser implements Serializable {
	private static final long serialVersionUID = 0XFC234DDF2DA7AC70L;
	private String venderId; // type in db: varchar(30)
	private String userName; // type in db: varchar(50)
	private String mobile; // type in db: varchar(20)

	public String getVenderId() {
		return this.venderId;
	}
	public void setVenderId(String venderId) {
		this.venderId = venderId;
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return this.mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	@Override
	public String toString() {
		return "ZsjVenderUser [venderId=" + venderId + ", userName=" + userName + ", mobile=" + mobile + "]";
	}
}

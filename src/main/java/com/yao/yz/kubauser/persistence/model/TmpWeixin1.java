package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TmpWeixin1 implements Serializable {
	private static final long serialVersionUID = 0XE284320402DDCAADL;
	private String userId; // type in db: varchar(200)
	private String id; // type in db: varchar(200)
	private String email; // type in db: varchar(250)
	private String loginEmail; // type in db: varchar(250)

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginEmail() {
		return this.loginEmail;
	}
	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}


	@Override
	public String toString() {
		return "TmpWeixin1 [userId=" + userId + ", id=" + id + ", email=" + email + ", loginEmail=" + loginEmail + "]";
	}
}

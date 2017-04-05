package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempEdmEmail implements Serializable {
	private static final long serialVersionUID = 0X444CCA98A8450A06L;
	private String emailAddress; // type in db: varchar(255)

	public String getEmailAddress() {
		return this.emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	@Override
	public String toString() {
		return "TempEdmEmail [emailAddress=" + emailAddress + "]";
	}
}

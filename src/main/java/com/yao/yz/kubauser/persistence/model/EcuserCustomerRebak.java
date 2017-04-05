package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserCustomerRebak implements Serializable {
	private static final long serialVersionUID = 0XF12D96F0290F5D8FL;
	private Integer ecuserid; // type in db: int(11)
	private String password; // type in db: varchar(100)

	public Integer getEcuserid() {
		return this.ecuserid;
	}
	public void setEcuserid(Integer ecuserid) {
		this.ecuserid = ecuserid;
	}

	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "EcuserCustomerRebak [ecuserid=" + ecuserid + ", password=" + password + "]";
	}
}

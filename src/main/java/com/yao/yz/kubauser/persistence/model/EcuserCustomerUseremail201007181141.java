package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserCustomerUseremail201007181141 implements Serializable {
	private static final long serialVersionUID = 0X1927E98601E2E548L;
	private String email; // type in db: varchar(50)
	private Integer con; // type in db: bigint(21)

	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCon() {
		return this.con;
	}
	public void setCon(Integer con) {
		this.con = con;
	}


	@Override
	public String toString() {
		return "EcuserCustomerUseremail201007181141 [email=" + email + ", con=" + con + "]";
	}
}

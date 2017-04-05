package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserCustomerTemp implements Serializable {
	private static final long serialVersionUID = 0X8BF581608B275C37L;
	private Integer ecuserid; // type in db: int(11)
	private String id; // type in db: varchar(200)
	private String email; // type in db: varchar(200)
	private Integer count; // type in db: int(11)

	public Integer getEcuserid() {
		return this.ecuserid;
	}
	public void setEcuserid(Integer ecuserid) {
		this.ecuserid = ecuserid;
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

	public Integer getCount() {
		return this.count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}


	@Override
	public String toString() {
		return "EcuserCustomerTemp [ecuserid=" + ecuserid + ", id=" + id + ", email=" + email + ", count=" + count + "]";
	}
}

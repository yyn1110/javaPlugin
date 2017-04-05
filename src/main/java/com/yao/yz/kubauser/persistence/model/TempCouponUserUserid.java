package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempCouponUserUserid implements Serializable {
	private static final long serialVersionUID = 0X2A7E303017718D6DL;
	private Integer no; // type in db: int(11)
	private Integer userId; // type in db: int(11)
	private String username1; // type in db: varchar(30)
	private String telephone; // type in db: varchar(30)
	private String email; // type in db: varchar(30)
	private String username2; // type in db: varchar(30)

	public Integer getNo() {
		return this.no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}

	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername1() {
		return this.username1;
	}
	public void setUsername1(String username1) {
		this.username1 = username1;
	}

	public String getTelephone() {
		return this.telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername2() {
		return this.username2;
	}
	public void setUsername2(String username2) {
		this.username2 = username2;
	}


	@Override
	public String toString() {
		return "TempCouponUserUserid [no=" + no + ", userId=" + userId + ", username1=" + username1 + ", telephone=" + telephone + ", email=" + email + ", username2=" + username2 + "]";
	}
}

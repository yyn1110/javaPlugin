package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class Badip implements Serializable {
	private static final long serialVersionUID = 0XD6A635E85ABA0F50L;
	private String 登录ip; // type in db: varchar(20)

	public String get登录ip() {
		return this.登录ip;
	}
	public void set登录ip(String 登录ip) {
		this.登录ip = 登录ip;
	}


	@Override
	public String toString() {
		return "Badip [登录ip=" + 登录ip + "]";
	}
}

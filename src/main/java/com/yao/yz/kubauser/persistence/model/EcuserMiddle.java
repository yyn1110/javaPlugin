package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserMiddle implements Serializable {
	private static final long serialVersionUID = 0X984922764EDD6EA2L;
	private Integer userId; // type in db: int(11)

	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "EcuserMiddle [userId=" + userId + "]";
	}
}

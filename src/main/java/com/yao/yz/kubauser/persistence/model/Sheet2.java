package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class Sheet2 implements Serializable {
	private static final long serialVersionUID = 0X36ED33A7EC9999A8L;
	private String f1; // type in db: varchar(255)

	public String getF1() {
		return this.f1;
	}
	public void setF1(String f1) {
		this.f1 = f1;
	}


	@Override
	public String toString() {
		return "Sheet2 [f1=" + f1 + "]";
	}
}

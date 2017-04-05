package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempCouponUserTelephone1 implements Serializable {
	private static final long serialVersionUID = 0XC714E03861226DD0L;
	private String telephone; // type in db: varchar(20)

	public String getTelephone() {
		return this.telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	@Override
	public String toString() {
		return "TempCouponUserTelephone1 [telephone=" + telephone + "]";
	}
}

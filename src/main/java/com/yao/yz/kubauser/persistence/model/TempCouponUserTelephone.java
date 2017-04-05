package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempCouponUserTelephone implements Serializable {
	private static final long serialVersionUID = 0XD312B764BAF38A95L;
	private String telephone; // type in db: varchar(20)

	public String getTelephone() {
		return this.telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	@Override
	public String toString() {
		return "TempCouponUserTelephone [telephone=" + telephone + "]";
	}
}

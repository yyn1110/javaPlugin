package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserCustomerBakMobile implements Serializable {
	private static final long serialVersionUID = 0X33B363B9599C10A1L;
	private String cellphone; // type in db: varchar(50)

	public String getCellphone() {
		return this.cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}


	@Override
	public String toString() {
		return "EcuserCustomerBakMobile [cellphone=" + cellphone + "]";
	}
}

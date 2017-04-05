package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempTelephone implements Serializable {
	private static final long serialVersionUID = 0XF59E4CB2B82A888AL;
	private String telephone; // type in db: varchar(50)
	private String code; // type in db: varchar(50)
	private String activecode; // type in db: varchar(10)

	public String getTelephone() {
		return this.telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getActivecode() {
		return this.activecode;
	}
	public void setActivecode(String activecode) {
		this.activecode = activecode;
	}


	@Override
	public String toString() {
		return "TempTelephone [telephone=" + telephone + ", code=" + code + ", activecode=" + activecode + "]";
	}
}

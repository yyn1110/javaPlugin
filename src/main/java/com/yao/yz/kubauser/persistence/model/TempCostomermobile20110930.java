package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempCostomermobile20110930 implements Serializable {
	private static final long serialVersionUID = 0XEC481283E6ED70B2L;
	private String id; // type in db: varchar(50)
	private String cellphone; // type in db: varchar(50)

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getCellphone() {
		return this.cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}


	@Override
	public String toString() {
		return "TempCostomermobile20110930 [id=" + id + ", cellphone=" + cellphone + "]";
	}
}

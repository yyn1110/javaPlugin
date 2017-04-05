package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EdmBuyMark implements Serializable {
	private static final long serialVersionUID = 0X9F1F8A1FB5FBA9DCL;
	private Integer userid; // type in db: int(11)
	private String orderdate; // type in db: varchar(255)

	public Integer getUserid() {
		return this.userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getOrderdate() {
		return this.orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}


	@Override
	public String toString() {
		return "EdmBuyMark [userid=" + userid + ", orderdate=" + orderdate + "]";
	}
}

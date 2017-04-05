package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempCouponUserid implements Serializable {
	private static final long serialVersionUID = 0X33515C346BC0D3FAL;
	private String userid; // type in db: varchar(50)

	public String getUserid() {
		return this.userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}


	@Override
	public String toString() {
		return "TempCouponUserid [userid=" + userid + "]";
	}
}

package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempCouponUserid1 implements Serializable {
	private static final long serialVersionUID = 0X79B76D0BA629D586L;
	private Integer userid; // type in db: int(11)

	public Integer getUserid() {
		return this.userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}


	@Override
	public String toString() {
		return "TempCouponUserid1 [userid=" + userid + "]";
	}
}

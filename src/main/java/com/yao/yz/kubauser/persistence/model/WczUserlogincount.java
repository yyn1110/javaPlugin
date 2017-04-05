package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class WczUserlogincount implements Serializable {
	private static final long serialVersionUID = 0X5700484B2A287697L;
	private Double userid; // type in db: double
	private Double c; // type in db: double

	public Double getUserid() {
		return this.userid;
	}
	public void setUserid(Double userid) {
		this.userid = userid;
	}

	public Double getC() {
		return this.c;
	}
	public void setC(Double c) {
		this.c = c;
	}


	@Override
	public String toString() {
		return "WczUserlogincount [userid=" + userid + ", c=" + c + "]";
	}
}

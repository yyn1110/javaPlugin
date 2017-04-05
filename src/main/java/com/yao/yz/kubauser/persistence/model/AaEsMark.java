package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class AaEsMark implements Serializable {
	private static final long serialVersionUID = 0X3E618F7C0F397F95L;
	private Integer userid; // type in db: int(11)
	private Integer edm; // type in db: int(11)
	private Integer sms; // type in db: int(11)

	public Integer getUserid() {
		return this.userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getEdm() {
		return this.edm;
	}
	public void setEdm(Integer edm) {
		this.edm = edm;
	}

	public Integer getSms() {
		return this.sms;
	}
	public void setSms(Integer sms) {
		this.sms = sms;
	}


	@Override
	public String toString() {
		return "AaEsMark [userid=" + userid + ", edm=" + edm + ", sms=" + sms + "]";
	}
}

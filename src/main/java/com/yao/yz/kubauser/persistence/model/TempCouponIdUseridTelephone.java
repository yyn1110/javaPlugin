package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempCouponIdUseridTelephone implements Serializable {
	private static final long serialVersionUID = 0X0A275E2F3F83C351L;
	private Integer id; // type in db: int(11)
	private Integer userid; // type in db: int(11)
	private String telephone; // type in db: varchar(20)

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return this.userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getTelephone() {
		return this.telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	@Override
	public String toString() {
		return "TempCouponIdUseridTelephone [id=" + id + ", userid=" + userid + ", telephone=" + telephone + "]";
	}
}

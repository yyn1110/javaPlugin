package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class MSDelay implements Serializable {
	private static final long serialVersionUID = 0X0761480B6FB62122L;
	private Integer id; // type in db: int(11)
	private java.util.Date ts; // type in db: datetime

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public java.util.Date getTs() {
		return this.ts;
	}
	public void setTs(java.util.Date ts) {
		this.ts = ts;
	}


	@Override
	public String toString() {
		return "MSDelay [id=" + id + ", ts=" + ts + "]";
	}
}

package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempEdmusername implements Serializable {
	private static final long serialVersionUID = 0X5F8095A98772866AL;
	private String id; // type in db: varchar(50)

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "TempEdmusername [id=" + id + "]";
	}
}

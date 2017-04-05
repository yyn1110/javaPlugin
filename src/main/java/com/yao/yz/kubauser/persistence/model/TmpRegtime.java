package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TmpRegtime implements Serializable {
	private static final long serialVersionUID = 0XFAD2230813EF6EC6L;
	private String id; // type in db: varchar(255)
	private String name; // type in db: varchar(255)
	private java.util.Date time; // type in db: date

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public java.util.Date getTime() {
		return this.time;
	}
	public void setTime(java.util.Date time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "TmpRegtime [id=" + id + ", name=" + name + ", time=" + time + "]";
	}
}

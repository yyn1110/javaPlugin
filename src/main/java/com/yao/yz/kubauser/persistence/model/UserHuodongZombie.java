package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class UserHuodongZombie implements Serializable {
	private static final long serialVersionUID = 0X4012121CE17D742FL;
	private String id; // type in db: varchar(50)

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "UserHuodongZombie [id=" + id + "]";
	}
}

package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempCustomer20111021 implements Serializable {
	private static final long serialVersionUID = 0X848095C9181E0498L;
	private Integer ecUserId; // type in db: int(11)
	private String id; // type in db: varchar(50)
	private String registerIP; // type in db: varchar(50)

	public Integer getEcUserId() {
		return this.ecUserId;
	}
	public void setEcUserId(Integer ecUserId) {
		this.ecUserId = ecUserId;
	}

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getRegisterIP() {
		return this.registerIP;
	}
	public void setRegisterIP(String registerIP) {
		this.registerIP = registerIP;
	}


	@Override
	public String toString() {
		return "TempCustomer20111021 [ecUserId=" + ecUserId + ", id=" + id + ", registerIP=" + registerIP + "]";
	}
}

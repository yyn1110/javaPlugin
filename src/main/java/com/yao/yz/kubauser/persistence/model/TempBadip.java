package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempBadip implements Serializable {
	private static final long serialVersionUID = 0X2CDB78559D4FA1F3L;
	private String ip; // type in db: varchar(20)

	public String getIp() {
		return this.ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}


	@Override
	public String toString() {
		return "TempBadip [ip=" + ip + "]";
	}
}

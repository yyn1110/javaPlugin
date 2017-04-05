package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class TempBaduserid implements Serializable {
	private static final long serialVersionUID = 0X195EBB75BF9784E6L;
	private Integer userid; // type in db: int(11)
	private String 会员级别; // type in db: varchar(5)

	public Integer getUserid() {
		return this.userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String get会员级别() {
		return this.会员级别;
	}
	public void set会员级别(String 会员级别) {
		this.会员级别 = 会员级别;
	}


	@Override
	public String toString() {
		return "TempBaduserid [userid=" + userid + ", 会员级别=" + 会员级别 + "]";
	}
}

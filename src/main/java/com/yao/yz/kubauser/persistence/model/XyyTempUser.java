package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class XyyTempUser implements Serializable {
	private static final long serialVersionUID = 0X617089E6DB4C2994L;
	private String userName; // type in db: varchar(150)
	private Integer score; // type in db: int(11)
	private String syscomment; // type in db: varchar(50)

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getScore() {
		return this.score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}

	public String getSyscomment() {
		return this.syscomment;
	}
	public void setSyscomment(String syscomment) {
		this.syscomment = syscomment;
	}


	@Override
	public String toString() {
		return "XyyTempUser [userName=" + userName + ", score=" + score + ", syscomment=" + syscomment + "]";
	}
}

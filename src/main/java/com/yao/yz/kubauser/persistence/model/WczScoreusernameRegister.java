package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class WczScoreusernameRegister implements Serializable {
	private static final long serialVersionUID = 0X9F91A7B99D0A5039L;
	private Integer score; // type in db: int(11)
	private String username; // type in db: varchar(50)
	private java.util.Date datetime; // type in db: datetime
	private java.util.Date createdate; // type in db: datetime
	private String registerip; // type in db: varchar(50)
	private Integer isfei; // type in db: int(11)

	public Integer getScore() {
		return this.score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public java.util.Date getDatetime() {
		return this.datetime;
	}
	public void setDatetime(java.util.Date datetime) {
		this.datetime = datetime;
	}

	public java.util.Date getCreatedate() {
		return this.createdate;
	}
	public void setCreatedate(java.util.Date createdate) {
		this.createdate = createdate;
	}

	public String getRegisterip() {
		return this.registerip;
	}
	public void setRegisterip(String registerip) {
		this.registerip = registerip;
	}

	public Integer getIsfei() {
		return this.isfei;
	}
	public void setIsfei(Integer isfei) {
		this.isfei = isfei;
	}


	@Override
	public String toString() {
		return "WczScoreusernameRegister [score=" + score + ", username=" + username + ", datetime=" + datetime + ", createdate=" + createdate + ", registerip=" + registerip + ", isfei=" + isfei + "]";
	}
}

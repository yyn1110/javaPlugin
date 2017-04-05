package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class WczScoreusername implements Serializable {
	private static final long serialVersionUID = 0X9831592509378952L;
	private Integer score; // type in db: int(11)
	private String username; // type in db: varchar(50)
	private java.util.Date datetime; // type in db: datetime

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


	@Override
	public String toString() {
		return "WczScoreusername [score=" + score + ", username=" + username + ", datetime=" + datetime + "]";
	}
}

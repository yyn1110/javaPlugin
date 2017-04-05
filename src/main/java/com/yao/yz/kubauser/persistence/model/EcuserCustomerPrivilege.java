package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserCustomerPrivilege implements Serializable {
	private static final long serialVersionUID = 0X4FAF564C5FA7307BL;
	private String userName; // type in db: varchar(150)
	private Integer oldScore; // type in db: int(4)
	private Integer newScore; // type in db: int(4)
	private Integer runFlag; // type in db: int(4)
	private Integer id; // type in db: int(8)
	private Integer latestScore; // type in db: int(11)

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getOldScore() {
		return this.oldScore;
	}
	public void setOldScore(Integer oldScore) {
		this.oldScore = oldScore;
	}

	public Integer getNewScore() {
		return this.newScore;
	}
	public void setNewScore(Integer newScore) {
		this.newScore = newScore;
	}

	public Integer getRunFlag() {
		return this.runFlag;
	}
	public void setRunFlag(Integer runFlag) {
		this.runFlag = runFlag;
	}

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLatestScore() {
		return this.latestScore;
	}
	public void setLatestScore(Integer latestScore) {
		this.latestScore = latestScore;
	}


	@Override
	public String toString() {
		return "EcuserCustomerPrivilege [userName=" + userName + ", oldScore=" + oldScore + ", newScore=" + newScore + ", runFlag=" + runFlag + ", id=" + id + ", latestScore=" + latestScore + "]";
	}
}

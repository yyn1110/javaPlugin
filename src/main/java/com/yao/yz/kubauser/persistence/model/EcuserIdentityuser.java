package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserIdentityuser implements Serializable {
	private static final long serialVersionUID = 0XBF2AB766A89D94C0L;
	private Integer userId; // type in db: int(11)
	private Integer uId; // type in db: int(11)
	private String userName; // type in db: varchar(50)
	private String currentRole; // type in db: varchar(50)
	private Integer userLevelId; // type in db: int(11)
	private String userLevelName; // type in db: varchar(50)
	private Integer userScore; // type in db: int(11)
	private java.math.BigDecimal accountFee; // type in db: decimal(10,2)
	private Integer orderFinishCount; // type in db: int(11)

	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUId() {
		return this.uId;
	}
	public void setUId(Integer uId) {
		this.uId = uId;
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCurrentRole() {
		return this.currentRole;
	}
	public void setCurrentRole(String currentRole) {
		this.currentRole = currentRole;
	}

	public Integer getUserLevelId() {
		return this.userLevelId;
	}
	public void setUserLevelId(Integer userLevelId) {
		this.userLevelId = userLevelId;
	}

	public String getUserLevelName() {
		return this.userLevelName;
	}
	public void setUserLevelName(String userLevelName) {
		this.userLevelName = userLevelName;
	}

	public Integer getUserScore() {
		return this.userScore;
	}
	public void setUserScore(Integer userScore) {
		this.userScore = userScore;
	}

	public java.math.BigDecimal getAccountFee() {
		return this.accountFee;
	}
	public void setAccountFee(java.math.BigDecimal accountFee) {
		this.accountFee = accountFee;
	}

	public Integer getOrderFinishCount() {
		return this.orderFinishCount;
	}
	public void setOrderFinishCount(Integer orderFinishCount) {
		this.orderFinishCount = orderFinishCount;
	}


	@Override
	public String toString() {
		return "EcuserIdentityuser [userId=" + userId + ", uId=" + uId + ", userName=" + userName + ", currentRole=" + currentRole + ", userLevelId=" + userLevelId + ", userLevelName=" + userLevelName + ", userScore=" + userScore + ", accountFee=" + accountFee + ", orderFinishCount=" + orderFinishCount + "]";
	}
}

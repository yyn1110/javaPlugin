package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserLoginuser implements Serializable {
	private static final long serialVersionUID = 0X13822D3983CDDF7EL;
	private String token; // type in db: varchar(36)
	private Integer userId; // type in db: int(11)
	private String userName; // type in db: varchar(50)
	private java.util.Date loginTime; // type in db: datetime
	private java.util.Date expiredTime; // type in db: datetime
	private String userIp; // type in db: varchar(20)
	private java.util.Date logoutTime; // type in db: datetime
	private Integer isUse; // type in db: int(1)
	private String sessionId; // type in db: varchar(50)

	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public java.util.Date getLoginTime() {
		return this.loginTime;
	}
	public void setLoginTime(java.util.Date loginTime) {
		this.loginTime = loginTime;
	}

	public java.util.Date getExpiredTime() {
		return this.expiredTime;
	}
	public void setExpiredTime(java.util.Date expiredTime) {
		this.expiredTime = expiredTime;
	}

	public String getUserIp() {
		return this.userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public java.util.Date getLogoutTime() {
		return this.logoutTime;
	}
	public void setLogoutTime(java.util.Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	public Integer getIsUse() {
		return this.isUse;
	}
	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	public String getSessionId() {
		return this.sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}


	@Override
	public String toString() {
		return "EcuserLoginuser [token=" + token + ", userId=" + userId + ", userName=" + userName + ", loginTime=" + loginTime + ", expiredTime=" + expiredTime + ", userIp=" + userIp + ", logoutTime=" + logoutTime + ", isUse=" + isUse + ", sessionId=" + sessionId + "]";
	}
}

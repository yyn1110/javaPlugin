package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserOnlineuser implements Serializable {
	private static final long serialVersionUID = 0X884F71764E868471L;
	private Integer userId; // type in db: int(11)
	private Integer uId; // type in db: int(11)
	private String userName; // type in db: varchar(50)
	private String nickName; // type in db: varchar(50)
	private java.util.Date loginTime; // type in db: datetime
	private java.util.Date lastTime; // type in db: datetime
	private String lastActionUrl; // type in db: varchar(250)
	private String loginIp; // type in db: varchar(50)
	private Integer isGuest; // type in db: tinyint(4)
	private String sessionId; // type in db: varchar(200)

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

	public String getNickName() {
		return this.nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public java.util.Date getLoginTime() {
		return this.loginTime;
	}
	public void setLoginTime(java.util.Date loginTime) {
		this.loginTime = loginTime;
	}

	public java.util.Date getLastTime() {
		return this.lastTime;
	}
	public void setLastTime(java.util.Date lastTime) {
		this.lastTime = lastTime;
	}

	public String getLastActionUrl() {
		return this.lastActionUrl;
	}
	public void setLastActionUrl(String lastActionUrl) {
		this.lastActionUrl = lastActionUrl;
	}

	public String getLoginIp() {
		return this.loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Integer getIsGuest() {
		return this.isGuest;
	}
	public void setIsGuest(Integer isGuest) {
		this.isGuest = isGuest;
	}

	public String getSessionId() {
		return this.sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}


	@Override
	public String toString() {
		return "EcuserOnlineuser [userId=" + userId + ", uId=" + uId + ", userName=" + userName + ", nickName=" + nickName + ", loginTime=" + loginTime + ", lastTime=" + lastTime + ", lastActionUrl=" + lastActionUrl + ", loginIp=" + loginIp + ", isGuest=" + isGuest + ", sessionId=" + sessionId + "]";
	}
}

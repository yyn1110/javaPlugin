package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EdmPush implements Serializable {
	private static final long serialVersionUID = 0XE79209F6293A59B2L;
	private Integer userId; // type in db: int(11)
	private Integer pushEmail; // type in db: int(11)
	private Integer pushSms; // type in db: int(11)
	private Integer pushApp; // type in db: int(11)
	private Integer usePc; // type in db: int(11)
	private Integer useApp; // type in db: int(11)
	private String pPush; // type in db: varchar(255)
	private java.util.Date updateTime; // type in db: timestamp

	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPushEmail() {
		return this.pushEmail;
	}
	public void setPushEmail(Integer pushEmail) {
		this.pushEmail = pushEmail;
	}

	public Integer getPushSms() {
		return this.pushSms;
	}
	public void setPushSms(Integer pushSms) {
		this.pushSms = pushSms;
	}

	public Integer getPushApp() {
		return this.pushApp;
	}
	public void setPushApp(Integer pushApp) {
		this.pushApp = pushApp;
	}

	public Integer getUsePc() {
		return this.usePc;
	}
	public void setUsePc(Integer usePc) {
		this.usePc = usePc;
	}

	public Integer getUseApp() {
		return this.useApp;
	}
	public void setUseApp(Integer useApp) {
		this.useApp = useApp;
	}

	public String getPPush() {
		return this.pPush;
	}
	public void setPPush(String pPush) {
		this.pPush = pPush;
	}

	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}


	@Override
	public String toString() {
		return "EdmPush [userId=" + userId + ", pushEmail=" + pushEmail + ", pushSms=" + pushSms + ", pushApp=" + pushApp + ", usePc=" + usePc + ", useApp=" + useApp + ", pPush=" + pPush + ", updateTime=" + updateTime + "]";
	}
}

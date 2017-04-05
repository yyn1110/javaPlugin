package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserAccountBak implements Serializable {
	private static final long serialVersionUID = 0X69B23512874862A5L;
	private Integer accountId; // type in db: int(11)
	private Integer ecuserId; // type in db: int(18)
	private Double account; // type in db: double(11,2)
	private Double freezeAccount; // type in db: double(11,2)
	private Double backCount; // type in db: double(11,2)
	private Double freezeBackCount; // type in db: double(11,2)
	private java.util.Date lastModifyDate; // type in db: date
	private String userName; // type in db: varchar(200)

	public Integer getAccountId() {
		return this.accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getEcuserId() {
		return this.ecuserId;
	}
	public void setEcuserId(Integer ecuserId) {
		this.ecuserId = ecuserId;
	}

	public Double getAccount() {
		return this.account;
	}
	public void setAccount(Double account) {
		this.account = account;
	}

	public Double getFreezeAccount() {
		return this.freezeAccount;
	}
	public void setFreezeAccount(Double freezeAccount) {
		this.freezeAccount = freezeAccount;
	}

	public Double getBackCount() {
		return this.backCount;
	}
	public void setBackCount(Double backCount) {
		this.backCount = backCount;
	}

	public Double getFreezeBackCount() {
		return this.freezeBackCount;
	}
	public void setFreezeBackCount(Double freezeBackCount) {
		this.freezeBackCount = freezeBackCount;
	}

	public java.util.Date getLastModifyDate() {
		return this.lastModifyDate;
	}
	public void setLastModifyDate(java.util.Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public String toString() {
		return "EcuserAccountBak [accountId=" + accountId + ", ecuserId=" + ecuserId + ", account=" + account + ", freezeAccount=" + freezeAccount + ", backCount=" + backCount + ", freezeBackCount=" + freezeBackCount + ", lastModifyDate=" + lastModifyDate + ", userName=" + userName + "]";
	}
}

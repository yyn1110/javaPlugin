package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserPrivateCustomLog implements Serializable {
	private static final long serialVersionUID = 0XC5CFC5F9AC316BA0L;
	private Integer id; // type in db: int(11)
	private Integer ecUserId; // type in db: int(11)
	private String privateCustom; // type in db: varchar(100)
	private Integer privateRole; // type in db: int(11)
	private java.util.Date roleCreateDate; // type in db: datetime
	private java.util.Date customCreateDate; // type in db: datetime
	private Integer operationType; // type in db: tinyint(2)

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEcUserId() {
		return this.ecUserId;
	}
	public void setEcUserId(Integer ecUserId) {
		this.ecUserId = ecUserId;
	}

	public String getPrivateCustom() {
		return this.privateCustom;
	}
	public void setPrivateCustom(String privateCustom) {
		this.privateCustom = privateCustom;
	}

	public Integer getPrivateRole() {
		return this.privateRole;
	}
	public void setPrivateRole(Integer privateRole) {
		this.privateRole = privateRole;
	}

	public java.util.Date getRoleCreateDate() {
		return this.roleCreateDate;
	}
	public void setRoleCreateDate(java.util.Date roleCreateDate) {
		this.roleCreateDate = roleCreateDate;
	}

	public java.util.Date getCustomCreateDate() {
		return this.customCreateDate;
	}
	public void setCustomCreateDate(java.util.Date customCreateDate) {
		this.customCreateDate = customCreateDate;
	}

	public Integer getOperationType() {
		return this.operationType;
	}
	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}


	@Override
	public String toString() {
		return "EcuserPrivateCustomLog [id=" + id + ", ecUserId=" + ecUserId + ", privateCustom=" + privateCustom + ", privateRole=" + privateRole + ", roleCreateDate=" + roleCreateDate + ", customCreateDate=" + customCreateDate + ", operationType=" + operationType + "]";
	}
}

package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserCustomerRecord implements Serializable {
	private static final long serialVersionUID = 0X6FC66F94CF8A6858L;
	private Integer id; // type in db: int(11)
	private java.util.Date modifyDate; // type in db: timestamp
	private Integer modifyType; // type in db: int(11)
	private String modifyTypeName; // type in db: varchar(50)
	private String modifyBefore; // type in db: varchar(100)
	private String modifyAfter; // type in db: varchar(100)
	private String operator; // type in db: varchar(50)
	private String operateIp; // type in db: varchar(50)
	private Integer ecUserId; // type in db: int(11)

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public java.util.Date getModifyDate() {
		return this.modifyDate;
	}
	public void setModifyDate(java.util.Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Integer getModifyType() {
		return this.modifyType;
	}
	public void setModifyType(Integer modifyType) {
		this.modifyType = modifyType;
	}

	public String getModifyTypeName() {
		return this.modifyTypeName;
	}
	public void setModifyTypeName(String modifyTypeName) {
		this.modifyTypeName = modifyTypeName;
	}

	public String getModifyBefore() {
		return this.modifyBefore;
	}
	public void setModifyBefore(String modifyBefore) {
		this.modifyBefore = modifyBefore;
	}

	public String getModifyAfter() {
		return this.modifyAfter;
	}
	public void setModifyAfter(String modifyAfter) {
		this.modifyAfter = modifyAfter;
	}

	public String getOperator() {
		return this.operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperateIp() {
		return this.operateIp;
	}
	public void setOperateIp(String operateIp) {
		this.operateIp = operateIp;
	}

	public Integer getEcUserId() {
		return this.ecUserId;
	}
	public void setEcUserId(Integer ecUserId) {
		this.ecUserId = ecUserId;
	}


	@Override
	public String toString() {
		return "EcuserCustomerRecord [id=" + id + ", modifyDate=" + modifyDate + ", modifyType=" + modifyType + ", modifyTypeName=" + modifyTypeName + ", modifyBefore=" + modifyBefore + ", modifyAfter=" + modifyAfter + ", operator=" + operator + ", operateIp=" + operateIp + ", ecUserId=" + ecUserId + "]";
	}
}

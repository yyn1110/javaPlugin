package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class EcuserAccountRecord implements Serializable {
	private static final long serialVersionUID = 0X2B22683695667C52L;
	private Integer id; // type in db: int(11)
	private Integer accountId; // type in db: int(11)
	private java.util.Date changeDate; // type in db: timestamp
	private Double acountChange; // type in db: double
	private Double backCountChange; // type in db: double
	private String orderId; // type in db: varchar(30)
	private String remark; // type in db: varchar(200)
	private String operator; // type in db: varchar(50)
	private String typeName; // type in db: varchar(100)
	private Integer typeId; // type in db: int(11)
	private Integer ecuserId; // type in db: int(11)
	private Integer status; // type in db: int(2)
	private java.util.Date applyTime; // type in db: timestamp
	private java.util.Date finishTime; // type in db: timestamp
	private java.util.Date cancelTime; // type in db: timestamp
	private java.util.Date checkDate; // type in db: timestamp
	private Double freeAccountChange; // type in db: double
	private Double freeBackCountChange; // type in db: double
	private Integer proviceId; // type in db: int(11)
	private Integer cityId; // type in db: int(11)
	private String proviceName; // type in db: varchar(50)
	private String cityName; // type in db: varchar(50)
	private String bankAccount; // type in db: varchar(50)
	private String bankName; // type in db: varchar(50)
	private String cartHolder; // type in db: varchar(50)
	private Integer refundType; // type in db: int(11)
	private String alipayAccount; // type in db: varchar(100)
	private Integer applyTypeId; // type in db: int(11)
	private String userName; // type in db: varchar(50)
	private java.util.Date orderSplitDate; // type in db: timestamp
	private java.util.Date orderPayDate; // type in db: timestamp
	private String refundOrderId; // type in db: varchar(50)
	private Integer netMode; // type in db: int(11)
	private Integer orderOrigin; // type in db: int(11)
	private String externalOrder; // type in db: varchar(50)
	private String outPayNumber; // type in db: varchar(50)
	private String checkOperator; // type in db: varchar(50)
	private Integer payMethod; // type in db: int(11)
	private Integer failReson; // type in db: int(2)
	private Integer needCheck; // type in db: int(2)
	private Double beforeAccount; // type in db: double
	private Double afterAccount; // type in db: double
	private Double beforeBackCount; // type in db: double
	private Double afterBackCount; // type in db: double

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccountId() {
		return this.accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public java.util.Date getChangeDate() {
		return this.changeDate;
	}
	public void setChangeDate(java.util.Date changeDate) {
		this.changeDate = changeDate;
	}

	public Double getAcountChange() {
		return this.acountChange;
	}
	public void setAcountChange(Double acountChange) {
		this.acountChange = acountChange;
	}

	public Double getBackCountChange() {
		return this.backCountChange;
	}
	public void setBackCountChange(Double backCountChange) {
		this.backCountChange = backCountChange;
	}

	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOperator() {
		return this.operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getTypeName() {
		return this.typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getTypeId() {
		return this.typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getEcuserId() {
		return this.ecuserId;
	}
	public void setEcuserId(Integer ecuserId) {
		this.ecuserId = ecuserId;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public java.util.Date getApplyTime() {
		return this.applyTime;
	}
	public void setApplyTime(java.util.Date applyTime) {
		this.applyTime = applyTime;
	}

	public java.util.Date getFinishTime() {
		return this.finishTime;
	}
	public void setFinishTime(java.util.Date finishTime) {
		this.finishTime = finishTime;
	}

	public java.util.Date getCancelTime() {
		return this.cancelTime;
	}
	public void setCancelTime(java.util.Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public java.util.Date getCheckDate() {
		return this.checkDate;
	}
	public void setCheckDate(java.util.Date checkDate) {
		this.checkDate = checkDate;
	}

	public Double getFreeAccountChange() {
		return this.freeAccountChange;
	}
	public void setFreeAccountChange(Double freeAccountChange) {
		this.freeAccountChange = freeAccountChange;
	}

	public Double getFreeBackCountChange() {
		return this.freeBackCountChange;
	}
	public void setFreeBackCountChange(Double freeBackCountChange) {
		this.freeBackCountChange = freeBackCountChange;
	}

	public Integer getProviceId() {
		return this.proviceId;
	}
	public void setProviceId(Integer proviceId) {
		this.proviceId = proviceId;
	}

	public Integer getCityId() {
		return this.cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getProviceName() {
		return this.proviceName;
	}
	public void setProviceName(String proviceName) {
		this.proviceName = proviceName;
	}

	public String getCityName() {
		return this.cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getBankAccount() {
		return this.bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBankName() {
		return this.bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCartHolder() {
		return this.cartHolder;
	}
	public void setCartHolder(String cartHolder) {
		this.cartHolder = cartHolder;
	}

	public Integer getRefundType() {
		return this.refundType;
	}
	public void setRefundType(Integer refundType) {
		this.refundType = refundType;
	}

	public String getAlipayAccount() {
		return this.alipayAccount;
	}
	public void setAlipayAccount(String alipayAccount) {
		this.alipayAccount = alipayAccount;
	}

	public Integer getApplyTypeId() {
		return this.applyTypeId;
	}
	public void setApplyTypeId(Integer applyTypeId) {
		this.applyTypeId = applyTypeId;
	}

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public java.util.Date getOrderSplitDate() {
		return this.orderSplitDate;
	}
	public void setOrderSplitDate(java.util.Date orderSplitDate) {
		this.orderSplitDate = orderSplitDate;
	}

	public java.util.Date getOrderPayDate() {
		return this.orderPayDate;
	}
	public void setOrderPayDate(java.util.Date orderPayDate) {
		this.orderPayDate = orderPayDate;
	}

	public String getRefundOrderId() {
		return this.refundOrderId;
	}
	public void setRefundOrderId(String refundOrderId) {
		this.refundOrderId = refundOrderId;
	}

	public Integer getNetMode() {
		return this.netMode;
	}
	public void setNetMode(Integer netMode) {
		this.netMode = netMode;
	}

	public Integer getOrderOrigin() {
		return this.orderOrigin;
	}
	public void setOrderOrigin(Integer orderOrigin) {
		this.orderOrigin = orderOrigin;
	}

	public String getExternalOrder() {
		return this.externalOrder;
	}
	public void setExternalOrder(String externalOrder) {
		this.externalOrder = externalOrder;
	}

	public String getOutPayNumber() {
		return this.outPayNumber;
	}
	public void setOutPayNumber(String outPayNumber) {
		this.outPayNumber = outPayNumber;
	}

	public String getCheckOperator() {
		return this.checkOperator;
	}
	public void setCheckOperator(String checkOperator) {
		this.checkOperator = checkOperator;
	}

	public Integer getPayMethod() {
		return this.payMethod;
	}
	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	public Integer getFailReson() {
		return this.failReson;
	}
	public void setFailReson(Integer failReson) {
		this.failReson = failReson;
	}

	public Integer getNeedCheck() {
		return this.needCheck;
	}
	public void setNeedCheck(Integer needCheck) {
		this.needCheck = needCheck;
	}

	public Double getBeforeAccount() {
		return this.beforeAccount;
	}
	public void setBeforeAccount(Double beforeAccount) {
		this.beforeAccount = beforeAccount;
	}

	public Double getAfterAccount() {
		return this.afterAccount;
	}
	public void setAfterAccount(Double afterAccount) {
		this.afterAccount = afterAccount;
	}

	public Double getBeforeBackCount() {
		return this.beforeBackCount;
	}
	public void setBeforeBackCount(Double beforeBackCount) {
		this.beforeBackCount = beforeBackCount;
	}

	public Double getAfterBackCount() {
		return this.afterBackCount;
	}
	public void setAfterBackCount(Double afterBackCount) {
		this.afterBackCount = afterBackCount;
	}


	@Override
	public String toString() {
		return "EcuserAccountRecord [id=" + id + ", accountId=" + accountId + ", changeDate=" + changeDate + ", acountChange=" + acountChange + ", backCountChange=" + backCountChange + ", orderId=" + orderId + ", remark=" + remark + ", operator=" + operator + ", typeName=" + typeName + ", typeId=" + typeId + ", ecuserId=" + ecuserId + ", status=" + status + ", applyTime=" + applyTime + ", finishTime=" + finishTime + ", cancelTime=" + cancelTime + ", checkDate=" + checkDate + ", freeAccountChange=" + freeAccountChange + ", freeBackCountChange=" + freeBackCountChange + ", proviceId=" + proviceId + ", cityId=" + cityId + ", proviceName=" + proviceName + ", cityName=" + cityName + ", bankAccount=" + bankAccount + ", bankName=" + bankName + ", cartHolder=" + cartHolder + ", refundType=" + refundType + ", alipayAccount=" + alipayAccount + ", applyTypeId=" + applyTypeId + ", userName=" + userName + ", orderSplitDate=" + orderSplitDate + ", orderPayDate=" + orderPayDate + ", refundOrderId=" + refundOrderId + ", netMode=" + netMode + ", orderOrigin=" + orderOrigin + ", externalOrder=" + externalOrder + ", outPayNumber=" + outPayNumber + ", checkOperator=" + checkOperator + ", payMethod=" + payMethod + ", failReson=" + failReson + ", needCheck=" + needCheck + ", beforeAccount=" + beforeAccount + ", afterAccount=" + afterAccount + ", beforeBackCount=" + beforeBackCount + ", afterBackCount=" + afterBackCount + "]";
	}
}

package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class YdyVoucherLog implements Serializable {
	private static final long serialVersionUID = 0X77FD456593195997L;
	private Integer id; // type in db: int(11)
	private String customerId; // type in db: varchar(60)
	private String voucherId; // type in db: varchar(200)
	private Integer status; // type in db: int(11)
	private String recipeCode; // type in db: longtext
	private String recipeUrl; // type in db: longtext
	private java.util.Date createtime; // type in db: timestamp
	private java.util.Date activitytime; // type in db: timestamp
	private java.util.Date closetime; // type in db: timestamp
	private String operaterId; // type in db: varchar(50)
	private String operaterName; // type in db: varchar(50)

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerId() {
		return this.customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getVoucherId() {
		return this.voucherId;
	}
	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRecipeCode() {
		return this.recipeCode;
	}
	public void setRecipeCode(String recipeCode) {
		this.recipeCode = recipeCode;
	}

	public String getRecipeUrl() {
		return this.recipeUrl;
	}
	public void setRecipeUrl(String recipeUrl) {
		this.recipeUrl = recipeUrl;
	}

	public java.util.Date getCreatetime() {
		return this.createtime;
	}
	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public java.util.Date getActivitytime() {
		return this.activitytime;
	}
	public void setActivitytime(java.util.Date activitytime) {
		this.activitytime = activitytime;
	}

	public java.util.Date getClosetime() {
		return this.closetime;
	}
	public void setClosetime(java.util.Date closetime) {
		this.closetime = closetime;
	}

	public String getOperaterId() {
		return this.operaterId;
	}
	public void setOperaterId(String operaterId) {
		this.operaterId = operaterId;
	}

	public String getOperaterName() {
		return this.operaterName;
	}
	public void setOperaterName(String operaterName) {
		this.operaterName = operaterName;
	}


	@Override
	public String toString() {
		return "YdyVoucherLog [id=" + id + ", customerId=" + customerId + ", voucherId=" + voucherId + ", status=" + status + ", recipeCode=" + recipeCode + ", recipeUrl=" + recipeUrl + ", createtime=" + createtime + ", activitytime=" + activitytime + ", closetime=" + closetime + ", operaterId=" + operaterId + ", operaterName=" + operaterName + "]";
	}
}

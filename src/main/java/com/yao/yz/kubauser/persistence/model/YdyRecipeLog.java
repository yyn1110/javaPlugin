package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class YdyRecipeLog implements Serializable {
	private static final long serialVersionUID = 0X2B569ADBA7135A57L;
	private Integer id; // type in db: int(11)
	private String voucherId; // type in db: varchar(60)
	private String recipeId; // type in db: varchar(60)
	private String recipeUrl; // type in db: longtext
	private java.util.Date createtime; // type in db: timestamp
	private Integer callBack; // type in db: int(11)
	private String orderNo; // type in db: varchar(80)
	private Integer isDel; // type in db: int(11)
	private String operaterId; // type in db: varchar(50)
	private String operaterName; // type in db: varchar(50)

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getVoucherId() {
		return this.voucherId;
	}
	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}

	public String getRecipeId() {
		return this.recipeId;
	}
	public void setRecipeId(String recipeId) {
		this.recipeId = recipeId;
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

	public Integer getCallBack() {
		return this.callBack;
	}
	public void setCallBack(Integer callBack) {
		this.callBack = callBack;
	}

	public String getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getIsDel() {
		return this.isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
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
		return "YdyRecipeLog [id=" + id + ", voucherId=" + voucherId + ", recipeId=" + recipeId + ", recipeUrl=" + recipeUrl + ", createtime=" + createtime + ", callBack=" + callBack + ", orderNo=" + orderNo + ", isDel=" + isDel + ", operaterId=" + operaterId + ", operaterName=" + operaterName + "]";
	}
}

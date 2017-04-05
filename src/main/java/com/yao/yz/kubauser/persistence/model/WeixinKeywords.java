package com.yao.yz.kubauser.persistence.model;

import java.io.Serializable;

public class WeixinKeywords implements Serializable {
	private static final long serialVersionUID = 0X426D09C165F04A22L;
	private Integer id; // type in db: int(20)
	private String showName; // type in db: varchar(50)
	private String content; // type in db: varchar(100)
	private String type; // type in db: varchar(10)
	private String category; // type in db: varchar(10)
	private Integer shopId; // type in db: int(20)
	private String replyType; // type in db: varchar(20)
	private String replyMethod; // type in db: varchar(10)
	private Integer status; // type in db: int(11)
	private java.util.Date inputeDate; // type in db: datetime
	private String inputer; // type in db: varchar(20)

	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getShowName() {
		return this.showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return this.category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getShopId() {
		return this.shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getReplyType() {
		return this.replyType;
	}
	public void setReplyType(String replyType) {
		this.replyType = replyType;
	}

	public String getReplyMethod() {
		return this.replyMethod;
	}
	public void setReplyMethod(String replyMethod) {
		this.replyMethod = replyMethod;
	}

	public Integer getStatus() {
		return this.status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public java.util.Date getInputeDate() {
		return this.inputeDate;
	}
	public void setInputeDate(java.util.Date inputeDate) {
		this.inputeDate = inputeDate;
	}

	public String getInputer() {
		return this.inputer;
	}
	public void setInputer(String inputer) {
		this.inputer = inputer;
	}


	@Override
	public String toString() {
		return "WeixinKeywords [id=" + id + ", showName=" + showName + ", content=" + content + ", type=" + type + ", category=" + category + ", shopId=" + shopId + ", replyType=" + replyType + ", replyMethod=" + replyMethod + ", status=" + status + ", inputeDate=" + inputeDate + ", inputer=" + inputer + "]";
	}
}
